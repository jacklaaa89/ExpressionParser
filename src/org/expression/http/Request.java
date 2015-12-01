package org.expression.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jack
 */
public class Request extends Core {
    
    private static final String DEFAULT_HTTP_VERSION = "1.1";
    private String version = DEFAULT_HTTP_VERSION;
    
    private final Map<String, Parameter> params;
    private String requestPayload = null;
    private RequestType requestType;
    private String uri;
    
    private Request() {
        super();
        //set the default headers, request type and status code.
        requestType = RequestType.GET;
        params = new HashMap<>();
        
    }
    
    private void setQueryParam(String name, String value) {
        this.params.put(name, new Parameter(name, value));
    }
    
    private void setHttpVersion(String version) {
        try {
            Double.parseDouble(version);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.version = version;
    }
    
    public Iterator getQueryParams() {
        List<Parameter> hs = new ArrayList<>();
        for (Map.Entry<String, Parameter> header : params.entrySet()) {
            hs.add(header.getValue());
        }
        return hs.iterator();
    }
    
    public Parameter getQueryParam(String name) {
        if(!this.hasQueryParam(name)) {
            return null;
        }
        return params.get(name);
    }
    
    public boolean hasQueryParam(String name) {
        return params.containsKey(name);
    }
    
    
    
    public double getVersion() {
        return Double.parseDouble(this.version);
    }
    
    public String getFormattedVersion() {
        return "HTTP/" + this.version;
    }
    
    public RequestType getRequestType() {
        return this.requestType;
    }
    
    private void setRequestType(RequestType type) {
        this.requestType = type;
    }
    
    public String getURI() {
        return this.uri;
    }
    
    private void setURI(String uri) {
        this.uri = uri;
    }
    
    public static Request parseRequest(String request) {
        String[] lines = request.split("\r\n");
        return Request.parseRequest(lines);
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getRequestType()).append(" ").append(getURI()).append(" ").append(getFormattedVersion()).append("\r\n");
        Iterator i = getHeaders();
        while(i.hasNext()) {
            b.append(i.next().toString()).append("\r\n");
        }
        b.append("\r\n");
        return b.toString();
    }
    
    public static Request parseRequest(String[] lines) {
        //get the request type etc.
        String[] first = lines[0].trim().split(" ");
        if(first.length != 3) {
            return null; //error.
        }
        Request re = new Request();
        re.setRequestType(RequestType.valueOf(first[0]));
        re.setURI(first[1]);
        
        //parse the URI from the query params.
        String[] s = re.getURI().trim().split("\\?");
        if(s.length == 2) {
            re.setURI(s[0]);
            String[] en = s[1].trim().split("&");
            for(int i = 0; i < en.length; i++) {
                String[] kv = en[i].trim().split("=");
                if(kv.length > 0) {
                    re.setQueryParam(kv[0], (kv.length > 1) ? kv[1] : null);
                }
            }
        }
        
        String[] htv = first[2].trim().split("/");
        if(htv.length != 2) {
            return null; //another error.
        }
        re.setHttpVersion(htv[1]);
        for(int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(": ");
            if(line.length == 2) {
                re.setHeader(line[0], line[1]);
            }
        }
        return re;
    }
    
}
