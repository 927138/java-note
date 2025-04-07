package org.yh.note;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JavaSEHttpServer {
    public static void main(String[] args) throws IOException {
        int threadCount = 5;
        Executor executor = Executors.newFixedThreadPool(threadCount);
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), threadCount);
        server.setExecutor(executor);
        server.start();


        HttpContext context = server.createContext("/hello", new HttpHandlerExample());




    }
}
