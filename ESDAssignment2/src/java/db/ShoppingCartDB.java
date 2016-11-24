/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bean.CartListBean;
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
 * @author Wang
 */
public class ShoppingCartDB {
    
    private String url = "";
    private String username = "";
    private String password = "";
    
     public ShoppingCartDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
     
     public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }
     
     public void createTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE  TABLE  CartList  ("
                    + "CustTel  VARCHAR(20) ,  "
                    + "ItemID  VARCHAR(10) ,  "
                    + "Name  VARCHAR(25),"
                    + "Price VARCHAR(10),"
                    + "Quantity VARCHAR(20),"
                    + "Size VARCHAR(10))";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
      public boolean addRecord(String Tel,String ID, String name, String price , String quantity, String size) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT  INTO  CartList  VALUES  (?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
             pStmnt.setString(1, Tel);
            pStmnt.setString(2, ID);
            pStmnt.setString(3, name);
            pStmnt.setString(4, price);
            pStmnt.setString(5, quantity);
            pStmnt.setString(6, size);
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
      
       public boolean dropTable(){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        boolean chk = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "DROP TABLE CartList";
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
       
       public ArrayList queryItems() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CartList";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                CartListBean cb = new CartListBean();
                cb.setItemID(rs.getString(2));
                cb.setName(rs.getString(3));
                cb.setPrice(rs.getString(4));
                cb.setQuantity(rs.getString(5));
                cb.setSize(rs.getString(6));
                list.add(cb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
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
     
       public boolean UpdateQuantity(String ID, String quantity){
           Connection cnnct = null;
           PreparedStatement pStmnt = null;
           boolean isSuccess = false;
           String preQueryStatement;
           int tempQuantity = 0;
           String newQuantity = "";
           
           try {
            cnnct = getConnection();
            //preQueryStatement = "select * from CartList where ItemID='" + ID + "' ";
            preQueryStatement = "select Quantity from CartList where ItemID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ID);
            ResultSet rs = pStmnt.executeQuery();
            if(rs.next()){
                tempQuantity = Integer.parseInt(rs.getString(1))+Integer.parseInt(quantity);
                newQuantity = Integer.toString(tempQuantity);
            }
            //preQueryStatement = "UPDATE INTO CartList(Quantity) VALUES(?)";
            preQueryStatement ="UPDATE CartList SET Quantity='"+ newQuantity + "' WHERE ItemID='" + ID + "'";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //pStmnt.setString(1, newQuantity);
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
       
        public int delRecord(String tel){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = "delete from CartList where CustTel = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, tel);
            
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
        
        public boolean checkByIdSize(String ID, String Size){
            Connection cnnct = null;
            PreparedStatement pStmnt = null;
            boolean exist = false;
            
            try {
                cnnct = getConnection();
                //String preQueryStatement = "SELECT * FROM  CartList WHERE (ItemID=?,Size = ?)";
                String preQueryStatement = "select * from CartList where ItemID='"+ ID + "' and Size='" + Size + "'";
                pStmnt = cnnct.prepareStatement(preQueryStatement);
                
               // pStmnt.setString(1, ID);
               // pStmnt.setString(2, Size);
                ResultSet rs = pStmnt.executeQuery();
                int rsCount = 0;
                
                while(rs.next()){
                    rsCount += 1;
                }
                
                if (rsCount >= 1) {
                    exist = true;
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
            
            return exist;
        }
        
        public String getResult(String ID){
           Connection cnnct = null;
           PreparedStatement pStmnt = null;
           String test="";
           String preQueryStatement;
           
           try {
            cnnct = getConnection();
            //preQueryStatement = "select * from CartList where ItemID='" + ID + "' ";
            preQueryStatement = "select Quantity from CartList where ItemID=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, ID);
            ResultSet rs = pStmnt.executeQuery();
            test = rs.getString(1);
           }catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
           return test;
        }

    public ArrayList queryItemsByTel(String Tel){
            Connection cnnct = null;
            PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CartList WHERE CustTel=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, Tel);
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                CartListBean cb = new CartListBean();
                cb.setItemID(rs.getString(2));
                cb.setName(rs.getString(3));
                cb.setPrice(rs.getString(4));
                cb.setQuantity(rs.getString(5));
                cb.setSize(rs.getString(6));
                list.add(cb);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
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
        
}
