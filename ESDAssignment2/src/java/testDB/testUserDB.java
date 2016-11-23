/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import bean.UserBean;
import db.UserDB;


/**
 *
 * @author ken42
 */
public class testUserDB {
    
     public static void main(String[]arg){
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
                
        UserDB db = new UserDB(url, username, password); 
        
        //db.createCustTable();
        
//        db.addRecord("admin", "admin", "Chester", "68916799", "chester@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 2);
//        db.addRecord("", "", "Amon", "12345678", "amon@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 0);
//        db.addRecord("1", "robot", "Robot", "87654321", "robot@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 1);
//        db.addRecord("2", "robot2", "Robot2", "22222222", "robot@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 1);
//        db.addRecord("3", "", "Robot3", "33333333", "robot@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 0);
        
        //UserBean ub = db.queryUserByTel("33333333");
            
//        int lastUsername = Integer.parseInt(db.queryLastUsername());
//        lastUsername++;
//        
//        System.out.println(lastUsername);

//        ub.setUsername(String.valueOf(lastUsername));
//        ub.setPassword(String.valueOf(lastUsername));
//        ub.setTel("33333333");
//        
//        db.updateAC(ub);
        
        //db.addRecord("admin", "admin", null, null, null);
       
    }
}
