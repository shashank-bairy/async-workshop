package org.workshop.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean stop;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while (!stop && (inputLine = in.readLine()) != null) {
            out.println(inputLine);
        }
    }

    public void stop() throws IOException {
        stop = true;

        out.close();
        in.close();
        serverSocket.close();
    }
}
