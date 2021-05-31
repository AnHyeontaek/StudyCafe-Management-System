/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_Chair.client;

import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author pkm30
 */
public class Client {
    private String checkchair;
    
    public String insertnum() throws IOException{
        int num;
        System.out.println("확인할 좌석의 번호를 선택하세요. : ");
        Scanner scan = new Scanner(System.in);   
     
        String check = scan.next();
        setCheckchair(check); // setter
        return check;
    }
    
    public void choice() {
    
    }
    
    
    
    public void setCheckchair(String checkchair){ //setter
        this.checkchair = checkchair;
    }
     public String getCheckchair( ){ // getter
        return checkchair;
    }   
}
