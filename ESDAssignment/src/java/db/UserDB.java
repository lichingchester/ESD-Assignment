/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author ken42
 */

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    
    private String url = "";
    private String username = "";
    private String password = "";

    public UserDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println(url +"/"+username+"/"+password);
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
            String sql = "CREATE  TABLE  CUSTOMER  ("
                    + "CustId  VARCHAR(10)  CONSTRAINT  PK_CUSTOMER  PRIMARY  KEY,  "
                    + "Password  VARCHAR(25),  Tel  VARCHAR(15),  Email  VARCHAR(20),"
                    + "Address  VARCHAR(20) )";
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
     
     public boolean addRecord(String Id, String Pw, String Tel , String Email, String Address) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT  INTO  User  VALUES  (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, Id);
            pStmnt.setString(2, Pw);
            pStmnt.setString(3, Tel);
            pStmnt.setString(4, Email);
            pStmnt.setString(5, Address);
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
     
//     public CustomerBean queryUserByID(String id) {
//        Connection cnnct = null;
//        PreparedStatement pStmnt = null;
//
//        CustomerBean cb = null;
//        try {
//            //1.  get Connection
//            cnnct = getConnection();
//            String preQueryStatement = "SELECT * FROM  User WHERE Id=?";
//            //2.  get the prepare Statement
//            pStmnt = cnnct.prepareStatement(preQueryStatement);
//            //3. update the placehoder with id
//            pStmnt.setString(1, id);
//            ResultSet rs = null;
//            //4. execute the query and assign to the result 
//            rs = pStmnt.executeQuery();
//            if (rs.next()) {
//                cb = new CustomerBean();
//                // set the record detail to the customer bean
//                cb = new CustomerBean();
//                cb.setCustid(rs.getString(1));
//                cb.setName(rs.getString(2));
//                cb.setTel(rs.getString(3));
//                cb.setAge(rs.getInt(4));
//            }
//                pStmnt.close();
//                    cnnct.close();
//                } catch (SQLException ex) {
//                    while (ex != null) {
//                        ex.printStackTrace();
//                        ex = ex.getNextException();
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                return cb;
//            }
     
}
