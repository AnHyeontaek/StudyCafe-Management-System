/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pkm30
 */
public class Off implements State {
    
    public void powerPush(String chair_state)  {
       
        
        File file = new File("db\\db.txt");		
        String dummy = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
           for (int i=0; i< Integer.parseInt(chair_state)-1; i++){
               line = br.readLine();
               dummy += (line + "\r\n");
           }
            
           String delData = br.readLine();
           dummy += (chair_state+",OFF\n");
           
          while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" );                                
	  }
          
           FileWriter fw = new FileWriter("db\\db.txt");
	   fw.write(dummy);

           fw.flush();
           fw.close();
          
          System.out.println("좌석의 상태가 OFF으로 변경되었습니다.");
        } catch (IOException ex) {
            Logger.getLogger(Off.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
}