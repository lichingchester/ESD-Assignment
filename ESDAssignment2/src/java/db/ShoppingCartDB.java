/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
     
     public void createCustTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE  TABLE  CartList  ("
                    + "ListId  VARCHAR(10)  CONSTRAINT  PK_CUSTOMER  PRIMARY  KEY,  "
                    + "Name  VARCHAR(25),  Tel  VARCHAR(15),  Email  VARCHAR(20),"
                    + "Price VARCHAR(10),"
                    + "Quantity VARCHAR(20),"
                    + "Description VARCHAR(50))";
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
     
      public boolean addRecord(String Id, String name, String price , String quantity, String description) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT  INTO  CartList  VALUES  (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, Id);
            pStmnt.setString(2, name);
            pStmnt.setString(3, price);
            pStmnt.setString(4, quantity);
            pStmnt.setString(5, description);
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
     
}
