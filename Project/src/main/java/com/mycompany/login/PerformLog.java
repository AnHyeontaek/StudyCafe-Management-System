/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.login;

/**
 *
 * @author tso52
 */
public  interface PerformLog  {
    String infoList = "clientList.txt"; //파일 경로
    void perlog(String id, int passwprd);
}
