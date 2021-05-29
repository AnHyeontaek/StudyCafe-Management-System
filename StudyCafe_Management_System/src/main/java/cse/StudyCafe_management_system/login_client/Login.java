/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_client;

import cse.StudyCafe_management_system.login_server.PerformLog;
import java.util.Scanner;

/**
 *
 * @author tso52
 */
public abstract class Login {

    PerformLog LogCA;

    protected String id;
    protected String password; //비밀번호 숫자 6자리

    public abstract String inputid();

    public String inputpw() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("비밀번호를 입력 해주세요(숫자 6자리): ");
            password = sc.nextLine();

            if (password.length() != 6) { //6자리 숫자로 입력한지 확인
                System.out.println("6자리로 입력해 주세요.");
                System.exit(0); //6자리가 아니면 프로그램 종료
            }
            return password;
        } catch (NumberFormatException e) { //정수가 아닌 입력이 올 경우 예외처리}
            System.out.println("비밀번호를 정수로 입력 해주세요.");
        }
        return password;
    }
}


