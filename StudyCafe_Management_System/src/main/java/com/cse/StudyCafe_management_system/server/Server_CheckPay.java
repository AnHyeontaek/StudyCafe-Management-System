/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.File;
<<<<<<< HEAD
import java.io.FileReader;
import java.io.IOException;
=======
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> origin/hyeontaek

/**
 *
 * @author anht0
 */
<<<<<<< HEAD
public class Server_CheckPay {
    public int checkPay() throws IOException{
        int lineCnt = 1;
        File Dir = new File("./Pay.txt"); //파일 지정
        BufferedReader br = new BufferedReader(new FileReader(Dir));
        while ((br.readLine()) != null) {
            lineCnt++;
=======
public class Server_CheckPay implements CheckInformation{
    @Override
    public int infocheck(){
        int lineCnt = 1;
        File Dir = new File("./Pay.txt"); //파일 지정
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(Dir));
            while ((br.readLine()) != null) {
            lineCnt++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server_CheckPay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server_CheckPay.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> origin/hyeontaek
        }
        return lineCnt;
    }
}
