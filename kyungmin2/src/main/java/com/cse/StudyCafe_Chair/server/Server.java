/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_Chair.server;

import com.cse.StudyCafe_Chair.client.Client;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pkm30
 */
public class Server { 

    private Scanner scan = new Scanner(System.in);
    private State State;

    
    public void setState(State powerState){
        this.State = powerState;
    }

    public void powerPush(String chair_state){
        State.powerPush(chair_state);
    }
    
    public void view() throws IOException{
         String line;
      String[] array = null;
      
      String choice;        
      boolean ch = true;    
      File myFile = new File("db\\db.txt"); 
      FileReader fileReader = new FileReader(myFile);
      BufferedReader reader = new BufferedReader(fileReader);
     
      while((line = reader.readLine()) != null){
      
      array = line.split(",");
    
      System.out.println(array[0]+"번 좌석은 현재 "+array[1]+"상태 입니다.");
      }
    }
    
    
   
    
    public void Use(String chs) throws IOException {
        Client client = new Client();       
       Server server = new Server();
         String line;
      String[] array = null;
      String a = null;
      
      boolean ch = true;    
      File myFile = new File("db\\db.txt"); 
      FileReader fileReader = new FileReader(myFile);
      BufferedReader reader = new BufferedReader(fileReader);
        
      while((line = reader.readLine()) != null){
      
      array = line.split(",");
      String numb=array[0];
      
        if(numb.equals(chs)){
      
                a = array[1];
                 
        }           
     }
      
      On on = new On();
      Off off = new Off();
      
        System.out.println("이 좌석을 사용하시겠습니까?(1.yes 2.no)");      
        String choice;
        choice = scan.next();
        if(a.equals("BREAK")){
          System.out.println("고장난자리입니다.\n좌석을 다시 선택해주세요.");
         
       client.insertnum();       
       String countChairs = client.getCheckchair();
       Use(countChairs);
        }
        else if(a.equals("OFF")) {                     
            if(choice.equals("1")){
    
        setState(on);
        powerPush(chs);   
        
     }
     else if(choice.equals("2")){
      System.out.println("취소되었습니다.");
        
     }
        }
        else if(a.equals("ON")){
        System.out.println("이미 사용중인 자리입니다.\n좌석을 다시 선택해주세요.");
       // String b = scan.nextLine();
       client.insertnum();       
     String countChairs = client.getCheckchair();
       Use(countChairs);
        }
 
     
    
}

    public void Changer(String checkchair) throws IOException {

      On on = new On();
      Off off = new Off();
      Saving saving = new Saving();
      
      String choice ;
      
      boolean ch = true;
      
     
      
         
     System.out.println("1.On   2.Off   3.고장");          
     choice = scan.next();
     
     if(choice.equals("1")){
    
        setState( on);
        powerPush(checkchair);   
        
     }
     else if(choice.equals("2")){
         
        setState(off);
        powerPush(checkchair);
        
     }
     else if(choice.equals("3")){
         
        setState(saving);
        powerPush(checkchair);
        
     }
       
    }
   
   
     public void start(){
         System.out.println("확인할 좌석의 번호를 선택하세요. : ");
     }
     
    
     
  
  
    
}