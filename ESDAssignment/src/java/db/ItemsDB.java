/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author lichingchester
 */

import bean.ItemBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ItemsDB {
    
    private String url = "";
    private String username = "";
    private String password = "";

    public ItemsDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println(url +"/"+username+"/"+password);
    }
    
    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }
    
     public void createItemsTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE  TABLE  Items  ("
                    + "itemID  VARCHAR(10)  CONSTRAINT  pk_itemID  PRIMARY  KEY,  "
                    + "itemName  VARCHAR(50),  desc  VARCHAR(100),  category  VARCHAR(50),"
                    + "designerName  VARCHAR(50), price double(8), path VARCHAR(100), size VARCHAR(10))";
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

    public ArrayList queryItems() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Items";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ItemBean ib = new ItemBean();
                ib.setItemID(rs.getString(1));
                ib.setItemName(rs.getString(2));
                ib.setDesc(rs.getString(3));
                ib.setCategory(rs.getString(4));
                ib.setDesignerName(rs.getString(5));
                ib.setPrice(rs.getDouble(6));
                ib.setPath(rs.getString(7));
                ib.setSize(rs.getString(8));
                list.add(ib);
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

    public ArrayList queryItemsByName(String name) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  Items WHERE itemName LIKE ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, "%" + name + "%");
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                ItemBean ib = new ItemBean();
                ib.setItemID(rs.getString(1));
                ib.setItemName(rs.getString(2));
                ib.setDesc(rs.getString(3));
                ib.setCategory(rs.getString(4));
                ib.setDesignerName(rs.getString(5));
                ib.setPrice(rs.getDouble(6));
                ib.setPath(rs.getString(7));
                ib.setSize(rs.getString(8));
                list.add(ib);
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
    
    public boolean addRecord(String itemID, String itemName, 
            String desc, String category, String designerName, 
            double price, String path, String size){
        
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO ItemsDB VALUES(?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, itemID);
            pStmnt.setString(2, itemName);
            pStmnt.setString(3, desc);
            pStmnt.setString(4, category);
            pStmnt.setString(5, designerName);
            pStmnt.setDouble(6, price);
            pStmnt.setString(7, path);
            pStmnt.setString(8, size);
            int rowCount = pStmnt.executeUpdate();
            if(rowCount >= 1){
                isSuccess = true;
            }
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
        return isSuccess;
    }
    
    public int delRecord(String itemID){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = "delete from itemDB where itemID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, itemID);
            
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
    
    
    public int editRecord(ItemBean cb){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = 
                    "update itemDB set itemName = ?, desc = ?, "
                    + "category = ?, designerName = ?"
                    + "price = ?, path = ?"
                    + "size = ? where itemID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, cb.getItemName());
            pStmnt.setString(2, cb.getDesc());
            pStmnt.setString(3, cb.getCategory());
            pStmnt.setString(4, cb.getDesignerName());
            pStmnt.setDouble(4, cb.getPrice());
            pStmnt.setString(4, cb.getPath());
            pStmnt.setString(4, cb.getSize());
            pStmnt.setString(4, cb.getItemID());
            
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
}
