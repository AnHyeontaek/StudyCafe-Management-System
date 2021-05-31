/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_server;

import cse.StudyCafe_management_system.login_client.client;
import cse.StudyCafe_management_system.login_client.admin;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tso52
 */
public class MediatorLog  {

    /**
     * @param args the command line arguments
     */

    public int start() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("로그인을 진행합니다. 1:회원  2:회원 가입 3:관리자"); //정수입력으로 사용자가 원하는 입력 진행
            int i = sc.nextInt();

            return i;
        } catch (InputMismatchException e) { //정수가 아닌 입력이 올 경우 예외처리
            return 0;
        }
    }
    
    public String select(int a){ //사용자의 입력에 따른 기능을 switch 문으로 실행
        String result = "";
                switch (a) {
            case 1: 
                client cl = new client(); //회원 로그인 객체 생성
                cl.clientplay(cl.inputid(),cl.inputpw()); //회원 아이디와 비밀번호를 입력받아 로그인 진행
                result = "Client";
                break;
            case 2:
                InsertMember jm = new InsertMember(); //회원가입 객체 생성
                join signup = new join();
                signup.join(jm.inputid(), jm.inputpw(), jm.inputName());  //사용자에게 회원가입 정보를 입력받아 매개변수로 넘김
                break;
            case 3:
                 admin ad = new admin(); //관리자 로그인 객체 생성
                 ad.adminplay(ad.inputid(), ad.inputpw()); //관리자 아이디와 비밀번호를 입력받아 관리자 로그인 실행
                 result = "Admin";
                break;
            default:
                System.out.println("입력 오류, 선택사항을 정수로 입력바람. 다시 실행 해주세요.");
                break;
        }
        return result;
    }

}
