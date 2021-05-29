
package com.cse.StudyCafe_Chair.main;


import com.cse.StudyCafe_Chair.client.Client;
import com.cse.StudyCafe_Chair.server.Server;
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

  
       server.view();
       client.insertnum();
       String countChairs = client.getCheckchair();
       server.Use(countChairs);
       //server.Changer(countChairs);
       
    }
}
