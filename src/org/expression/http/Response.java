package org.expression.http;

import java.util.Iterator;
import org.expression.http.Request.StatusCode;

/**
 *
 * @author Jack
 */
public class Response extends Core {
    
    private StatusCode code;
    private String responsePayload;
    private final static String HTTP_VERSION = "1.1";
    
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
         .append(getStatusCode().toString())
         .append("\r\n");
        Iterator i = getHeaders();
        while(i.hasNext()) {
            b.append(i.next()).append("\r\n");
        }
        b.append("\r\n");
        b.append(getResponse());
        return b.toString();
    }
    
    public static Response buildResponse(StatusCode code, String response, Header... headers) {
        Response r = new Response();
        r.setStatusCode(code);
        r.setResponse(response);
        //work with the custom headers.
        return r;
    }
    
}
