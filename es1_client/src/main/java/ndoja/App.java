package ndoja;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = new Client();
        while(true){
        client.connetti();
        client.comunica();
        }
        //es1_client/target/
        //es1_server/target/
        
    }
}
