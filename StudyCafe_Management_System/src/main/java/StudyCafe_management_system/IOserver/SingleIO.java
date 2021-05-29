package StudyCafe_management_system.IOserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tso52
 */
public enum SingleIO { //enum을 활용한 싱글턴 패턴 구현
    INSTANCE;

    private String OutList = "./Outclient.txt"; //퇴실시간 기록파일
    private String Outuser = "";// 디폴트 값 
    private String infoList = "./ClientList.txt"; //고객 정보 파일

    public SingleIO getInstance() {
        return INSTANCE;
    }

    public String getOutuser() {
        return Outuser;
    }

    public void Outcheck(String id) { //입력받은 ID를 회원 정보와 확인하는 기능. 불일치시 프로그램 종료
        try {
            int b = 0;
            String line = null;
            File Dir = new File(infoList); //파일 지정
            BufferedReader br = new BufferedReader(new FileReader(Dir));
            while ((line = br.readLine()) != null) {
                String[] over = line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                if (id.equals(i)) { //입력한 아이디와 일치하는 아이디가 있는지 확인
                    b = 1; //없는 ID입력시 확인을 위한 변수
                    System.out.println("아이디를 확인했습니다. 퇴실을 진행 하겠습니다.");
                    Outuser = id; //사용자 아이디를 객체의 아이디로 지정
                    break;
                }
            }
            if (b == 0) {
                System.out.println("없는 ID입니다. 다시 진행해주세요.");
                System.exit(0); //프로그램 종료
            }
        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException ex) {
            System.out.println("입력을 다시 해주세요.");
        }
    }

    public void Out() {
        try {

            Date today = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String Date = date.format(today);
            FileOutputStream output=new FileOutputStream(OutList,true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter bw=new BufferedWriter(writer);
            String text = "ID: " + Outuser + ",퇴실시간:" + Date + "\n";//텍스트파일에 구분자(,)를 넣어 차례로 입력한다.
            bw.write(text);
            bw.flush();
            bw.close();
            System.out.println("퇴실이 정상처리 됐습니다.");

        } catch (IOException ex) {
            System.out.println("퇴실처리 오류, 파일정보를 확인해주세요");
        }
    }

    public void OutTimeSerch() {
        try {
            String line = null;
            File Dir = new File(OutList); //파일 지정
            BufferedReader br = new BufferedReader(new FileReader(Dir));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("퇴실조회 오류, 파일정보를 확인해주세요");
        } catch (IOException ex) {
            System.out.println("입출력 오류");
        }
    }
}


