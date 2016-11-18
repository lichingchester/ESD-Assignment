/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import db.ItemsDB;

/**
 *
 * @author lichi
 */
public class testItemDB {
    
    public static void main(String[] args){
        String url = "jdbc:derby://localhost/ItemsDB";
        String username = "abc";
        String password = "123";
        ItemsDB db = new ItemsDB(url, username, password);  
        db.dropItemsTable();
        if(db.createItemsTable()){
            System.out.println("success");
        }
        
        db.addRecord("item001", "Brown dress", "Long dress for party", 
                "long", "Chester Li", 599, "ESDAssignment/img/long/lng001.jpg", "M");
    }
    
}
