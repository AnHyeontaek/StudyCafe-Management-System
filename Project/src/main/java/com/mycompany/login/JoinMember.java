/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.login;

import static com.mycompany.login.PerformLog.infoList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tso52
 */
public class JoinMember extends Login {

    int birth; //생년월일 Ex)980505
    String name;

    public JoinMember() { //선택 사항 알림
        System.out.println("회원가입을 선택했습니다.\n");
    }

    public String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력 해주세요: ");
        name = sc.nextLine();
        return name;
    }

    public int inputBirth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("생년월일을 입력 해주세요 ex)980505: ");
        birth = Integer.parseInt(sc.nextLine());
        return birth;
    }

    public void join(String id, int pw, String n, int b) { //회원가입 진행
        try {
            String line = null;
            String infoList = "./clientList.txt";
            File Dir = new File(infoList); //파일 지정
            BufferedReader br = new BufferedReader(new FileReader(Dir));
            while ((line = br.readLine()) != null) {
                String[] over=line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                if ( id.equals(i) ) { //아이디와 비밀번호가 맞는지 확인
                    System.out.println("아이디 중복, 다른 아이디를 설정 해주세요.");
                    System.exit(0);
                }
            }

            FileWriter fw = new FileWriter(infoList,true);
            fw.write(id+","+pw+","+n+","+b+"\n"); //텍스트파일에 구분자(,)를 넣어 차례로 입력한다.
            fw.flush();
            System.out.println("회원가입 완료, 로그인 해주세요.");

        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException ex) {
            System.out.println("입력을 다시 해주세요.");
        }
    }

    @Override
    public String inputid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("사용할 아이디를 입력 해주세요: ");
        id = sc.nextLine();
        return id;
    }

}
