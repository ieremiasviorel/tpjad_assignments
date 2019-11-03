package com.tpjad.servlet;

import com.tpjad.servlet.servlets.Hello;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(Hello.class, "/");
        System.out.println("Start server Jetty embedded");
        server.start();
        server.join();
    }
}
