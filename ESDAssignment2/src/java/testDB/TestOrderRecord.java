/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import bean.OrderBean;
import db.OrdersDB;
import java.text.ParseException;

/**
 *
 * @author ken42
 */
public class TestOrderRecord {
    
    public static void main(String[] arg) throws ParseException {
        OrderBean ob = new OrderBean();
        OrdersDB odb;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        odb = new OrdersDB (url, username, password);
        String temp,t2;
        temp=odb.queryLastOrderID();
        t2=odb.queryLastGroupID();
        if (temp==null){
            System.out.print("Auto set 0");
        }else
             System.out.println("queryLastOrderID=  "+temp);
        System.out.print("queryLastGroupID=  "+t2);
        
        
       // odb.createOrderTable();
      ///  odb.addRecord("1", "1", "item001", "87654321", "M", "2", "2016-11-22", 5, "Flat2402", "deliverying", 2);
        //odb.addRecord("2", "2", "item002", "12345678", "M", "2", "2016-11-22", 5, "Flat2402", "canceled", 2);
        
    }
}
