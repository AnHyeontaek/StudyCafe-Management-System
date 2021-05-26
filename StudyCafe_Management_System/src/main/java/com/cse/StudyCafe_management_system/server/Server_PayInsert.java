/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

import com.cse.StudyCafe_management_system.server.PaymentInfo.PaymentBuilder;

/**
 *
 * @author anht0
 */
public class Server_PayInsert implements InsertInformation {
    
    public void infoInsert(){
        PaymentInfo info1 = new PaymentInfo.PaymentBuilder("anht0624",12,"2021-05-27",2500).setTicketName("1시간 이용권").setPaymentMethod("카드").build( );
        info1.print();
    }
    

}
