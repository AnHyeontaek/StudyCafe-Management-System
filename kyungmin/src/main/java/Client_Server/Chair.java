/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Server;

import Client_Server.Off;
import Client_Server.On;
import Client_Server.Saving;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pkm30
 */
public class Chair {
    private Scanner scan = new Scanner(System.in);
    private State State;

    public Chair(){
        
    }

    public void setState(State powerState){
        this.State = powerState;
    }

    public void powerPush(String chair_state){
        State.powerPush(chair_state);
    }
    
    public void Checker(String chs) throws IOException {
 
      String line;
      String[] array = null;
      
      String choice;        
      boolean ch = true;    
      File myFile = new File("db\\db.txt"); 
      FileReader fileReader = new FileReader(myFile);
      BufferedReader reader = new BufferedReader(fileReader);
     
      while((line = reader.readLine()) != null){
      
      array = line.split(",");
      String numb=array[0];
      
        if(numb.equals(chs)){
      
        System.out.println(array[0]+"번 좌석은 현재 "+array[1]+"상태 입니다.");        
                 
        }           
     }
    
}

    public void Changer(String checkchair) throws IOException {
      Chair chair = new Chair();
      On on = new On();
      Off off = new Off();
      Saving saving = new Saving();
      
      String choice ;
      
      boolean ch = true;
      
     
      
         
     System.out.println("1.On   2.Off   3.고장");          
     choice = scan.next();
     
     if(choice.equals("1")){
    
        chair.setState( on);
        chair.powerPush(checkchair);   
        
     }
     else if(choice.equals("2")){
         
        chair.setState(off);
        chair.powerPush(checkchair);
        
     }
     else if(choice.equals("3")){
         
        chair.setState(saving);
        chair.powerPush(checkchair);
        
     }
       
    }
}