package StudyCafe_management_system.IOclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tso52
 */
public class IOclient {

    public IOclient() {
        System.out.println("퇴실을 진행합니다.");
    }

    public String IOck() {
        System.out.println("퇴실할 ID를 입력해주세요");
        String id = null;
         try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        id = br.readLine();
        } catch (IOException ex) {
            System.out.println("ID 입력 오류 발생. 관리자한테 문의해주세요");
        }
        return id;
    
}
}
