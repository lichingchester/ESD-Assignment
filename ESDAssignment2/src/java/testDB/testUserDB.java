/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import db.UserDB;


/**
 *
 * @author ken42
 */
public class testUserDB {
    
     public static void main(String[]arg){
        String url = "jdbc:derby://localhost/User";
        String username = "abc";
        String password = "123";
                
        UserDB db = new UserDB(url, username, password); 
        db.createCustTable();
        
        //db.addRecord("admin", "admin", null, null, null);
       
    }
}