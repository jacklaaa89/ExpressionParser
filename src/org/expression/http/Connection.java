/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.expression.api.DependencyInjector;
import org.expression.api.Service;

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
            List<String> lines = new ArrayList<>();
            String line = "";
            while(requestReader != null && (line = requestReader.readLine()) != null) {
                if(line.length() == 0) {
                    break;
                }
                lines.add(line);
            }
            final Request req = Request.parseRequest(lines.toArray(new String[] {}));
            DependencyInjector.getDefault().set("request", new Service() {
                @Override
                public Object definition() {
                    return req;
                }
            }, true);
            responseWriter.append(Response.buildResponse(Request.StatusCode.OK, "OKAY").toString());
            responseWriter.flush();
            socket.close();
        } catch (IOException e) {}
    }
    
}
