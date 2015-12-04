package org.expression.http.data;

import org.expression.http.Request;

/**
 * Generic Type for input and output formatters.
 * @author Jack Timblin
 */
public interface Format {
    /**
     * Formats the provided output into its string representation.
     * @param output the output
     * @return the formatted string representation of this output.
     */
    public String getFormattedResponse(Data output);
    
    /**
     * Parses request input into a usable Data object.
     * @param request the request to parse.
     * @return the parsed request.
     */
    public Data parseInput(Request request);
}
