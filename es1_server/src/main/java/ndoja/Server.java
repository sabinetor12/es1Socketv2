package ndoja;

import java.io.*;
import java.net.*;

public class Server {


    public void connetti() throws IOException {

        System.out.println("server partito");
        ServerSocket server = new ServerSocket(8080);
        for (;;) {
            Socket client = server.accept();
            (new MioThread(client)).start();
        }

    }

    
}
