/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import db.ShoppingCartDB;

/**
 *
 * @author Wang
 */
public class TestShoppingCartDB {
    
    public static void main(String[]arg){
        String url = "jdbc:derby://localhost/ShoppingCartDB";
        String username = "abc";
        String password = "123";
                
        ShoppingCartDB db = new ShoppingCartDB(url, username, password); 
        db.createCustTable();
       
    }
    
}
