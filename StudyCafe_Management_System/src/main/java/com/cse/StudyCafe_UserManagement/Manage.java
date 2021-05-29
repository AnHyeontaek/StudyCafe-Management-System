/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_UserManagement;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pkm30
 */
public class Manage extends SubjectManage {

    private List<User> member = new ArrayList<>();
    
 public Manage(){
     observers = new ArrayList<>();
     
 }
    public List<User> getMemberNames() {
        return member;
    }
 
    public void addMemberName(User user) {  
        this.member.add(user);
        
    }
        public void deleteMemberName(String id) { 
        
        member.removeIf(i->i.getId().equals(id)); 
        notifyuser();
    }
        public void addUser(User user){  
         this.member.add(user);
        notifyuser();
        }
   
    @Override
    public void registeruser(Observer view) { // Observer 객체 등록
        observers.add(view);
        
    }

    @Override
    public void deleteuser(Observer view) {  // Observer 객체 삭제
       observers.remove(view);
       notifyuser();
    }

    @Override
    public void notifyuser() { // 변경사실을 알림
       observers.stream().forEach(data -> {
data.update();
        });
    }
    
    public void setUser(String id, String passwd, String name){ 
        for(User m : member){
            if(m.getId().equals(id)){
                m.setPasswd(passwd);
                m.setName(name);
            }
        }
        notifyuser();
    }
}
