/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.io.IOException;
import java.util.Scanner;
import table.Check;

/**
 *
 * @author pkm30
 */
public class Client {
    public void checker() throws IOException{
     Scanner scan = new Scanner(System.in);
     Check check = new Check();
     Change change = new Change();
     String checkchair;
      
       System.out.println("확인할 좌석의 번호를 선택하세요. : ");
      checkchair = scan.next();
       //check.Checker(checkchair);
       change.Changer(checkchair);
     
      
      
      
      
      
      
    }
    
}
