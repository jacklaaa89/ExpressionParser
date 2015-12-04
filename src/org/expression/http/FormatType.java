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
    XML(new String[]{"xml"/*, any more xml extensions*/}) {
        @Override
        public Format getFormatter() {
            return new Xml();
        }
    },
    /**
     * Formatter to manipulate JSON input/output.
     */
    JSON(new String[]{"json"/*, any more json extensions*/}) {
        @Override
        public Format getFormatter() {
            return null;
        }
    };
    /**
     * The list of accepted extensions that match this format.
     */
    private final String[] acceptedTypes;
    
    /**
     * Initialises a new FormatType.
     * @param acceptedExtensions the list of accepted extensions.
     */
    FormatType(String[] acceptedExtensions) {
        this.acceptedTypes = acceptedExtensions;
    }
    /**
     * Get the list of accepted extensions.
     * @return the list of accepted file extensions;
     */
    public String[] getAcceptedExtensions() {
        return this.acceptedTypes;
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
