package com.tpjad.servlet.assig;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatServer {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";

        Tomcat server = new Tomcat();
        server.setPort(8080);

        StandardContext rootCtx = (StandardContext) server
                .addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(rootCtx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                (new File(".")).getAbsolutePath(), "/"));
        rootCtx.setResources(resources);

        System.out.println("Start server Tomcat embedded");
        server.start();
        server.getServer().await();
    }
}
