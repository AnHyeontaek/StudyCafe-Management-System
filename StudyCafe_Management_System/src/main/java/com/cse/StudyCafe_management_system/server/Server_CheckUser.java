/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_CheckUser implements CheckInformation{
    @Override
    public int infocheck(){
        int lineCnt = 1;
        File Dir = new File("./InUser.txt"); //파일 지정
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(Dir));
            while ((br.readLine()) != null) {
                lineCnt++;
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Server_CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server_CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCnt;
    }
}
