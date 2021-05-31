package StudyCafe_management_system.IOserver;

import StudyCafe_management_system.Logclient.admin;
import StudyCafe_management_system.IOserver.SingleIO;
import StudyCafe_management_system.IOclient.IOadmin;
import StudyCafe_management_system.IOclient.IOclient;
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
public class IOMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = IOselect();
        IOplay(a);

    }

    public static int IOselect() {
        System.out.println("1. 퇴실 진행 2. 퇴실 정보조회(관리자 전용)");
        int menu = 0; //선택사항 정보 저장 변수
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        menu = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println("정보 선택오류 발생. 올바른 보기를 선택해주세요");
        }
        return menu;
    }

    public static void IOplay(int i) {
        switch (i) {
            case 1:
                IOclient cl = new IOclient(); //퇴실 로그인 객체 생성
                SingleIO.INSTANCE.Outcheck((cl.IOck())); //cl 객체의 입력아이디 반환 함수를 매개변수로 전달. 일치하는 ID없으면 종료
                SingleIO.INSTANCE.Out();
                break;
            case 2:
                IOadmin outad = new IOadmin(); //관리자 로그인 객체 생성
                admin ad = new admin(); //관리자 로그인 객체 생성                                        관리자 정보 일치하지않으면 종료
                ad.adminplay( outad.Adminid(), outad.Adminpw() ); //매개변수 함수는 BuffedReader로 새로 정의, 아이디확인은 performA 코드 재사용
                SingleIO.INSTANCE.OutTimeSerch(); //퇴실시간 조회, 관리자 ID: admin PW: 123456
                 break;
            default:
            System.out.println("입력 오류, 선택사항을 정수로 입력바람. 다시 실행 해주세요.");
            break;
        }
    }

}
