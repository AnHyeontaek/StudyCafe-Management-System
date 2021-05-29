/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_Chair.server;

import com.cse.StudyCafe_Chair.client.Client;
import com.cse.StudyCafe_management_system.client.Client_PayInsert;
import com.cse.StudyCafe_management_system.client.Client_UserInCafe;
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
    private String ID;
    private String seatNumber;

    
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
        File myFile = new File("./Seat.txt"); 
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
      File myFile = new File("./Seat.txt"); 
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

        if(a.equals("OFF")) {                     
            if(choice.equals("1")){
                String countChairs = client.getCheckchair();
                Client_PayInsert ClientPI = new Client_PayInsert();
                ClientPI.insertPayment(ID,seatNumber);
                setState(on);
                powerPush(chs);
                Client_UserInCafe Client_UIC = new Client_UserInCafe();
                Client_UIC.userInCafe(ID);
                
        
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
      
      String choice ;
      
      boolean ch = true;
      
     
      
         
     System.out.println("1.On   2.Off");          
     choice = scan.next();
     
     if(choice.equals("1")){
    
        setState( on);
        powerPush(checkchair);   
        
     }
     else if(choice.equals("2")){
         
        setState(off);
        powerPush(checkchair);
        
     }  
    }
    public void getID(String id){
        ID = id;
    }
    public void getSeatnum(String seatNum){
        seatNumber = seatNum;
    }
    public void Userout(String iid) throws IOException{
        Off off = new Off();
        String line;
        String[] array = null;
        String[] array2 = null;
        String[] array3 = null;
        String a = null;

        File myFile = new File("./Pay.txt");
        FileReader fileReader = new FileReader(myFile);
        BufferedReader reader = new BufferedReader(fileReader);

        while ((line = reader.readLine()) != null) {


            array = line.split(",");
            String numb = array[1];
            array2 = numb.split(": ");
            String numb2 = array2[1];


            String chs = array[2];
            array3 = chs.split(": ");
            String chs2 = array3[1];



            if (numb2.equals(iid)) {

                a = array3[1];
                setState(off);
                powerPush(a);

            }
        }
    }
    
}