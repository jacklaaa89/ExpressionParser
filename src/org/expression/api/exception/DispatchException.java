package org.expression.api.exception;

import org.expression.http.Response;
import org.expression.http.StatusCode;

/**
 * An exception which is thrown during dispatch requests, it can
 * generate a valid response from an error.
 * @author Jack Timblin
 */
public class DispatchException extends RuntimeException {
    
    /**
     * The internal exception that was thrown, for internal debugging.
     */
    private final Exception exception;
    
    /**
     * The status code to push in the error response.
     */
    private final StatusCode code;
    
    /**
     * The error message to display to the client.
     */
    private final String message;
    
    /**
     * Initialises a DispatchException.
     * @param code the status code to put in the response.
     * @param message the message to send to the client.
     * @param exception the internal exception that occurred.
     */
    public DispatchException(StatusCode code, String message, Exception exception) {
        super(message);
        this.code = code;
        this.exception = exception;
        this.message = message;
    }
    
    /**
     * Gets the internal triggered exception.
     * @return the internal triggered exception.
     */
    public Exception getTriggeredException() {
        return this.exception;
    }
    
    /**
     * The status code for the response.
     * @return the status code.
     */
    public StatusCode getStatusCode() {
        return this.code;
    }
    
    /**
     * Generate a response from this exception.
     * @return the response.
     */
    public Response getResponse() {
        Response.Builder builder = new Response.Builder();
        return builder.setStatusCode(code)
               .setResponse(message)
               .build();
    }
    
}
