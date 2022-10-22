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
            DataOutput outVersoClient = new DataOutputStream(client.getOutputStream());
            System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiscuolo. Attendo ...");
            for (;;) {
                String StringaRicevuta = inDalClient.readLine();
                if (!StringaRicevuta.equals("fine") && !StringaRicevuta.equals("spegni")) {
                    System.out.println("6 ricevuta la stringa dal cliente: " + StringaRicevuta);
                    String StringaModificata = StringaRicevuta.toUpperCase();
                    System.out.println("7 invio la stringa modificata al client ...");
                    outVersoClient.writeBytes(StringaModificata + '\n');
                } else if (StringaRicevuta.equals("spegni")) {
                    for (Socket i : S) {
                        DataOutputStream nb = new DataOutputStream(i.getOutputStream());
                        nb.writeBytes("spegni" + '\n');
                        //i.close();
                    }
                    System.out.println("CHIUSO SERVER");
                    server.close();
                    break;
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("E22");
            System.exit(1);
        }
        // server.close();
    }

}
