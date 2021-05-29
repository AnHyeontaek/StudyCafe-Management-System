/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_server;

import StudyCafe_management_system.IOserver.IOMain;
import com.cse.StudyCafe_Chair.client.Client;
import com.cse.StudyCafe_Chair.server.Server;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author tso52
 */
public class performC implements PerformLog {

    @Override
    public void perlog(String id, String password) {
        try {
            String line = null;
            FileInputStream input=new FileInputStream("./ClientList.txt");
            InputStreamReader reader=new InputStreamReader(input);
            BufferedReader br =new BufferedReader(reader);
            while ((line = br.readLine()) != null) {
                String[] over = line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                String p = over[1]; //비밀번호 값을 불러와 int값으로 변환하여 비교 변수에 대입
                if (p.equals(password) && id.equals(i)) { //아이디와 비밀번호가 맞는지 확인
                    System.out.println("로그인 완료");
                    Client client = new Client();       
                    Server server = new Server();
                    server.getID(id);
                    System.out.println("1. 결제 2. 퇴실");
                    Scanner sc = new Scanner(System.in);
                    int choiceType = sc.nextInt();
                    if(choiceType == 1){
                        server.view();
                        String num = client.insertnum();
                        server.getSeatnum(num);
                        String countChairs = client.getCheckchair();
                        server.Use(countChairs);
                    }
                    else if(choiceType == 2){
                        IOMain IOM = new IOMain();
                        IOMain.IOplay(1);
                    }
                    break;
                }
            }
            if (line == null) { //맞는 아이디와 비밀번호가 없으면 로그인 실패알림.
                System.out.println("로그인 실패");
                MediatorLog log = new MediatorLog();
                int tema = log.start();
                log.select(tema);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException ex) {
            System.out.println("입력을 다시 해주세요.");
        }
    }

}
