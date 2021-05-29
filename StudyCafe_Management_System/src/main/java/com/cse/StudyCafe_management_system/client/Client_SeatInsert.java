/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.CheckInformation;
import com.cse.StudyCafe_management_system.server.InsertInformation;
import com.cse.StudyCafe_management_system.server.Server_CheckSeat;
import com.cse.StudyCafe_management_system.server.Server_SeatInsert;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author anht0
 */
public class Client_SeatInsert {
    public void insertSeat() throws IOException{
        int seatnum = 0;
        int seatCount = 0;
        String seatInfo = "";
        InsertInformation Server_SI = new Server_SeatInsert();
        CheckInformation Server_C = new Server_CheckSeat();
        seatCount = Server_C.infocheck();
        System.out.println("좌석을 추가합니다. 현재 좌석 수 : " + seatCount+ "EA");
        System.out.println("추가할 좌석의 수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        seatnum = sc.nextInt();
        for(int i = seatCount+1; i<seatCount+seatnum+1;i++){
                seatInfo = i + ",OFF\n";
                Server_SI.infoInsert(seatInfo);
        }
    }
    
}
