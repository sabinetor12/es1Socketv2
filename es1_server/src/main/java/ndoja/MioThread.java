package ndoja;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MioThread extends Thread {
    Socket client;
    ArrayList<Socket> S;
    ServerSocket server;

    public MioThread(Socket client, ArrayList<Socket> S, ServerSocket server) {
        this.client = client;
        this.S = S;
        this.server = server;
    }

    public void run() {
        comunica();
    }

    public void comunica() {

        try {
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream outVersoClient = new DataOutputStream(client.getOutputStream());
            do {
                String strRicevuta = inDalClient.readLine();
                if (strRicevuta.equals("SPEGNI")) {
                    outVersoClient.writeBytes("sto spegnendo" + '\n');
                    for (Socket i : S) {
                        i.close();
                    }
                    server.close();
                    break;
                } else {
                    System.out.println("stringa ricevuta: " + strRicevuta);
                    String strModificata = strRicevuta.toUpperCase();
                    outVersoClient.writeBytes(strModificata + '\n');
                    System.out.println("stringa inviata");
                }

            } while (true);

        } catch (Exception e) {
        }
    }

}
