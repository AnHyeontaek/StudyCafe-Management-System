/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_UserManagement;

/**
 *
 * @author pkm30
 */
import com.cse.StudyCafe_Chair.server.Off;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageMain {

    private static String id;
    private static boolean c;
    private static String temppasswd;
    private static String tempname;
    private static String tempid;
   

    Manage member = new Manage();
    public static String service;
    static int check = 0;

    boolean first = true;

    public ManageMain() throws IOException {

        
        member.registeruser(new NormalDisplay(member));
        if (first == true) {
            addData();
            first = false;
        } 
        else {
        }

        selectService();

    }

    public void deleteFile(String tempId) { //  사용자 삭제
        
        File file = new File("./ClientList.txt");		
        String dummy = "";
        try {
           BufferedReader br = new BufferedReader(new FileReader("./ClientList.txt"));
            String line;
            for (int i = 0; i < check - 1; i++) {
                line = br.readLine();
                dummy += (line + "\r\n");

            }
            br.readLine();
            while ((line = br.readLine()) != null) {
                dummy += (line + "\r\n");
            }
            FileWriter fw = new FileWriter("./ClientList.txt");
            fw.write(dummy);
            fw.close();
            br.close();
          System.out.println("삭제성공");
      
        } catch (IOException ex) {
            Logger.getLogger(Off.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }

    public void modifyFile(String tempId, String tempPasswd, String tempName) { // 사용자 수정
       

        String data = tempId + "," + tempPasswd + "," + tempName ;
        String dummy = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("./ClientList.txt"));
            String line;
            for (int i = 0; i < check - 1; i++) {
                line = br.readLine();
                dummy += (line + "\r\n");

            }
            br.readLine();
            dummy += data + "\r\n";
            while ((line = br.readLine()) != null) {
                dummy += (line + "\r\n");
            }
            FileWriter fw = new FileWriter("./ClientList.txt");
            fw.write(dummy);
            fw.close();
            br.close();

        } catch (Exception e) {
      
            e.printStackTrace();
        }
    }

    public void addData() throws IOException { // 옵저버 패턴 객체 추가

 
        String[] array;

        try {
            File myFile = new File("./ClientList.txt"); 
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {          
                array = line.split(",");
                String know = array[0].substring(0, 1);
              
                member.addMemberName(new User(array[0], array[1], array[2]));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void selectService() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       
        System.out.println("modify(수정)/delete(삭제)/q(종료)");
        service = in.readLine();
        if (service.equals("q")) {

            System.out.println("종료합니다. ");
        } else if (service.equals("modify")) {

            System.out.println("변경하실 id를 입력해 주세요");
            InputUser();
            modifyUser();
        } else if (service.equals("delete")) {
            deleteUser();

        } 
        else {
            System.out.println("다시 입력해주세요 "); 
            selectService();
        }
    }

    public boolean InputUser() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" 아이디  : ");
        id = in.readLine();


        c = readfile(id); 

        return c; 
    }

    public boolean readfile(String id) { // 등록이 되어있는지 확인
        String str = id;
        Boolean ok = true;
        try {
            File myFile = new File("./ClientList.txt"); 
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            if (id.length() == 0) {  
                return ok;
            }
            String line = null;
            String[] array;
            check = 0;
            while ((line = reader.readLine()) != null && ok == true) {
               
                array = line.split(",");
                String idp = array[0];

                check++;
                if (idp.equals(str)) { 
                    tempid = array[0];
                    temppasswd = array[1];
                    tempname = array[2];
                    ok = false;

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ok;
    }

    public void modifyUser() throws IOException { // 비밀번호, 이름 변경

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        
        if (c == false) {
 
            System.out.println("id : " + tempid + " , passwd : " + temppasswd + " , name : " + tempname);
            System.out.println("위 정보가 맞나요? (yes/no) (q:종료)");
            String check = in.readLine();
            if (check.equals("q")) {

                System.out.println("종료합니다. ");
            } else if (check.equals("yes")) {

                System.out.println("변경하실 id의 passwd/name을 입력해 주세요");
                System.out.println("id :  " + id);
                System.out.println("비밀번호를 입력하세요 ");

                temppasswd = in.readLine();                 
                System.out.println("이름을 입력하세요.");
                tempname = in.readLine();
            
               
               
                member.setUser(id, temppasswd, tempname);
                modifyFile(id, temppasswd, tempname);
                System.out.println("변경되었습니다.");

            } else {
                System.out.println("다시 입력해주세요"); 
                InputUser();
                modifyUser();
            }
        } 
    }

    

    public void deleteUser() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        member.notifyuser();
        System.out.println("삭제하실 id를 입력해 주세요");
        InputUser();
        if (c == false) {

            System.out.println("id : " + tempid + " , passwd : " + temppasswd + " , name : " + tempname);
            System.out.println("위 정보가 맞나요? (yes/no) (q:종료)");
            String check = in.readLine();
            if (check.equals("q")) {

                System.out.println("사용자관리 종료합니다. ");
            } else if (check.equals("yes")) {
                deleteFile(tempid);
                System.out.println("삭제되었습니다.");


                member.deleteMemberName(id);
             
            } else {
                System.out.println("다시 입력해주세요");
                deleteUser();
            }
        } else {
            System.out.println("다시 입력해주세요");
            deleteUser();
        }
    }

}

