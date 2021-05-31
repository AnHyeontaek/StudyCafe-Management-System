/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.StudyCafe_management_system.login_server;

<<<<<<< HEAD
import com.cse.StudyCafe_Chair.server.Server;
import com.cse.StudyCafe_UserManagement.ManageMain;
=======

import StudyCafe_UserManagement.ManageMain;
import com.cse.StudyCafe_Chair.server.Server;
import com.cse.StudyCafe_management_system.client.Client_IOSearch;
import com.cse.StudyCafe_management_system.client.Client_PayDelete;
import com.cse.StudyCafe_management_system.client.Client_SalesSearch;
>>>>>>> origin/hyeontaek
import com.cse.StudyCafe_management_system.client.Client_SeatDelete;
import com.cse.StudyCafe_management_system.client.Client_SeatInsert;
import static cse.StudyCafe_management_system.login_server.PerformLog.infoList;
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
public class performA implements PerformLog{
     
    @Override
    public void perlog(String id, String password)  {
        try {
            String line = null;
            String pw = String.valueOf(password); //pw를 스트링으로 변환하여 검색
            Scanner sc = new Scanner(System.in);
            FileInputStream input=new FileInputStream("./admin.txt");
            InputStreamReader reader=new InputStreamReader(input,"UTF-8");
            BufferedReader br =new BufferedReader(reader);
            while ((line = br.readLine()) != null) {
                String[] over = line.split(","); //텍스트 파일의 첫번째에 위치하는 ID값을 추출
                String i = over[0]; //문자열끼리 비교를 위해 ID값을 배열에서 옮김
                String p = over[1]; //비밀번호 값을 불러와 int값으로 변환하여 비교 변수에 대입
                if (p.equals(password) && id.equals(i)) { //아이디와 비밀번호가 맞는지 확인
                    System.out.println("로그인 완료");
<<<<<<< HEAD
                    System.out.println("1. 좌석관리 2. 고객관리 3. 매출관리 4. 입퇴실관리");
=======
                    System.out.println("1. 좌석관리 2. 고객관리 3. 매출관리 4. 입퇴실정보 조회");
>>>>>>> origin/hyeontaek
                    int AdminNum = sc.nextInt();
                    if(AdminNum == 1){
                            System.out.println("1.좌석추가 2.좌석삭제 3.좌석조회");
                            int seat = sc.nextInt();
                            if(seat == 1){
                                Client_SeatInsert Client_SI = new Client_SeatInsert();
                                Client_SI.insertSeat();
                            }else if(seat == 2){
                                Client_SeatDelete Client_SD = new Client_SeatDelete();
                                Client_SD.deleteSeat();
                            }else if(seat == 3){
                                Server server = new Server();
                                server.view();
                            }
                    }
                    else if(AdminNum == 2){
                        ManageMain manage = new ManageMain();
                    }
<<<<<<< HEAD
=======
                    else if(AdminNum == 3){
                        System.out.println("1.매출조회 2.결제취소");
                        int paynum = sc.nextInt();
                        if(paynum == 1){
                            Client_SalesSearch Client_SS = new Client_SalesSearch();
                            Client_SS.searchSales();
                        }
                        else if(paynum == 2){
                            Client_PayDelete Client_PD = new Client_PayDelete();
                            Client_PD.deletePay();
                        }
                    }
                    else if(AdminNum == 4){
                        System.out.println("입퇴실정보를 조회합니다.");
                        Client_IOSearch Client_IO = new Client_IOSearch();
                        Client_IO.ioSearch();
                    }
>>>>>>> origin/hyeontaek
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
