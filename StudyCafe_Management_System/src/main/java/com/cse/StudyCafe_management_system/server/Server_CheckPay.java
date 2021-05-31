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
public class Server_CheckPay {
    public int checkPay() throws IOException{
        int lineCnt = 1;
        File Dir = new File("./Pay.txt"); //파일 지정
        BufferedReader br = new BufferedReader(new FileReader(Dir));
        while ((br.readLine()) != null) {
            lineCnt++;
        }
        return lineCnt;
    }
}
