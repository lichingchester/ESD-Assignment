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
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class TestAddRecord {

    public static void main(String[] arg) throws ParseException {
        OrderBean ob = new OrderBean();
        OrdersDB odb;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        odb = new OrdersDB (url, username, password);
        

            String dDate="2016-11-26";
            DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
            Date d = (dateformat.parse(dDate));
            Date d1=d;
            
            String size="XL";
            int qty=4;
            String OrderID="001";
            
            int f=12;
         ob.setDeliveryTime(f);
         ob.setDeliveryDate((java.sql.Date) d1);
         ob.setSize(size);
         ob.setQuantity(qty);
         ob.setOrderID(OrderID);   
         odb.editRecord(ob);
             
    }
}
