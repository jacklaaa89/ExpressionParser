package org.expression.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jack
 */
public class Request extends Core {
    
    
    
    public static enum StatusCode {
        CONTINUE(100),
        SWITCHING_PROTOCOLS(101),
        PROCESSING(102),
        OK(200),
        CREATED(201),
        ACCEPTED(202),
        NON_AUTHORITATIVE_INFORMATION(203),
        NO_CONTENT(204),
        RESET_CONTENT(205),
        PARTIAL_CONTENT(206),
        MULTI_STATUS(206),
        ALREADY_REPORTED(208),
        IM_USED(226),
        MULTIPLE_CHOICES(300),
        MOVED_PERMANENTLY(301),
        FOUND(302),
        SEE_OTHER(303),
        NOT_MODIFIED(304),
        USE_PROXY(305),
        SWITCH_PROXY(306),
        TEMPORARY_REDIRECT(307),
        PERMANENT_REDIRECT(308),
        BAD_REQUEST(400),
        UNAUTHORIZED(401),
        PAYMENT_REQUIRED(402),
        FORBIDDEN(403),
        NOT_FOUND(404),
        METHOD_NOT_ALLOWED(405),
        NOT_ACCEPTABLE(406),
        PROXY_AUTHENTICATION_REQUIRED(407),
        REQUEST_TIMEOUT(408),
        CONFLICT(409),
        GONE(410),
        LENGTH_REQUIRED(411),
        PRECONDITION_FAILED(412),
        PAYLOAD_TOO_LARGE(413),
        URI_TOO_LONG(414),
        UNSUPPORTED_MEDIA_TYPE(415),
        RANGE_NOT_SATISFIABLE(416),
        EXPECTATION_FAILED(417),
        IM_A_TEAPOT(418),
        AUTHENTICATION_TIMEOUT(419),
        MISDIRECTED_REQUEST(421),
        UNPROCESSABLE_ENTITY(422),
        LOCKED(423),
        FAILED_DEPENDENCY(424),
        UPGRADE_REQUIRED(426),
        PRECONDITION_REQUIRED(428),
        TOO_MANY_REQUESTS(429),
        REQUEST_HEADER_FIELDS_TOO_LARGE(431),
        INTERNAL_SERVER_ERROR(500),
        NOT_IMPLEMENTED(501),
        BAD_GATEWAY(502),
        SERVICE_UNAVAILABLE(503),
        GATEWAY_TIMEOUT(504),
        HTTP_VERSION_NOT_SUPPORTED(505),
        VARIANT_ALSO_NEGOTIATES(506),
        INSUFFICIENT_STORAGE(507),
        LOOP_DETECTED(508),
        NOT_EXTENDED(510),
        NETWORK_AUTHENTICATION_REQUIRED(511),
        UNKNOWN_ERROR(520),
        ORIGIN_CONNECTION_TIMEOUT(522);
        
        /**
         * The integer representation of this status code.
         */
        private final int code;
        
        /**
         * Initialises a status code.
         * @param code the integer representation of this status code.
         */
        StatusCode(int code) {
            this.code = code;
        }
        
        /**
         * Gets this status codes integer representation.
         * @return the integer representation.
         */
        public int getCode() {
            return this.code;
        }
    }
    
    private static final String DEFAULT_HTTP_VERSION = "1.1";
    private String version = DEFAULT_HTTP_VERSION;
    
    private final Map<String, Parameter> params;
    private String requestPayload = null;
    private RequestType requestType;
    private String uri;
    
    private Request() {
        super();
        //set the default headers, request type and status code.
        requestType = RequestType.GET;
        params = new HashMap<>();
        
    }
    
    private void setQueryParam(String name, String value) {
        this.params.put(name, new Parameter(name, value));
    }
    
    private void setHttpVersion(String version) {
        try {
            Double.parseDouble(version);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.version = version;
    }
    
    public Iterator getQueryParams() {
        List<Parameter> hs = new ArrayList<>();
        for (Map.Entry<String, Parameter> header : params.entrySet()) {
            hs.add(header.getValue());
        }
        return hs.iterator();
    }
    
    public Parameter getQueryParam(String name) {
        if(!this.hasQueryParam(name)) {
            return null;
        }
        return params.get(name);
    }
    
    public boolean hasQueryParam(String name) {
        return params.containsKey(name);
    }
    
    
    
    public double getVersion() {
        return Double.parseDouble(this.version);
    }
    
    public String getFormattedVersion() {
        return "HTTP/" + this.version;
    }
    
    public RequestType getRequestType() {
        return this.requestType;
    }
    
    private void setRequestType(RequestType type) {
        this.requestType = type;
    }
    
    public String getURI() {
        return this.uri;
    }
    
    private void setURI(String uri) {
        this.uri = uri;
    }
    
    public static Request parseRequest(String request) {
        String[] lines = request.split("\r\n");
        return Request.parseRequest(lines);
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(getRequestType()).append(" ").append(getURI()).append(" ").append(getFormattedVersion()).append("\r\n");
        Iterator i = getHeaders();
        while(i.hasNext()) {
            b.append(i.next().toString()).append("\r\n");
        }
        b.append("\r\n");
        return b.toString();
    }
    
    public static Request parseRequest(String[] lines) {
        //get the request type etc.
        String[] first = lines[0].trim().split(" ");
        if(first.length != 3) {
            return null; //error.
        }
        Request re = new Request();
        re.setRequestType(RequestType.valueOf(first[0]));
        re.setURI(first[1]);
        
        //parse the URI from the query params.
        String[] s = re.getURI().trim().split("\\?");
        if(s.length == 2) {
            re.setURI(s[0]);
            String[] en = s[1].trim().split("&");
            for(int i = 0; i < en.length; i++) {
                String[] kv = en[i].trim().split("=");
                if(kv.length > 0) {
                    re.setQueryParam(kv[0], (kv.length > 1) ? kv[1] : null);
                }
            }
        }
        
        String[] htv = first[2].trim().split("/");
        if(htv.length != 2) {
            return null; //another error.
        }
        re.setHttpVersion(htv[1]);
        for(int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(": ");
            if(line.length == 2) {
                re.setHeader(line[0], line[1]);
            }
        }
        return re;
    }
    
}
