/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.InsertInformation;
import com.cse.StudyCafe_management_system.server.PaymentInfo;
import com.cse.StudyCafe_management_system.server.Server_PayInsert;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anht0
 */
public class Client_PayInsert {
    public void insertPayment(){ 
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy|MM|dd");
        String PayDate = date.format(today);
        // Client => 사용자가 입력받은 값을 통해 PaymentInfo 생성 
        PaymentInfo info1 = new PaymentInfo.PaymentBuilder("anht0624",12,PayDate,2500).setTicketName("1시간 이용권").setPaymentMethod("카드").build( );
        InsertInformation II = new Server_PayInsert();
        II.infoInsert(info1.toString());
        
        
    }
//    public void setPayment(){
//        PaymentInfo info1 = new PaymentInfo.PaymentBuilder("anht0624",12,"2021-05-27",2500).setTicketName("1시간 이용권").setPaymentMethod("카드").build( );
//    }
}
