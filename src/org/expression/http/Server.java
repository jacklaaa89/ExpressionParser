/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;

/**
 *
 * @author Jack
 */
public class Server {
    private final int port;
    
    public Server(int port) {
        this.port = port;
    }
    
    public void serve() {
        try {
            final ExecutorService service = Executors.newCachedThreadPool();
            ServerSocket serverSocket = new ServerSocket(this.port);
            while(true) {
                Socket sock = serverSocket.accept();
                service.submit(new Connection(sock));
            }
        } catch (IOException e) {}
    }
    
}
