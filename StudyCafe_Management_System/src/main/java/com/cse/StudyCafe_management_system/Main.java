/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system;

import com.cse.StudyCafe_management_system.client.Client_SalesSearch;
import com.cse.StudyCafe_management_system.server.Server_PayInsert;

/**
 *
 * @author anht0
 */
public class Main {
    public static void main(String[] args){
//        Client_SalesSearch ClientSS = new Client_SalesSearch();
//        ClientSS.searchSales();
        Server_PayInsert ServerPI = new Server_PayInsert();
        ServerPI.infoInsert();
        
    }
}
