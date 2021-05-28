/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pkm30
 */
public class Server { 
   private Chair chair;
    public Server() {
      chair = new Chair();
    }
    
     public void start(){
         System.out.println("확인할 좌석의 번호를 선택하세요. : ");
     }
     
     public void change(String counts){
          
       try {
           chair.Changer(counts);
       } catch (IOException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       }
        
     }
     
     public void checknum(String checkchair) throws IOException{
          
         chair.Checker(checkchair);
     }
     
}