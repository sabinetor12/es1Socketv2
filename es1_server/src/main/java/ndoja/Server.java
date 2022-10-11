package ndoja;

import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public void connetti() throws IOException {
        if (server == null) {
            System.out.println("server partito");
            server = new ServerSocket(8080);
        }
        client = server.accept();
        System.out.println("socket connesso");
        // server.close();
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        comunica();
    }

    public void comunica() throws IOException {
        strRicevuta = inDalClient.readLine();
        System.out.println("stringa ricevuta: " + strRicevuta);
        strModificata = strRicevuta.toUpperCase();
        outVersoClient.writeBytes(strModificata + '\n');
        System.out.println("stringa inviata");
        client.close();
        connetti();
    }
}
