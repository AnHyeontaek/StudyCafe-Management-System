/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author anht0
 */
public class join {
    public void join(String id, String pw, String n, String b) { //회원가입 진행
        String Text = id+","+pw+","+n+","+b+"\n";
        try {
            String line = null;
            FileInputStream input=new FileInputStream("./ClientList.txt");
            InputStreamReader reader=new InputStreamReader(input);
            BufferedReader br =new BufferedReader(reader);
            
            while ((line = br.readLine()) != null) {
                String[] over=line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                if ( id.equals(i) ) { //아이디와 비밀번호가 맞는지 확인
                    System.out.println("아이디 중복, 다른 아이디를 설정 해주세요.");
                    System.exit(0);
                }
            }

            FileOutputStream output=new FileOutputStream("./ClientList.txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output);
            BufferedWriter bw=new BufferedWriter(writer);
            bw.write(Text); //텍스트파일에 구분자(,)를 넣어 차례로 입력한다.
            bw.close();
            System.out.println("회원가입 완료, 로그인 해주세요.");

        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException ex) {
            System.out.println("입력을 다시 해주세요.");
        }
    }
}
