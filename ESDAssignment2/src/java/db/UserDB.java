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

import bean.ItemBean;
import bean.UserBean;
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
                    + " LoginID VARCHAR(25), "
                    + "Password  VARCHAR(25), "
                    + "Name  VARCHAR(50),"
                    + " Tel  VARCHAR(15)CONSTRAINT  PK_CUSTOMER  PRIMARY  KEY,  "
                    + "Email  VARCHAR(100),"
                    + "Address  VARCHAR(200),"
                    + "BonusPoint int,"
                    + "Status int)";
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
     
     public boolean addRecord(String LoginID, String Pw,String Name, String Tel , String Email, String Address,int BonusPoint, int Status) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT  INTO  CUSTOMER  VALUES  (?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, LoginID);
            pStmnt.setString(2, Pw);
            pStmnt.setString(3, Name);
            pStmnt.setString(4, Tel);
            pStmnt.setString(5, Email);
            pStmnt.setString(6, Address);
            pStmnt.setInt(7, BonusPoint);
            pStmnt.setInt(8, Status);
            
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
     
     public int editRecord(UserBean ub){                //ManHo edited, I don't know correct or wrong 
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        
        int rs = 0;
        try{
            cnnct = getConnection();
            String preQueryStatement = 
                    "update CUSTOMER set Name = ?, Password = ?, "
                    + "Address = ?"
                    + "where Tel = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            
            pStmnt.setString(1, ub.getName());
            pStmnt.setString(2, ub.getPassword());
            pStmnt.setString(3, ub.getAddress());
            pStmnt.setString(4, ub.getTel());       
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
     
     
     public ArrayList queryItems() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CUSTOMER";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                UserBean ib = new UserBean();
                
                ib.setUsername(rs.getString(1));
                ib.setPassword(rs.getString(2));
                ib.setName(rs.getString(3));
                ib.setTel(rs.getString(4));
                ib.setEmail(rs.getString(5));
                ib.setAddress(rs.getString(6));
                ib.setBonusPoint(String.valueOf(rs.getInt(7)));
                ib.setStatus(String.valueOf(rs.getInt(8)));
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
     
     
     public UserBean queryItemByTel(String tel) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        UserBean ib = null;
        try {
            //1.  get Connection
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM CUSTOMER WHERE tel=?";
            //2.  get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //3. update the placehoder with id
            pStmnt.setString(1, tel);
            ResultSet rs = null;
            //4. execute the query and assign to the result 
            rs = pStmnt.executeQuery();
            if (rs.next()) {
                ib = new UserBean();
                // set the record detail to the customer bean
                ib.setUsername(rs.getString(1));
                ib.setPassword(rs.getString(2));
                ib.setName(rs.getString(3));
                ib.setTel(rs.getString(4));
                ib.setEmail(rs.getString(5));
                ib.setAddress(rs.getString(6));
                ib.setBonusPoint(rs.getString(7));
                ib.setStatus(rs.getString(8));
            }

            pStmnt.close();
            cnnct.close();
            
            return ib;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ib;
    }
     
     public ArrayList queryUsersByConfirmed() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CUSTOMER WHERE STATUS = 1 order by loginID";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                UserBean ib = new UserBean();
                ib.setUsername(rs.getString(1));
                ib.setPassword(rs.getString(2));
                ib.setName(rs.getString(3));
                ib.setTel(rs.getString(4));
                ib.setEmail(rs.getString(5));
                ib.setAddress(rs.getString(6));
                ib.setBonusPoint(String.valueOf(rs.getInt(7)));
                ib.setStatus(String.valueOf(rs.getInt(8)));
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
     
     public ArrayList queryUsersByUnconfirmed() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CUSTOMER WHERE STATUS = 0";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            ResultSet rs = pStmnt.executeQuery();

            ArrayList list = new ArrayList();

            while (rs.next()) {
                UserBean ib = new UserBean();
                ib.setUsername(rs.getString(1));
                ib.setPassword(rs.getString(2));
                ib.setName(rs.getString(3));
                ib.setTel(rs.getString(4));
                ib.setEmail(rs.getString(5));
                ib.setAddress(rs.getString(6));
                ib.setBonusPoint(String.valueOf(rs.getInt(7)));
                ib.setStatus(String.valueOf(rs.getInt(8)));
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
     
    public ArrayList queryUsersByTel(String Tel) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM  CUSTOMER WHERE Tel = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //Statement s = cnnct.createStatement();
            pStmnt.setString(1, Tel);
            ResultSet rs = pStmnt.executeQuery();
            ArrayList list = new ArrayList();
            if(rs.next()) {
                UserBean ib = new UserBean();
            
                ib.setUsername(rs.getString(1));
                ib.setPassword(rs.getString(2));
                ib.setName(rs.getString(3));
                ib.setTel(rs.getString(4));
                ib.setEmail(rs.getString(5));
                ib.setAddress(rs.getString(6));
                ib.setBonusPoint(String.valueOf(rs.getInt(7)));
                ib.setStatus(String.valueOf(rs.getInt(8)));
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
 
}
