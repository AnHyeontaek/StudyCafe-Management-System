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
    private String seatNumber;
    private String paymentDate;
    private int price;
    private String ticketName;
    private String paymentMethod;
    
    private PaymentInfo(PaymentBuilder builder){
        id = builder.id;
        seatNumber = builder.seatNumber;
        paymentDate = builder.paymentDate;
        price = builder.price;
        ticketName = builder.ticketName;
        paymentMethod = builder.paymentMethod;
    }
    
    @Override
    public String toString() {
        return "ID: "+ id + ",좌석번호: " + seatNumber + ",결제일자: " + 
                paymentDate + ",가격: " + price + ",이용권이름: " + ticketName + ",결제방법: " + paymentMethod  + "\n";
    }
    
    public static class PaymentBuilder{
        //필수정보
        private String id;
        private String seatNumber;
        private String paymentDate;
        private int price;
        //선택정보
        private String ticketName;
        private String paymentMethod;
        
        public PaymentBuilder(String id, String seatNumber, String paymentDate, int price){
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
            return new PaymentInfo(this);
        }
    }
}
