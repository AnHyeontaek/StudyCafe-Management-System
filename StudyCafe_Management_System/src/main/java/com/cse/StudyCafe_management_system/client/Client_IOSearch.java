/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_management_system.client;

import com.cse.StudyCafe_management_system.server.SearchInformation;
import com.cse.StudyCafe_management_system.server.Server_IOSearch;
import java.util.ArrayList;

/**
 *
 * @author anht0
 */
public class Client_IOSearch {
    public void ioSearch(){
        SearchInformation Searchinfo = new Server_IOSearch();
        ArrayList<String> ioList = Searchinfo.infoSearch();
        for(String line : ioList){
            System.out.println(line);
        }
    }
}
