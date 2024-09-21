package org.workshop;

import org.workshop.sockets.Client;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
       try {
           String response;
           client.start("localhost", 3000);
           response = client.sendMessage("Hello");
           System.out.println("Response 1: " + response);
           response = client.sendMessage("World");
           System.out.println("Response 2: " + response);
       } finally {
           client.stop();
       }

    }
}
