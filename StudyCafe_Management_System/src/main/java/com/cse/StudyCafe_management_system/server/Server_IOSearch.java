/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_IOSearch implements SearchInformation{
    @Override
    public ArrayList<String> infoSearch(){
        ArrayList<String> resultFile = new ArrayList<>();
        try {
            FileInputStream input=new FileInputStream("./InUser.txt");
            InputStreamReader reader=new InputStreamReader(input,"UTF-8");
            BufferedReader br =new BufferedReader(reader);
            resultFile.add("---입실 정보---");
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
               resultFile.add(line);
            }
            br.close();
            FileInputStream input2=new FileInputStream("./Outclient.txt");
            InputStreamReader reader2=new InputStreamReader(input2,"UTF-8");
            BufferedReader br2 =new BufferedReader(reader2);
            resultFile.add("---퇴실 정보---");
            while (true) {
                String line2 = br2.readLine();
                if (line2 == null) {
                    break;
                }
               resultFile.add(line2);
            }
            br2.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다!");
        } catch (IOException ex) {
            Logger.getLogger(Server_IOSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultFile;
    }
}
