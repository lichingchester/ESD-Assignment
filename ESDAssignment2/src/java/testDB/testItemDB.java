/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDB;

import bean.ItemBean;
import db.ItemsDB;
import db.OrdersDB;
import java.util.ArrayList;

/**
 *
 * @author lichi
 */
public class testItemDB {
    
    public static void main(String[] args){
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        ItemsDB idb = new ItemsDB(url, username, password);  
        OrdersDB odb = new OrdersDB(url, username, password);
        
        int lastOrderID = 0;
                if(idb.queryLastItemID()==null){
                    lastOrderID = 1;
                }else{
                    lastOrderID = Integer.parseInt(idb.queryLastItemID());
//                    lastOrderID++;
                }
            
            String loid = String.valueOf(lastOrderID);
        
//        idb.addRecord(loid, "Brown dress", "Long dress for party", "long", "Chester Li", 599, "ESDAssignment/img/long/lng001.jpg");
            System.out.println(loid);
            
            int id = 0;
            ArrayList<ItemBean> list = idb.queryItems();
            for(ItemBean ib : list){
                System.out.println(ib.getItemID());
                if(Integer.parseInt(ib.getItemID()) > id){
                    id = Integer.parseInt(ib.getItemID());
                }
            }
            System.out.println("asdfasdfasdfasd" + id);

//        ArrayList list = db.queryItems();
//        for(int i=0;i<list.size();i++){
//            ItemBean ib = (ItemBean)list.get(i);
//            System.out.print( i 
//                    + " :::: "+ib.getPath()+"'>>>>"
//                    +ib.getPrice());
//        }
    }
    
}
