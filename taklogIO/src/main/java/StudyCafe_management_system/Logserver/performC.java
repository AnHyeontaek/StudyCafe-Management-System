/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudyCafe_management_system.Logserver;

import StudyCafe_management_system.Logclient.PerformLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tso52
 */
public class performC implements PerformLog {

    @Override
    public void perlog(String id, int password) {
        try {
            String line = null;
            String pw = String.valueOf(password); //pw를 스트링으로 변환하여 검색
            File Dir = new File(infoList); //파일 지정
            BufferedReader br = new BufferedReader(new FileReader(Dir));
            while ((line = br.readLine()) != null) {
                String[] over = line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                int p = Integer.parseInt(over[1]); //비밀번호 값을 불러와 int값으로 변환하여 비교 변수에 대입
                if (p == password && id.equals(i)) { //아이디와 비밀번호가 맞는지 확인
                    System.out.println("로그인 완료");
                    break;
                }
            }
            if (line == null) { //맞는 아이디와 비밀번호가 없으면 로그인 실패알림.
                System.out.println("로그인 실패");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException ex) {
            System.out.println("입력을 다시 해주세요.");
        }
    }

}
