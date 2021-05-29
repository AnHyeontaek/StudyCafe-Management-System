package StudyCafe_management_system.IOclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tso52
 */
public class IOadmin {

    public IOadmin() {
        System.out.println("퇴실 정보를 조회합니다.");
    }

    public String Adminid() {
        System.out.println("관리자 아이디를 입력해주세요");
        String id = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            id = br.readLine();
        } catch (IOException e) {
            System.out.println("입력오류");
        }
        return id;
    }

    public int Adminpw() {
        System.out.println("관리자 비밀번호를 입력해주세요");
        int pw = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            pw = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("입력오류");
        }
        return pw;
    }
}

