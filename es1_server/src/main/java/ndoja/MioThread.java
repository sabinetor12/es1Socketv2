package ndoja;

import java.io.*;
import java.net.*;

public class MioThread extends Thread {
    Socket client;

    public MioThread(Socket client) {
        this.client = client;
    }

    public void run() {
        comunica(client);
    }

    public void comunica(Socket client) {
        System.out.println("sono fuori");
        try {
            System.out.println("ci sono");
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream outVersoClient = new DataOutputStream(client.getOutputStream());
            String strRicevuta = inDalClient.readLine();
            System.out.println("stringa ricevuta: " + strRicevuta);
            String strModificata = strRicevuta.toUpperCase();
            outVersoClient.writeBytes(strModificata + '\n');
            System.out.println("stringa inviata");
            client.close();
        } catch (Exception e) {}
    }

}
