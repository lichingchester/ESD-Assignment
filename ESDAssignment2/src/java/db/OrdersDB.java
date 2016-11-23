/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.ItemBean;
import bean.OrderBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author lichi
 */
public class OrdersDB {
    
    private String url = "";
    private String username = "";
    private String password = "";
    
    public OrdersDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println(url +"/"+username+"/"+password);
    }
    
    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }
    
    
    public boolean dropItemsTable(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        boolean chk = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DROP TABLE Orders";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            try{
                chk = pStmnt.execute();
            }catch(SQLException exx){
                chk = false;
            }
            pStmnt.close();
            cnnct.close();
            
            chk = true;
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return chk;
    }
    
    
     public boolean createOrderTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        boolean chk = false;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE TABLE Orders"
                    + "(orderID  VARCHAR(10) not null,  "
                    + "groupID VARCHAR(5),  "
                    + "itemID VARCHAR(10),  "
                    + "userTel VARCHAR(15),  "
                    + "size VARCHAR(10),"
                    + "deliveryType VARCHAR(20),"
                    + "deliveryDate DATE,"
                    + "deliveryTime int,"
                    + "deliveryAddress VARCHAR(100),"
                    + "status VARCHAR(20),"
                    + "quantity int,"
                    + "primary key (orderID))";
            try{
                stmnt.execute(sql);
            }catch(SQLException exx){
                chk = false;
            }
            
            stmnt.close();
            cnnct.close();
            
            chk = true;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            return chk;
        }
    }
     
     public boolean addRecord(String orderID, String groupID, String itemID,String userTel, 
             String size , String deliveryType, String deliveryDate,int deliveryTime, 
             String deliveryAddress, String status, int quantity) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT  INTO  Orders  VALUES  (?,?,?,?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, orderID);
            pStmnt.setString(2, groupID);
            pStmnt.setString(3, itemID);
            pStmnt.setString(4, userTel);
            pStmnt.setString(5, size);
            pStmnt.setString(6, deliveryType);
            pStmnt.setString(7, deliveryDate);
            pStmnt.setInt(8, deliveryTime);
            pStmnt.setString(9, deliveryAddress);
            pStmnt.setString(10, status);
            pStmnt.setInt(11, quantity);
            
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
     
    public OrderBean queryByID(String ID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        OrderBean ob = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Orders WHERE orderID=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, ID);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                ob = new OrderBean();
                // set the record detail to the customer bean
                ob.setOrderID(rs.getString(1));
                ob.setGroupID(rs.getString(2));
                ob.setItemID(rs.getString(3));
                ob.setUserTel(rs.getString(4));
                ob.setSize(rs.getString(5));
                ob.setDeliveryType(rs.getString(6));
                ob.setDeliveryDate(rs.getString(7));
                ob.setDeliveryTime(rs.getInt(8));
                ob.setDeliveryAddress(rs.getString(9));
                ob.setStatus(rs.getString(10));
                ob.setQuantity(rs.getInt(11));
                return ob;
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
     public ArrayList queryByStaus(String status) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
       ArrayList list = new ArrayList();
        OrderBean ob = null;
        try {
            
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Orders WHERE status=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, status);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            
            while (rs.next()) {
                ob = new OrderBean();
                // set the record detail to the customer bean
                ob.setOrderID(rs.getString(1));
                ob.setGroupID(rs.getString(2));
                ob.setItemID(rs.getString(3));
                ob.setUserTel(rs.getString(4));
                ob.setSize(rs.getString(5));
                ob.setDeliveryType(rs.getString(6));
                ob.setDeliveryDate(rs.getString(7));
                ob.setDeliveryTime(rs.getInt(8));
                ob.setDeliveryAddress(rs.getString(9));
                ob.setStatus(rs.getString(10));
                ob.setQuantity(rs.getInt(11));
                list.add(ob);
            }
            pStmnt.close();
            cnnct.close();
            
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
      public ArrayList queryByProcessing() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        OrderBean ob = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Orders WHERE status!='canceled' AND status!='delivered'";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = pStmnt.executeQuery();
            
            ArrayList list = new ArrayList();
            //4. execute the query and assign to the result 
             
            while (rs.next()) {
                ob = new OrderBean();
                // set the record detail to the customer bean
                ob.setOrderID(rs.getString(1));
                ob.setGroupID(rs.getString(2));
                ob.setItemID(rs.getString(3));
                ob.setUserTel(rs.getString(4));
                ob.setSize(rs.getString(5));
                ob.setDeliveryType(rs.getString(6));
                ob.setDeliveryDate(rs.getString(7));
                ob.setDeliveryTime(rs.getInt(8));
                ob.setDeliveryAddress(rs.getString(9));
                ob.setStatus(rs.getString(10));
                ob.setQuantity(rs.getInt(11));
                list.add(ob);
            }
            
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                    } catch (SQLException sqlEx) {
                             }
            }
        }
        return null;
    }
      
      public ArrayList queryByHistory() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        OrderBean ob = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Orders WHERE status='pickedUp' OR status='delivered'";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = pStmnt.executeQuery();
            
            ArrayList list = new ArrayList();
            //4. execute the query and assign to the result 
             
            while (rs.next()) {
                ob = new OrderBean();
                // set the record detail to the customer bean
                ob.setOrderID(rs.getString(1));
                ob.setGroupID(rs.getString(2));
                ob.setItemID(rs.getString(3));
                ob.setUserTel(rs.getString(4));
                ob.setSize(rs.getString(5));
                ob.setDeliveryType(rs.getString(6));
                ob.setDeliveryDate(rs.getString(7));
                ob.setDeliveryTime(rs.getInt(8));
                ob.setDeliveryAddress(rs.getString(9));
                ob.setStatus(rs.getString(10));
                ob.setQuantity(rs.getInt(11));
                list.add(ob);
            }
            
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                    } catch (SQLException sqlEx) {
                             }
            }
        }
        return null;
    }
    
    public ArrayList queryOrders() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        ArrayList list = new ArrayList();
        OrderBean ob = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Orders";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            while (rs.next()) {
                ob = new OrderBean();
                ob.setOrderID(rs.getString(1));
                ob.setGroupID(rs.getString(2));
                ob.setItemID(rs.getString(3));
                ob.setUserTel(rs.getString(4));
                ob.setSize(rs.getString(5));
                ob.setDeliveryType(rs.getString(6));
                ob.setDeliveryDate(rs.getString(7));
                ob.setDeliveryTime(rs.getInt(8));
                ob.setDeliveryAddress(rs.getString(9));
                ob.setStatus(rs.getString(10));
                ob.setQuantity(rs.getInt(11));
                list.add(ob);
            }
            
            pStmnt.close();
            cnnct.close();
            
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    

    public String queryLastOrderID(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
         try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT TOP 1 (orderID) FROM Orders order by orderID limit 1;";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();
            pStmnt.close();
            cnnct.close();
            
            return rs.toString();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
        public String queryLastGroupID(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
         try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT groupID FROM Orders ;";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();
            pStmnt.close();
            cnnct.close();
            
            return rs.toString();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            return null;
    }
    
    public int editRecord(OrderBean ob){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = 
                    "update Orders set DeliveryDate = ?, DeliveryTime = ?, "
                    + "Size = ?, Quantity = ?"
                    + "where orderID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, ob.getDeliveryDate());
            pStmnt.setInt(2, ob.getDeliveryTime());
            pStmnt.setString(3, ob.getSize());
            pStmnt.setInt(4, ob.getQuantity());
            pStmnt.setString(5, ob.getOrderID());
            
            rs = pStmnt.executeUpdate();
            
            pStmnt.close();
            cnnct.close();
            
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public int delRecord(String OrderID){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = "delete from Orders where OrderID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, OrderID);
            
            rs = pStmnt.executeUpdate();
            
            pStmnt.close();
            cnnct.close();
            
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    public void editRecordStatus(OrderBean ob){
          Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        try{
            cnnct = getConnection();
            String preQueryStatement = 
                    "update Orders set status = ?"
                    + "where orderID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, ob.getStatus());
            pStmnt.setString(2, ob.getOrderID());
            
           pStmnt.executeUpdate();
            
            pStmnt.close();
            cnnct.close();
            
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
