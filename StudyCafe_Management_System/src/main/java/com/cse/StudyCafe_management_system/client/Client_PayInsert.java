/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.CheckInformation;
import com.cse.StudyCafe_management_system.server.InsertInformation;
import com.cse.StudyCafe_management_system.server.PaymentInfo;
import com.cse.StudyCafe_management_system.server.Server_CheckPay;
import com.cse.StudyCafe_management_system.server.Server_PayInsert;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author anht0
 */
public class Client_PayInsert {
    public int selectPaymentType(){
        int paymentType;
        Scanner sc = new Scanner(System.in);
        System.out.println("결제할 방법을 선택하세요. |1. 카드 2. 현금");
        paymentType = sc.nextInt();
        return paymentType;
    }
    public int selectTicket(){
        int ticket;
        Scanner sc = new Scanner(System.in);
        System.out.println("결제할 이용권을 선택하세요. | 1. 2시간 이용권(3000원) 2. 4시간 이용권(5000원) 3. 8시간 이용권(8000원)|");
        ticket = sc.nextInt();
        return ticket;
    }

    public void insertPayment(String id, String seatNum) throws IOException{ 
        int ticketType, price=0, paymentType, payCount = 1;
        String ticketName = "";
        String paymentMethod = "";
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy|MM|dd");
        String PayDate = date.format(today);
        paymentType = selectPaymentType();
        if(paymentType == 1){
            paymentMethod = "카드";
        }else if (paymentType == 2){
            paymentMethod = "현금";
        }
        
        ticketType = selectTicket();
        if(ticketType == 1){
            price = 3000;
            ticketName = "2시간 이용권";
        }else if(ticketType == 2){
            price = 5000;
            ticketName = "4시간 이용권";
        }else if(ticketType == 3){
            price = 8000;
            ticketName = "8시간 이용권";
        }
        // Client => 사용자가 입력받은 값을 통해 PaymentInfo 생성 
        PaymentInfo info1 = new PaymentInfo.PaymentBuilder(id,seatNum,PayDate,price).setTicketName(ticketName).setPaymentMethod(paymentMethod).build( );
        InsertInformation II = new Server_PayInsert();
        CheckInformation CI = new Server_CheckPay();
        payCount = CI.infocheck();
        String text = payCount +","+info1.toString();
        II.infoInsert(text);
    }
}
