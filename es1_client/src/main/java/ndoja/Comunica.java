package ndoja;

import java.io.*;
import java.net.*;

public class Comunica {

    int portaServer = 8080; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtente; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input
    boolean controllo = false;

    public Comunica() throws IOException {
        miosocket = new Socket("127.0.0.1", portaServer);
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        outVersoServer = new DataOutputStream(miosocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
    }

    public void Output() throws IOException {
        for (;;) {
            System.out.println("4 ... inserisci la stringa da trasmettere al server" + '\n');
            StringaUtente = tastiera.readLine();
            if (!StringaUtente.equals("fine") && !StringaUtente.equals("spegni")) {
                System.out.println("5 ... invio la stringa al server e attendo ... ");
                outVersoServer.writeBytes(StringaUtente + '\n');
                //StringaRicevutaDalServer = inDalServer.readLine();
               while(!controllo) {
                
               }
                System.out.println("8 ... risposta dal server " + '\n' + StringaRicevutaDalServer);
                controllo = false;
            } else {
                outVersoServer.writeBytes(StringaUtente + '\n');
                miosocket.close();
                System.out.println("FINE");
                break;
            }
        }
    }

    public void Input() throws IOException {
        for (;;) {
            StringaRicevutaDalServer = inDalServer.readLine();
            if (StringaRicevutaDalServer.equals("spegni")){
                miosocket.close();
                System.out.println("FINE");
                System.exit(1);
            }else{
                controllo = true;
            }
        }

    }
}
