package org.expression.http;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jack
 */
public abstract class Core {
    private final Map<String, Header> headers;
    
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
    
    public void setHeader(String name, String value) {
        Header h = new Header(name, null);
        if(headers.containsKey(name)) {
            h = headers.get(name);
        }
        h.setValue(value);
        headers.put(name, h);
    }
    
    public boolean hasHeader(String name) {
        return headers.containsKey(name) && headers.get(name).isDefined();
    }
    
    public Iterator getHeaders() {
        List<Header> hs = new ArrayList<>();
        for (Map.Entry<String, Header> header : headers.entrySet()) {
            hs.add(header.getValue());
        }
        return hs.iterator();
    }
    
    public Header getHeader(String name) {
        if(!headers.containsKey(name)) {
            return null;
        }
        return headers.get(name);
    }
    
}
