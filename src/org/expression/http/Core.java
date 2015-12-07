package org.expression.http;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Base implementation for an request and response, handles generic operations.
 * @author Jack Timblin
 */
public abstract class Core {
    /**
     * The headers in this request/response object.
     */
    private final Map<String, Header> headers;
    
    /**
     * Initialises this object, attaching base headers.
     */
    protected Core() {
        headers = new HashMap<>();
        headers.put("Cache-Control", new Header("Cache-Control", "no-cache"));
        headers.put("Connection", new Header("Connection", "keep-alive"));
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        SimpleDateFormat sdfe = new SimpleDateFormat(", d MMM yyyy H:m:s zzz");
        Date d = new Date();
        String date = sdf.format(d).substring(0, 3) + sdfe.format(d);
        headers.put("Date", new Header("Date", date));
        headers.put("Content-Type", new Header("Content-Type", "application/x-www-form-urlencoded"));
    }
    
    /**
     * Sets a header to use.
     * @param name the name of the header
     * @param value the value of the header.
     */
    public void setHeader(String name, String value) {
        Header h = new Header(name, null);
        if(headers.containsKey(name)) {
            h = headers.get(name);
        }
        h.setValue(value);
        headers.put(name, h);
    }
    
    /**
     * Determine if this request/response has a certain header.
     * @param name the header name.
     * @return true if the header is set, false otherwise.
     */
    public boolean hasHeader(String name) {
        return headers.containsKey(name) && headers.get(name).isDefined();
    }
    
    /**
     * Creates a Header iterator for all the set headers.
     * @return a header iterator.
     */
    public Iterator getHeaders() {
        List<Header> hs = new ArrayList<>();
        headers.entrySet().stream().forEach((header) -> {
            hs.add(header.getValue());
        });
        return hs.iterator();
    }
    
    /**
     * gets a certain header.
     * @param name the name of header
     * @return the header value.
     */
    public Header getHeader(String name) {
        if(!headers.containsKey(name)) {
            return null;
        }
        return headers.get(name);
    }
    
}
