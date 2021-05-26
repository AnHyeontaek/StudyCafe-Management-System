/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author anht0
 */
public class FileRead  {
    private String path;
    
   
    public ArrayList<String> readFile() throws IOException {
        ArrayList<String> resultFile = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
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
        }
        return resultFile;
    }
}
