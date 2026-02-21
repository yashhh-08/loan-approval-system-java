package backend;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class LoanApprovalServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        System.out.println("Server running at http://localhost:8080/");

        server.createContext("/loan", new LoanHandlerAPI());
        server.setExecutor(null);
        server.start();
    }

    static class LoanHandlerAPI implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // --- Add CORS headers ---
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");

            // Handle preflight OPTIONS request
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String formData = br.readLine();
                Map<String, String> params = parseFormData(formData);

                String response = LoanHandler.processLoan(params);
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }

        private Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
            Map<String, String> map = new HashMap<>();
            if (formData == null || formData.isEmpty()) return map;

            for (String pair : formData.split("&")) {
                String[] parts = pair.split("=");
                if (parts.length == 2)
                    map.put(URLDecoder.decode(parts[0], "UTF-8"),
                            URLDecoder.decode(parts[1], "UTF-8"));
            }
            return map;
        }
    }
}
