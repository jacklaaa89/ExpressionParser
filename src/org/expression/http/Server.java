package org.expression.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;

/**
 * The server which controls the incoming connections.
 * @author Jack Timblin
 */
public class Server {
    
    /**
     * The port which to listen for incoming requests.
     */
    private final int port;
    
    /**
     * Initialises the server.
     * @param port the port to listen on.
     */
    public Server(int port) {
        this.port = port;
    }
    
    /**
     * Blocks and listens for incoming requests.
     */
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
