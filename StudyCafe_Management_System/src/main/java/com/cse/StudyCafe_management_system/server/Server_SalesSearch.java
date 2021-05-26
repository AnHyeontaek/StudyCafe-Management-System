/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_SalesSearch implements SearchInformation {
    @Override
    public ArrayList<String> infoSearch(){
        ArrayList<String> resultFile = new ArrayList<>();
        try {
            FileInputStream input=new FileInputStream("C:\\Users\\anht0\\Pay.txt");
            InputStreamReader reader=new InputStreamReader(input,"UTF-8");
            BufferedReader br =new BufferedReader(reader);
//            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anht0\\Pay.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
               resultFile.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다!");
        } catch (IOException ex) {
            Logger.getLogger(Server_SalesSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultFile;
    }
}
