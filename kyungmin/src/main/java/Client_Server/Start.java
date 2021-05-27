
package Client_Server;


import java.io.IOException;

/**
 *
 * @author pkm30
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       Client client = new Client();       
       Server server = new Server();
       
       
       server.start(); 
       client.insertnum();   // client 안에는 값이 들어가있어 
       String countChairs = client.getCheckchair();
       server.checknum(countChairs); 
       server.change(countChairs);
       
    }
}
