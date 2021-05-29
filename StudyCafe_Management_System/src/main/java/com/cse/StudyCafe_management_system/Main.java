/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system;

import com.cse.StudyCafe_management_system.client.Client_PayInsert;
import com.cse.StudyCafe_management_system.client.Client_SalesSearch;
import com.cse.StudyCafe_management_system.client.Client_SeatInsert;
import com.cse.StudyCafe_management_system.server.Server_PayInsert;
import java.io.IOException;

/**
 *
 * @author anht0
 */
public class Main {
    public static void main(String[] args) throws IOException{
//        Client_PayInsert ClientPI = new Client_PayInsert();
//        ClientPI.insertPayment();
//        Client_SalesSearch ClientSS = new Client_SalesSearch();
//        ClientSS.searchSales();
        Client_SeatInsert Client_SI = new Client_SeatInsert();
        Client_SI.insertSeat();
    }
}
