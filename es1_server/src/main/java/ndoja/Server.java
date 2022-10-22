package ndoja;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    ArrayList<Socket> S = new ArrayList<>();

    public void connetti() throws IOException {

        System.out.println("server partito");
        ServerSocket server = new ServerSocket(8080);
        for (;;) {
            Socket client = server.accept();
            S.add(client);
            (new MioThread(client,S,server)).start();
        }

    }

    
}
