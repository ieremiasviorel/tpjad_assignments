package com.tpjad.servlet.assig;

import com.tpjad.servlet.assig.servlets.Hello;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(Hello.class, "/");

        server.setHandler(handler);

        System.out.println("Start server Jetty embedded");

        server.start();
        server.join();
    }
}
