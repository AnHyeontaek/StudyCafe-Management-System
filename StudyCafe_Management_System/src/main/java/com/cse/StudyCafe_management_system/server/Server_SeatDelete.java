/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_SeatDelete implements DeleteInformation{
    @Override
    public void infoDelete(String seatNum){
        String dummy = "";
        int count = Integer.parseInt(seatNum);
        try {
            FileInputStream input=new FileInputStream("./Seat.txt");
            InputStreamReader reader=new InputStreamReader(input,"UTF-8");
            BufferedReader br =new BufferedReader(reader);
            String line;
           for (int i=0; i< Integer.parseInt(seatNum)-1; i++){
               line = br.readLine();
               dummy += (line + "\r\n");
            }
            
            br.readLine();
           
            while((line = br.readLine())!=null) {
                String[] temp = line.split(",",2);
                
		dummy += (count+ "," + temp[1] + "\r\n" );
                count++;
            }
          
            FileWriter fw = new FileWriter("./Seat.txt");
            fw.write(dummy);

            fw.flush();
            fw.close();
            System.out.println("좌석이 삭제되었습니다.");
      
        } catch (IOException ex) {
            Logger.getLogger(Server_SeatDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
