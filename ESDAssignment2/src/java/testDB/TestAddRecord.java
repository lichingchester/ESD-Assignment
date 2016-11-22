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
        OrdersDB db;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        db = new OrdersDB (url, username, password);
        

        
        String dDate="22/12/2016";
        DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
        Date d = ((Date)dateformat.parse(dDate));
        
        String size="XL";
        
        int qty=4;
        
        String OrderID="001";
        String time="08:00";
        
        DateFormat df = new SimpleDateFormat("HH:mm");
        
//        Time t=java.sql.Time.valueOf("08:00");
//        java.sql.Time timeValue = new java.sql.Time(formatter.parse(df.parse(time).toString()).getTime());
        java.sql.Time myTime = java.sql.Time.valueOf(time);
        ob.setDeliveryTime(myTime);
        ob.setDeliveryDate((java.sql.Date) d);
        ob.setSize(size);
        ob.setQuantity(qty);
        ob.setOrderID(OrderID);
                
        db.editRecord(ob);
            
    }
}
