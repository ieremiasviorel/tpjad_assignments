package com.tpjad.servlet;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatServer {
    public static void main(String[] args) throws Exception {
        Tomcat server = new Tomcat();
        server.setPort(8080);
        StandardContext rootCtx = (StandardContext) server.addWebapp("",
                (new File(System.getProperty("java.io.tmpdir"))).getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(rootCtx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                (new File(".")).getAbsolutePath(), "/"));
        rootCtx.setResources(resources);
        server.start();
        System.out.println("Start server Tomcat embedded");
        server.getServer().await();
    }
}
