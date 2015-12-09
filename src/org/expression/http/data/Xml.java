package org.expression.http.data;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;
import org.expression.http.Request;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Formatter class which handles XML input and output.
 * @author Jack Timblin
 */
public class Xml implements Format {

    @Override
    public String getFormattedResponse(Data output) {
        if(output.isArray()) {
            //root entry cannot be an array.
            return "<InvalidOutputException/>";
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.newDocument();
            Node root = d.createElement("Response");
            append(output, root, d);
            d.appendChild(root);
            DOMSource source = new DOMSource(d);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(source, result);
            return writer.toString();
        } catch(Exception e) {
            e.printStackTrace();
            return "<InvalidOutputException/>";
        }
    }
    
    /**
     * Appends an data entry to the document at {@code node}.
     * @param output the output append.
     * @param node the node to append the output too.
     * @param doc the overall documents to create elements etc.
     */
    private void append(Data output, Node node, Document doc) {
        output.stream().forEach((entry) -> {
            String attr = entry.getKey().toString();
            if(output.isArray()) {
                attr = node.getNodeName() + "_" +  attr;
            }
            Node e = doc.createElement(attr);
            Data v = entry.getValue();
            if(v.hasValue()) {
                e.appendChild(doc.createTextNode(v.toString()));
            } else {
                append(v, e, doc);
            }
            node.appendChild(e);
        });
    }

    @Override
    public Data parseInput(Request request) {
        Data d = new Data();
        if(request.getRequestPayload().length() == 0) {
            return d;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(request.getRequestPayload()));
            Document doc = builder.parse(is);
            
            d = traverse(doc.getDocumentElement(), d);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new Data();
        }
        return d;
    }
    
    /**
     * Traverses each node in a document recursively and generates a valid data entry.
     * @param node the current node to visit
     * @param data the current data object.
     * @return the updated data object for this particular node.
     */
    private Data traverse(Node node, Data data) {
        String name = node.getNodeName();
        int index = 0;
        Data ar = null;
        if(data.hasKey(name)) {
            //get the element there.
            Data ne = data.get(name);
            if(!ne.isArray()) {
                ar = new Data();
                ar.set(index, ne);
            } else {
                ar = ne;
            }
            index = ar.size();
        }
        Data content;
        boolean hasElementNodes = false;
        NodeList list = node.getChildNodes();
        for(int i = 0; i < list.getLength(); i++) {
            Node currentNode = list.item(i);
            if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
               hasElementNodes = true;
            }
        }
        if(hasElementNodes) {
            Data e = new Data();
            for(int i = 0; i < list.getLength(); i++) {
                Node currentNode = list.item(i);
                if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
                   e = traverse(currentNode, e);
                }
            }
            content = e;
        } else {
            content = new Data(node.getTextContent().trim());
        }
        if(ar != null) {
            ar.set(index, content);
            data.set(name, ar);
        } else {
            data.set(name, content);
        }
        return data;
    }
    
}
