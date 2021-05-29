/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.CheckInformation;
import com.cse.StudyCafe_management_system.server.InsertInformation;
import com.cse.StudyCafe_management_system.server.Server_CheckUser;
import com.cse.StudyCafe_management_system.server.Server_UserInCafe;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anht0
 */
public class Client_UserInCafe {
    public void userInCafe(String id) throws IOException{
        int userNum = 1;
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String Date = date.format(today);
        InsertInformation InsertInfo = new Server_UserInCafe();
        CheckInformation Server_UC = new Server_CheckUser();
        userNum = Server_UC.infocheck();
        String text = userNum + ",ID:"+ id +",입실시간:" +Date +"\n";
        InsertInfo.infoInsert(text);
        System.out.println("입실을 시작합니다." + "현재시각 : " + Date);
    }
}
