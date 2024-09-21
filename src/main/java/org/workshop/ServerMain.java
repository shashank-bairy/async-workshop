package org.workshop;

import org.workshop.sockets.Server;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        executeSocket();
    }

    private static void executeSocket() throws IOException {
        Server server = new Server();

        try {
            server.start(3000);
        } finally {
            server.stop();
        }
    }
}