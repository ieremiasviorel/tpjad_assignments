package com.tpjad.servlet.assig.embeddedServers.tomcat;

import com.tpjad.servlet.assig.config.ConfigurationProperties;
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

        server.start();
        server.getServer().await();
    }
}
