package testDB;
 
import bean.UserBean;
import db.UserDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TestAddRecord {

    public static void main(String[] arg) {
        UserBean ub = new UserBean();
        UserDB db;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        db = new UserDB (url, username, password);
        
        ub.setAddress("Fuck 2402,ChunTai");
        ub.setName("name");
        ub.setPassword("pwd");
        ub.setTel("tel");
        db.editRecord(ub);
        
            
    }
}
