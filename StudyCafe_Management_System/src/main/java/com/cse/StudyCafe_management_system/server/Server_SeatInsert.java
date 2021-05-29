/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_SeatInsert implements InsertInformation {
    int seatnum = 0;
    
    @Override
    public void infoInsert(String seatinfo){
        try{
            FileOutputStream output=new FileOutputStream("./Seat.txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter bw=new BufferedWriter(writer);
            bw.write(seatinfo);
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다!");
        }
        catch (IOException ex) {
            Logger.getLogger(Server_SeatInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

