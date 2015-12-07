package org.expression.http;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Am encapsulation of a HTTP response.
 * @author Jack Timblin
 */
public class Response extends Core {
    
    /**
     * The status code of the response.
     */
    private StatusCode code;
    
    /**
     * The response payload.
     */
    private String responsePayload;
    
    /**
     * The HTTP version to use in the response.
     */
    private final static String HTTP_VERSION = "1.1";
    
    /**
     * The optional status code message to use.
     */
    private String statusCodeMessage = null;
    
    /**
     * Initialises a response with default values.
     */
    private Response() {
        super();
        this.setHeader("Content-Type", "application/json");
        this.setHeader("Server", "ExpressionParser_V1.0");
        code = StatusCode.OK;
        responsePayload = "";
    }
    
    /**
     * Sets the status code for the response.
     * @param code the status code.
     */
    private void setStatusCode(StatusCode code) {
        this.code = code;
    }
    
    /**
     * Gets the status code for this response.
     * @return the status code.
     */
    public StatusCode getStatusCode() {
        return this.code;
    }
    
    /**
     * Sets the string representation of the response.
     * @param response the response.
     */
    private void setResponse(String response) {
        this.responsePayload = response;
    }
    
    /**
     * Sets the optional status code message for the response.
     * @param statusCodeMessage the status code message.
     */
    private void setStatusCodeMessage(String statusCodeMessage) {
        this.statusCodeMessage = statusCodeMessage;
    }
    
    /**
     * Determines the status code message, either by using the custom
     * set one or the default one for a particular status code.
     * @return the string representation of the status code message.
     */
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
    
    /**
     * Gets a formatted version of the HTTP version to use in responses.
     * @return the formatted HTTP version.
     */
    private String getFormattedVersion() {
        return "HTTP/" + HTTP_VERSION;
    }
    
    /**
     * Gets the double representation of the HTTP version.
     * @return the HTTP version as a double.
     */
    private double getVersion() {
        return Double.parseDouble(HTTP_VERSION);
    }
    
    /**
     * Returns the string representation of the response.
     * @return string representation of the response.
     */
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
    
    /**
     * Builds a response.
     * @param code the status code.
     * @param statusCodeMessage an optional status code message.
     * @param response the response body itself.
     * @param headers any optional headers to apply.
     * @return the build response.
     */
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
    
    /**
     * Builds a response.
     * @param code the status code.
     * @param response the response body itself.
     * @param headers any optional headers to apply.
     * @return the build response.
     */
    public static Response buildResponse(StatusCode code, String response, Header... headers) {
        return Response.buildResponse(code, null, response, headers);
    }
    
}
