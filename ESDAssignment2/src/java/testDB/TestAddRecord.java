package testDB;
 
import bean.OrderBean;
import bean.UserBean;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import db.OrdersDB;
import db.ShoppingCartDB;
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
        ShoppingCartDB cdb = new ShoppingCartDB("jdbc:derby://localhost/database", "app", "app");       
        
        if(cdb.checkByIdSize("item002", "M")){
            System.out.println("asdf");
            cdb.UpdateQuantity("item002", "2");
        }
    }
}
