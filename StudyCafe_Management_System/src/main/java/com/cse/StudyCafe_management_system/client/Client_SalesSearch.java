/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.SearchInformation;
import com.cse.StudyCafe_management_system.server.Server_SalesSearch;
import java.util.ArrayList;


/**
 *
 * @author anht0
 */
public class Client_SalesSearch {
    public void searchSales(){
        SearchInformation SI = new Server_SalesSearch();
        ArrayList<String> SalesList = SI.infoSearch();
        for(String line : SalesList) {
            System.out.println(line);
        }
        
    }
}
