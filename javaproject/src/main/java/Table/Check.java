/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pkm30
 */
public class Check {
    public void Checker() throws IOException {
 
     String line;
      String[] array = null;
      Scanner scan = new Scanner(System.in);
      String checkchair;
      String choice;   
      
      boolean ch = true;
      
      System.out.println("확인할 좌석의 번호를 선택하세요. : ");
      checkchair = scan.next();
      
      File myFile = new File("db\\db.txt"); 
      FileReader fileReader = new FileReader(myFile);
      BufferedReader reader = new BufferedReader(fileReader);
     
      while((line = reader.readLine()) != null){
      
      array = line.split(",");
      String numb=array[0];
      
        if(numb.equals(checkchair)){
      
        System.out.println(array[0]+"번 좌석은 현재 "+array[1]+"상태 입니다.");        
                 
        }           
     }
    
}
}
