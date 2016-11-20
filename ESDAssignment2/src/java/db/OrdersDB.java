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
    
    
     public boolean createItemsTable() {
        Connection cnnct = null;
        Statement stmnt = null;
        boolean chk = false;

        try {
            cnnct = getConnection();  // the connection 
            stmnt = cnnct.createStatement();  // create statement
            String sql = "CREATE TABLE Orders"
                    + "(orderID  VARCHAR(10) not null,  "
                    + "itemID VARCHAR(10),  "
                    + "itemName  VARCHAR(50),  "
                    + "description  VARCHAR(100),  "
                    + "category  VARCHAR(50),"
                    + "designerName  VARCHAR(50), "
                    + "price double, "
                    + "path VARCHAR(100), "
                    + "size VARCHAR(10),"
                    + "deliveryType VARCHAR(20),"
                    + "deliveryDT DATETIME,"
                    + "deliveryAddress VARCHAR(100),"
                    + ""
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
}
