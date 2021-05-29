/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudyCafe_UserManagement;

/**
 *
 * @author pkm30
 */
public class User {

   
    private String name;
    private String id;
    private String passwd;
   

    public User(String id, String password, String name) {
       
        this.name = name;
        this.passwd = password;
        this.id = id;     
    }

  
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
