/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author anht0
 */
public class Server_CheckSeat {
    public int checkseat() throws IOException{
        int lineCnt = 0;
        File Dir = new File("./Seat.txt"); //파일 지정
        BufferedReader br = new BufferedReader(new FileReader(Dir));
        while ((br.readLine()) != null) {
            lineCnt++;
        }
        return lineCnt;
    }
}
