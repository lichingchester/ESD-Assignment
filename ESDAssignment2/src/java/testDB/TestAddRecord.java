package testDB;
 
import bean.OrderBean;
import bean.UserBean;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import db.OrdersDB;
import db.UserDB;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class TestAddRecord {

    public static void main(String[] arg) throws ParseException {
        OrderBean ob = new OrderBean();
        OrdersDB odb;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        odb = new OrdersDB (url, username, password);
        

        
        odb.createOrderTable();
        odb.addRecord("002", "1", "1", "87654321", "M", "2", "2016-11-22", 5, "Flat2402", "deliverying", 1);
            
    }
}
