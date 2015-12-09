package org.expression.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;
import java.net.UnknownHostException;
import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.api.Router;

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
     * The maximum amount of pending requests allowed.
     */
    private final int backlog;
    
    /**
     * The address to bind the socket on.
     */
    private final InetAddress bindAddress;
    
    /**
     * The default backlog amount, which is 50 connections.
     */
    private static final int DEFAULT_BACKLOG = 50;
    
    /**
     * Gets a InetAddress representation of localhost (usually '127.0.0.1').
     */
    public static final InetAddress LOCALHOST = InetAddress.getLoopbackAddress();
    
    /**
     * Gets a InetAddress representation of all ('0.0.0.0').
     */
    public static final InetAddress ALL = Server.getAll();
    
    /**
     * Generates the InetAddress for ALL.
     * @return the 0.0.0.0 InetAddress.
     */
    private static InetAddress getAll() {
        try {
            return InetAddress.getByName("0.0.0.0");
        } catch (UnknownHostException e) {
            return null;
        }
    }
    
    /**
     * Initialises a Server.
     * @param port the port to listen on.
     * @param backlog the amount of allowed waiting connections.
     * @param address the InetAddress to bind on.
     * @throws UnknownHostException if the address is not valid.
     */
    public Server(int port, int backlog, InetAddress address) throws UnknownHostException {
        this.port = port;
        this.backlog = backlog;
        if(address == null) {
            throw new UnknownHostException("Host was not defined.");
        }
        this.bindAddress = address;
    }
    
    /**
     * Initialises a Server.
     * @param port the port to listen on.
     * @param backlog the amount of allowed waiting connections.
     * @param address the InetAddress to bind on.
     * @throws UnknownHostException if the address is not valid.
     */
    public Server(int port, int backlog, String address) throws UnknownHostException {
        this(port, backlog, InetAddress.getByName(address));
    }
    
    /**
     * Initialises a Server with a backlog value of 50.
     * @param port the port to listen on.
     * @param address the InetAddress to bind on.
     * @throws UnknownHostException if the address is not valid.
     */
    public Server(int port, String address) throws UnknownHostException {
        this(port, DEFAULT_BACKLOG, InetAddress.getByName(address));
    }
    
    /**
     * Initialises a Server which binds to local host.
     * @param port the port to listen on.
     * @param backlog the amount of allowed waiting connections.
     * @throws UnknownHostException if the address is not valid.
     */
    public Server(int port, int backlog) throws UnknownHostException {
        this(port, backlog, LOCALHOST);
    }
    
    /**
     * Initialises a Server which binds to local host and has a backlog of 50.
     * @param port the port to listen on.
     * @throws UnknownHostException if the address is not valid.
     */
    public Server(int port) throws UnknownHostException {
        this(port, DEFAULT_BACKLOG, LOCALHOST);
    }
    
    /**
     * Blocks and listens for incoming requests.
     * @throws IOException When the server cannot start accepting requests.
     */
    public void serve() throws IOException {
        DependencyInjector di = DependencyInjector.getDefault();
        if(!di.has("router", Router.class)) {
            di.setShared("router", new Router(true));
        }
        if(!di.has("dispatcher", Dispatcher.class)) {
            di.setShared("dispatcher", new Dispatcher());
        }
        final ExecutorService service = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(this.port, this.backlog, this.bindAddress);
        while(true) {
            Socket sock = serverSocket.accept();
            service.submit(new Connection(sock));
        }
    }
    
}
