package ndoja;

import java.io.IOException;

public class ThreadInput extends Thread{
    Comunica comunica;
    public ThreadInput(Comunica comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Input();
        } catch (Exception e) {
        }
    }
}
