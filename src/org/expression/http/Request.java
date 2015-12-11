package org.expression.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.expression.api.exception.DispatchException;
import org.expression.http.data.Data;
import org.expression.http.data.Format;

/**
 * An encapsulation of a HTTP Request.
 * @author Jack Timblin
 */
public class Request extends Core {
    
    /**
     * The default HTTP version type of accept.
     */
    private static final String DEFAULT_HTTP_VERSION = "1.1";
    
    /**
     * The provided HTTP version.
     */
    private String version = DEFAULT_HTTP_VERSION;
    
    /**
     * The default input format type for the request. (XML)
     */
    private static final FormatType DEFAULT_FORMAT = FormatType.XML;
    
    /**
     * The provided format type for the request.
     */
    private FormatType format = DEFAULT_FORMAT;
    
    /**
     * The provided URI parameters.
     */
    private final Map<String, Parameter> params;
    
    /**
     * The POST/PUT/UPDATE request payload.
     */
    private String requestPayload = null;
    
    /**
     * The type of request.
     */
    private RequestType requestType;
    
    /**
     * The URI for the request.
     */
    private String uri;
    
    /**
     * Initialises a new Request, setting default values.
     */
    private Request() {
        super();
        //set the default headers, request type and status code.
        requestType = RequestType.GET;
        params = new HashMap<>();
    }
    
    /**
     * Set a query parameter.
     * @param name the name of the parameter.
     * @param value the value.
     */
    private void setQueryParam(String name, String value) {
        this.params.put(name, new Parameter(name, value));
    }
    
    /**
     * Set the used HTTP version.
     * @param version the used HTTP version.
     */
    private void setHttpVersion(String version) {
        try {
            Double.parseDouble(version);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.version = version;
    }
    
    /**
     * Gets an iterator for the defined Query Parameters.
     * @return an iterator for the query parameters.
     */
    public Iterator getQueryParams() {
        List<Parameter> hs = new ArrayList<>();
        params.entrySet().stream().forEach((header) -> {
            hs.add(header.getValue());
        });
        return hs.iterator();
    }
    
    /**
     * Determines whether this request is of a certain HTTP Method.
     * @param type the request type.
     * @return true if this request is if {@code type}, false otherwise.
     */
    public boolean is(RequestType type) {
        return this.requestType == type;
    }
    
    /**
     * Determines if this request is a HTTP POST request.
     * @return true if this request is post, false otherwise.
     */
    public boolean isPost() {
        return is(RequestType.POST);
    }
    
    /**
     * Determines if this request is a HTTP GET request.
     * @return true if this request is post, false otherwise.
     */
    public boolean isGet() {
        return is(RequestType.GET);
    }
    
    /**
     * Sets the request payload for this request, this is only valid for
     * certain types of request so we need to parse and determine the HTTP method
     * before attempting to retrieve the payload.
     * @param payload the data with the request.
     */
    protected void setRequestPayload(String payload) {
        this.requestPayload = payload;
    }
    
    /**
     * Gets the currently set request payload. This will be an empty string
     * if no payload was set or the method is not applicable to receive a payload.
     * @return the request payload.
     */
    public String getRequestPayload() {
        return this.requestPayload;
    }
    
    /**
     * Gets the type of input which was used and expected back.
     * @return the format type.
     */
    public FormatType getFormatType() {
        return this.format;
    }
    
    /**
     * Sets the used format type. this is defined as the last {@code.(format_ex)} in the URI.
     * @param type the format type, the default is XML if this is not defined.
     */
    private void setFormatType(FormatType type) {
        this.format = type;
    }
    
    /**
     * Gets the double representation of the HTTP version provided.
     * @return the double HTTP version provided.
     * @throws NumberFormatException if the version cannot be parsed to a valid double.
     */
    public double getVersion() throws NumberFormatException {
        return Double.parseDouble(this.version);
    }
    
    /**
     * Gets the string representation of the version with leading "HTTP/".
     * @return the formatted HTTP version.
     */
    public String getFormattedVersion() {
        return "HTTP/" + this.version;
    }
    
    /**
     * Generates a Data object from this request object.
     * @return the data object for this request.
     */
    public Data getData() {
        Format f = this.format.getFormatter();
        Data empty = new Data();
        empty.set("Request", new Data());
        Data e = (f != null) ? f.parseInput(this) : empty;
        //check if the root key is 'Request'
        if(!e.hasKey("Request") || (e.size() != 1)) {
            throw DispatchException.newInstance(
                    StatusCode.BAD_REQUEST, 
                    "Request Data starts with invalid root node.", 
                    new NullPointerException("Node 'Request' was not found at the root.")
            );
        }
        return e.get("Request");
    }
    
    /**
     * Determines if this request has a query parameter for a name.
     * @param name the name of the parameter to check for.
     * @return true if this request has a valid query parameter for the name, false otherwise.
     */
    public boolean hasQuery(String name) {
        return this.params.containsKey(name);
    }
    
    /**
     * Determines if this request has a valid request payload.
     * @return true if this request has a valid payload, false otherwise.
     */
    public boolean hasData() {
        return this.requestPayload != null && this.requestPayload.length() != 0;
    }
    
    /**
     * Gets a query parameter if it was defined.
     * @param name the name of the query parameter.
     * @return the value of the parameter, or null if it was not defined.
     */
    public String getQuery(String name) {
        return this.params.containsKey(name) ? this.params.get(name).getValue() : null; 
    }
    
    /**
     * Gets the request type. i.e POST/GET etc.
     * @return the request type.
     */
    public RequestType getRequestType() {
        return this.requestType;
    }
    
    /**
     * Sets the request type which was made. i.e POST/GET etc.
     * @param type the request type.
     */
    private void setRequestType(RequestType type) {
        this.requestType = type;
    }
    
    /**
     * Gets the provided URI.
     * @return the uri.
     */
    public String getURI() {
        return this.uri;
    }
    
    /**
     * Sets the URI provided, with the trailing format type removed if
     * it was provided.
     * @param uri the uri.
     */
    private void setURI(String uri) {
        this.uri = uri;
    }
    
    /**
     * Parses a string line into a usable Request object.
     * @param request the complete request.
     * @return a compiled Request object.
     */
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
    
    /**
     * Parses an array of string lines into a usable Request object.
     * @param lines the array of string lines from the input stream
     * @return a compiled Request object.
     */
    public static Request parseRequest(String[] lines) {
        //get the request type etc.
        String[] first = lines[0].trim().split(" ");
        if(first.length != 3) {
            return null; //error.
        }
        Request re = new Request();
        re.setRequestType(RequestType.valueOf(first[0]));
        
        //attempt to pull a type from the uri.
        String uri = first[1];
        if(uri.matches("(^.*\\/[^/]*)(\\.[^\\.\\/]*)$")) {
            String ex = uri.replaceFirst("(^.*\\/[^/]*)(\\.[^\\.\\/]*)$", "$2");
            uri = uri.replaceFirst("(^.*\\/[^/]*)(\\.[^\\.\\/]*)$", "$1");
            for(FormatType type : FormatType.values()) {
                if(type.matches(ex)) {
                    re.setFormatType(type);
                    break;
                }
            }
        }
        
        re.setURI(uri);
        
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
