package org.expression;

import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.api.Router;
import org.expression.api.Service;
import org.expression.http.Request;

/**
 *
 * @author Jack
 */
public class Main {
    public static void main(String[] args) {
        DependencyInjector.getDefault().set("router", new Service() {
            @Override
            public Object definition() {
                Router r = new Router(true);
                //add custom routes....
                return r;
            }
        });
        DependencyInjector.getDefault().set("dispatcher", new Service(){
            @Override
            public Object definition() {
                Dispatcher d = new Dispatcher();
                return d;
            }
        });
        Request re = Request.parseRequest("POST /index/index/10 HTTP/1.1\r\n\r\n<t>Content</t>");
        DependencyInjector.getDefault().<Dispatcher>get("dispatcher").dispatch(re);
    }
}
