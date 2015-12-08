package org.expression;

import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.api.Event;
import org.expression.api.EventListener;
import org.expression.api.EventManager;
import org.expression.api.Route;
import org.expression.api.Router;
import org.expression.api.exception.DispatchException;
import org.expression.http.FormatType;
import org.expression.http.Request;
import org.expression.http.Response;
import org.expression.http.Server;
import org.expression.http.StatusCode;
import org.expression.http.data.Data;

/**
 *
 * @author Jack
 */
public class Main {
    public static void main(String[] args) {
        
        DependencyInjector.getDefault().set("router", (DependencyInjector di) -> {
            Router r = new Router(true);
            r.map(new Route("/get-function/{name:[A-Za-z]+}(/:params)?", "get-function", "index"));
            //add custom routes....
            return r;
        }, true);
        DependencyInjector.getDefault().set("dispatcher", (DependencyInjector di) -> {
            Dispatcher d = new Dispatcher();
            EventManager em = new EventManager();
            em.collectResponses(true);
            
            em.attach("dispatch:beforeDispatch", (EventListener<Dispatcher>) (Event<Dispatcher> event) -> {
                Dispatcher dis = event.getSource();
                Request r = dis.getCurrentRequest();
                
                if(r.getVersion() != 1.1) {
                    throw new DispatchException(StatusCode.HTTP_VERSION_NOT_SUPPORTED, "<Invalid HTTP Version>", null);
                }
                
                return null;
                
            });
            
            em.attach("dispatch:beforeNotFound", (EventListener<Dispatcher>) (Event<Dispatcher> event) -> {
                if(event.isCancellable()) {
                    event.stop(); //stop this event and collect response.
                }
                
                Response.Builder builder = new Response.Builder();
                return builder.setResponse("<The Requested Function is not Found.>")
                       .setStatusCode(StatusCode.NOT_FOUND)
                       .build();
            });
            
            d.setEventManager(em);
            
            return d;
        }, true);
        Server server = new Server(1234);
        server.serve();
    }
}
