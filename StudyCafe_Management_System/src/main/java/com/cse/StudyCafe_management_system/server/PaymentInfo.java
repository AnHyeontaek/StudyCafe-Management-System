/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.server;

/**
 *
 * @author anht0
 */
public class PaymentInfo {
    private String id;
    private int seatNumber;
    private String paymentDate;
    private int price;
    private String ticketName;
    private String paymentMethod;
    
    private PaymentInfo(){
        
    }
    
    public static class PaymentBuilder{
        private String id;
        private int seatNumber;
        private String paymentDate;
        private int price;
        private String ticketName;
        private String paymentMethod;
        
        public PaymentBuilder(String id, int seatNumber, String paymentDate, int price){
            this.id = id;
            this.seatNumber = seatNumber;
            this.paymentDate = paymentDate;
            this.price = price;
        }
        public PaymentBuilder setTicketName(String ticketName){
            this.ticketName = ticketName;
            return this;
        }
        public PaymentBuilder setPaymentMethod(String paymentMethod){
            this.paymentMethod = paymentMethod;
            return this;
        }
        public PaymentInfo build(){
            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.id = id;
            paymentInfo.seatNumber = seatNumber;
            paymentInfo.paymentDate = paymentDate;
            paymentInfo.price = price;
            paymentInfo.ticketName = ticketName;
            paymentInfo.paymentMethod = paymentMethod;
            
            return paymentInfo;
        }
    }
}
