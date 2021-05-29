/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.StudyCafe_UserManagement;

import java.util.List;

/**
 *
 * @author pkm30
 */
public class NormalDisplay implements Observer,DisplayUser {
    private Manage member;
    
    public NormalDisplay(Manage member) {
        this.member = member;
    }
    
    @Override
    public void update() {
        display(member.getMemberNames());
    }
 
    @Override
    public void display(List<User> members) {
        members.stream().forEach((data) -> {                         
            System.out.println("아이디 : " + data.getId()+" 비밀번호 : " + data.getPasswd()+" 이름 : " + data.getName());           
        });
        //data.getId = 비번 , data.getName = 이름 data.getPasswd = null..? 
        System.out.println();
    }

 
}