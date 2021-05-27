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
public class admin extends Login {

    public admin() {
        System.out.println("관리자 로그인을 선택했습니다.");
    }

    public void adminplay(String a, int b) {
        this.LogCA = new performA();
        LogCA.perlog(a, b);
    }

    @Override
    public String inputid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("관리자 아이디를 입력 해주세요: ");
        id = sc.nextLine();
        return id;
    }

}
