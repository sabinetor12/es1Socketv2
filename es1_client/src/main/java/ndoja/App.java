package ndoja;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Client client = new Client();
        client.connetti();
        client.comunica();
    }
}
