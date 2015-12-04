package org.expression.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.api.exception.DispatchException;
import org.expression.http.data.Data;
import org.expression.http.data.Xml;

/**
 *
 * @author Jack
 */
public class Connection implements Runnable {
    private final Socket socket;
    
    public Connection(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader requestReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter responseWriter = new PrintWriter(socket.getOutputStream());
            try {
                List<String> lines = new ArrayList<>();
                String line = "";
                while(requestReader != null && (line = requestReader.readLine()) != null) {
                    if(line.length() == 0) {
                        break;
                    }
                    lines.add(line);
                }
                final Request req = Request.parseRequest(lines.toArray(new String[] {}));

                StringBuilder body = new StringBuilder();
                if(req.isPost() || req.is(RequestType.PUT) || req.is(RequestType.PATCH)) {
                    if(!req.hasHeader("Content-Length")) {
                        req.setHeader("Content-Length", "0");
                    }
                    int contentLength = Integer.parseInt(req.getHeader("Content-Length").getValue());
                    int c = 0;
                    for(int i = 0; i < contentLength; i++) {
                        c = requestReader.read();
                        body.append((char)c);
                    }
                }

                req.setRequestPayload(body.toString());

                DependencyInjector.getDefault().set("request", (DependencyInjector di) -> req, true);
                Dispatcher dispatcher = DependencyInjector.getDefault().get("dispatcher");
                Response r = null;
                try {
                    r = dispatcher.dispatch(req);
                } catch (DispatchException e) {
                    r = e.getResponse();
                    if(e.getTriggeredException() != null) {
                        e.getTriggeredException().printStackTrace();
                    }
                }
                responseWriter.append(r.toString());
            } catch (DispatchException e) {
                responseWriter.append(e.getResponse().toString());
            }
            responseWriter.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
