package org.expression.api.exception;

import org.expression.api.DependencyInjector;
import org.expression.http.Header;
import org.expression.http.Request;
import org.expression.http.Response;
import org.expression.http.StatusCode;
import org.expression.http.data.Data;

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
    private final Data message;
    
    /**
     * The initial request that was made.
     */
    private final Request request;
    
    /**
     * Initialises a DispatchException.
     * @param request the request which triggered the exception.
     * @param code the status code to put in the response.
     * @param message the message to send to the client.
     * @param exception the internal exception that occurred.
     */
    private DispatchException(
            Request request, 
            StatusCode code, 
            Data message, 
            Exception exception) 
    {
        this.request = request;
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
     * Gets the request which triggered the error.
     * @return the request.
     */
    public Request getRequest() {
        return this.request;
    }
    
    /**
     * Generate a response from this exception.
     * @return the response.
     */
    public Response getResponse() {
        Response.Builder builder = new Response.Builder();
        return builder.setStatusCode(code)
               .setResponse(message, request.getFormatType())
               .setHeaders(new Header("Content-Type", request.getFormatType().getContentType()))
               .build();
    }
    
    /**
     * Generates a new DispatchException instance
     * @param code the status code.
     * @param data the data for the response.
     * @param exception the cause for this exception.
     * @return an initialised dispatch exception.
     */
    public static DispatchException newInstance(
            StatusCode code, 
            Data data, 
            Exception exception) 
    {
        DependencyInjector di = DependencyInjector.getDefault();
        Request r = di.get("request");
        return new DispatchException(r, code, data, exception);
    }
    
    /**
     * Generates a new DispatchException instance and wraps a string message to
     * a formatted response.
     * @param code the status code.
     * @param errorMessage the error message.
     * @param exception the cause for this exception.
     * @return an initialised dispatch exception.
     */
    public static DispatchException newInstance(
            StatusCode code, 
            String errorMessage, 
            Exception exception) 
    {
        Data d = new Data();
        d.set("Error", errorMessage);
        return DispatchException.newInstance(code, d, exception);
    }
    
}
