package ndoja;

import java.io.IOException;

public class ThreadOutput extends Thread {
    Comunica comunica;
    public ThreadOutput(Comunica comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Output();
        } catch (Exception e) {
            /*if(e instanceof IOException){
                System.out.println("fine");
            }*/
        }
    }
}
