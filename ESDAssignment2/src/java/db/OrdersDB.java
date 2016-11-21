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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    + "itemID VARCHAR(10),  "
                    + "userTel VARCHAR(15),  "
                    + "size VARCHAR(10),"
                    + "deliveryType VARCHAR(20),"
                    + "deliveryDate DATE,"
                    + "deliveryTime TIME"
                    + "deliveryAddress VARCHAR(100),"
                    + "status VARCHAR(20),"
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
                ob.setItemID(rs.getString(2));
                ob.setUserTel(rs.getString(3));
                ob.setSize(rs.getString(4));
                ob.setDeliveryType(rs.getString(5));
                ob.setDeliveryDate(rs.getDate(6));
                ob.setDeliveryTime(rs.getTime(7));
                ob.setDeliveryAddress(rs.getString(8));
                ob.setStatus(rs.getString(9));
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
                ob.setItemID(rs.getString(2));
                ob.setUserTel(rs.getString(3));
                ob.setSize(rs.getString(4));
                ob.setDeliveryType(rs.getString(5));
                ob.setDeliveryDate(rs.getDate(6));
                ob.setDeliveryTime(rs.getTime(7));
                ob.setDeliveryAddress(rs.getString(8));
                ob.setStatus(rs.getString(9));
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
}
