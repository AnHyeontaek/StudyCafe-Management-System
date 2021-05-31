/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import com.cse.StudyCafe_management_system.client.Client_PayInsert;
import com.cse.StudyCafe_management_system.server.PaymentInfo.PaymentBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anht0
 */
public class Server_PayInsert implements InsertInformation {
    
    @Override
    public void infoInsert(String paymentinfo){
        try{
            FileOutputStream output=new FileOutputStream("./Pay.txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter bw=new BufferedWriter(writer);
            bw.write(paymentinfo);
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다!");
        }
        catch (IOException ex) {
            Logger.getLogger(Server_PayInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
