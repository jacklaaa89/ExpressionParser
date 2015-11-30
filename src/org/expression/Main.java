package org.expression;

import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.api.Route;
import org.expression.api.Router;
import org.expression.api.Service;
import org.expression.http.Request;
import org.expression.http.Server;

/**
 *
 * @author Jack
 */
public class Main {
    public static void main(String[] args) {
        DependencyInjector.getDefault().set("router", () -> {
            Router r = new Router(true);
            //add custom routes....
            return r;
        });
        DependencyInjector.getDefault().set("dispatcher", () -> {
            Dispatcher d = new Dispatcher();
            return d;
        });
        Server server = new Server(1234);
        server.serve();
    }
}
