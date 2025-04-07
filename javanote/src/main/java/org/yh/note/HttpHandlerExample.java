package org.yh.note;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class HttpHandlerExample implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        OutputStream respBody = exchange.getResponseBody();


        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("   <head>");
        sb.append("       <meta charset=\"UTF-8\">");
        sb.append("       <meta name=\"author\" content=\"Dochi\">");
        sb.append("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        sb.append("       <title>Example</title>");
        sb.append("   </head>");
        sb.append("   <body>");
        sb.append("       <h5>Hello, HttpServer!!!</h5>");
        sb.append("       <span>Method: "+(exchange.getRequestMethod())+"</span></br>");
        sb.append("       <span>URI: "+(exchange.getRequestURI())+"</span></br>");
        sb.append("       <span>PATH: "+(exchange.getRequestURI().getPath())+"</span></br>");
        sb.append("       <span>QueryString: "+(exchange.getRequestURI().getQuery())+"</span></br>");
        sb.append("   </body>");
        sb.append("</html>");

        ByteBuffer bb = Charset.forName("UTF-8").encode(sb.toString());
        int contentLength = bb.limit();
        byte[] content = new byte[contentLength];
        bb.get(content, 0, contentLength);

        exchange.sendResponseHeaders(200, contentLength);
        respBody.write(content);
        respBody.close();

    }
}
