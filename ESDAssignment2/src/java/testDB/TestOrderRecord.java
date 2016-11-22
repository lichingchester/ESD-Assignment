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
        ob.setStatus("di");
        ob.setOrderID("001");
    }
}
