/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.DeleteInformation;
import com.cse.StudyCafe_management_system.server.Server_SeatDelete;
import java.util.Scanner;

/**
 *
 * @author anht0
 */
public class Client_SeatDelete {
    public void deleteSeat(){
        System.out.println("삭제할 좌석번호를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        String seatnum = sc.nextLine();
        DeleteInformation DI = new Server_SeatDelete();
        DI.infoDelete(seatnum);
    }
}
