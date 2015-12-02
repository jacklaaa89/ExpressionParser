package org.expression.http;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Jack
 */
public class Response extends Core {
    
    private StatusCode code;
    private String responsePayload;
    private final static String HTTP_VERSION = "1.1";
    private String statusCodeMessage = null;
    
    private Response() {
        super();
        this.setHeader("Content-Type", "application/json");
        this.setHeader("Server", "ExpressionParser_V1.0");
        code = StatusCode.OK;
        responsePayload = "";
    }
    
    private void setStatusCode(StatusCode code) {
        this.code = code;
    }
    
    public StatusCode getStatusCode() {
        return this.code;
    }
    
    private void setResponse(String response) {
        this.responsePayload = response;
    }
    
    private void setStatusCodeMessage(String statusCodeMessage) {
        this.statusCodeMessage = statusCodeMessage;
    }
    
    public String getStatusCodeMessage() {
        String m = code.toString();
        String[] allowedKeywords = {"OK", "URI"};
        String[] spl = m.split("_");
        StringBuilder b = new StringBuilder();
        for(String s : spl) {
            b.append(!Arrays.asList(allowedKeywords).contains(s) ? s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase() : s);
            b.append(" ");
        }
        return (statusCodeMessage != null) ? statusCodeMessage : b.toString();
    }
    
    private String getFormattedVersion() {
        return "HTTP/" + HTTP_VERSION;
    }
    
    private double getVersion() {
        return Double.parseDouble(HTTP_VERSION);
    }
    
    public String getResponse() {
        return this.responsePayload;
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getFormattedVersion())
         .append(" ")
         .append(getStatusCode().getCode())
         .append(" ")
         .append(getStatusCodeMessage())
         .append("\r\n");
        Iterator i = getHeaders();
        while(i.hasNext()) {
            b.append(i.next()).append("\r\n");
        }
        b.append("\r\n");
        b.append(getResponse());
        return b.toString();
    }
    
    public static Response buildResponse(StatusCode code, String statusCodeMessage, String response, Header... headers) {
        Response r = new Response();
        r.setStatusCode(code);
        r.setResponse(response);
        r.setStatusCodeMessage(statusCodeMessage);
        //work with the custom headers.
        for(Header h : headers) {
            r.setHeader(h.getName(), h.getValue());
        }
        return r;
    }
    
    public static Response buildResponse(StatusCode code, String response, Header... headers) {
        return Response.buildResponse(code, null, response, headers);
    }
    
}
