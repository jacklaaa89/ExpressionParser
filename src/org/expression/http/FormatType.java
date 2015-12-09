package org.expression.http;

import org.expression.http.data.Format;
import org.expression.http.data.Xml;

/**
 * Enumeration for the format type for the input and output.
 * @author Jack Timblin
 */
public enum FormatType {
    /**
     * Formatter to manipulate XML input/output.
     */
    XML(new String[]{"xml"/*, any more xml extensions*/},
        "application/xml") {
        @Override
        public Format getFormatter() {
            return new Xml();
        }
    },
    /**
     * Formatter to manipulate JSON input/output.
     */
    JSON(new String[]{"json"/*, any more json extensions*/},
        "application/json") {
        @Override
        public Format getFormatter() {
            return null;
        }
    };
    /**
     * The list of accepted extensions that match this format.
     */
    private final String[] acceptedTypes;
    private final String contentType;
    
    /**
     * Initialises a new FormatType.
     * @param acceptedExtensions the list of accepted extensions.
     * @param contentType the content type used in the response header.
     */
    FormatType(String[] acceptedExtensions, String contentType) {
        this.acceptedTypes = acceptedExtensions;
        this.contentType = contentType;
    }
    /**
     * Get the list of accepted extensions.
     * @return the list of accepted file extensions;
     */
    public String[] getAcceptedExtensions() {
        return this.acceptedTypes;
    }
    
    /**
     * Gets the content type of this format to use
     * in the response header.
     * @return the content type.
     */
    public String getContentType() {
        return this.contentType;
    }
    
    /**
     * Attempts to match an extension to the list of the accepted extensions, 
     * case is ignored.
     * @param extension the extension to match against.
     * @return true if the extension matches, false otherwise.
     */
    public boolean matches(String extension) {
        boolean matches = false;
        for(String entry : getAcceptedExtensions()) {
            if(("."+entry).equalsIgnoreCase(extension)) {
                matches = true;
                break;
            }
        }
        return matches;
    }
    
    /**
     * Gets the Formatter which will be used to format the response.
     * @return the formatter.
     */
    public abstract Format getFormatter();
}
