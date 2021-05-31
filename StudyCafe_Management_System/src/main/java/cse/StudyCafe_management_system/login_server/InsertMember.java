/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_server;

import cse.StudyCafe_management_system.login_client.Login;
import static cse.StudyCafe_management_system.login_server.PerformLog.infoList;
import java.io.*;
import java.util.*;

/**
 *
 * @author tso52
 */
public class InsertMember extends Login {

 
    String name;

    public InsertMember() { //선택 사항 알림
        System.out.println("회원가입을 선택했습니다.\n");
    }

    public String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("영문으로 이름을 입력 해주세요: ");
        name = sc.nextLine();
        return name;
    }

   

    @Override
    public String inputid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("사용할 아이디를 입력 해주세요: ");
        id = sc.nextLine();
        return id;
    }

}
