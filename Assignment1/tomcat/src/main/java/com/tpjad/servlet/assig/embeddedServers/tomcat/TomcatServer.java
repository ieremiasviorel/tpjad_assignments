package com.tpjad.servlet.assig.embeddedServers.tomcat;

import com.tpjad.servlet.assig.config.ConfigurationProperties;
import com.tpjad.servlet.assig.servlets.CitiesServlet;
import com.tpjad.servlet.assig.servlets.ClientServlet;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

public class TomcatServer {
    public static void main(String[] args) throws Exception {
        String webappDir = ConfigurationProperties.getConfigProperty("webapp.path.absolute");

        Tomcat server = new Tomcat();
        server.setPort(8080);

        StandardContext rootCtx = (StandardContext) server.addWebapp("/", webappDir);
        WebResourceRoot resources = new StandardRoot(rootCtx);
        rootCtx.setResources(resources);

        Tomcat.addServlet(rootCtx, "client", new ClientServlet());
        rootCtx.addServletMapping("", "client");

        Tomcat.addServlet(rootCtx, "cities", new CitiesServlet());
        rootCtx.addServletMapping("/cities", "cities");

        server.start();
        server.getServer().await();
    }
}
