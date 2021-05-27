/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.login;

import java.util.Scanner;

/**
 *
 * @author tso52
 */
public class client extends Login {


    public client() {
        System.out.println("회원 로그인을 선택했습니다.");
    }

    @Override
    public String inputid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 아이디를 입력 해주세요: ");
        id = sc.nextLine();
        return id;
    }

    public void clientplay(String a , int b) {
        this.LogCA = new performC();
        LogCA.perlog(a, b);
    }

}
