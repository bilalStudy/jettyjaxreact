package no.kristiania.library;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.MalformedURLException;
import java.net.URL;

public class LibraryServer {


    private final Server server;
    public LibraryServer(int port){
        this.server = new Server(port);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setBaseResource(Resource.newClassPathResource("/webapp"));
        server.setHandler(webapp);

    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public static void main(String[] args) {
        System.out.println("hello server");
    }

    public void start() throws Exception {
        server.start();
    }
}
