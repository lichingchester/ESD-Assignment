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
import java.util.ArrayList;
import java.util.Calendar;

public class TestAddRecord {

    public static void main(String[] arg) throws ParseException {
        OrderBean ob = new OrderBean();
        OrdersDB odb;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        odb = new OrdersDB (url, username, password);
        
        ob.setStatus("Cancel");
        ArrayList list = odb.queryByStaus(ob.getStatus());
        
        ArrayList<OrderBean> list2 = null;
        list2 = (ArrayList)list;
        for(OrderBean ub : list2){   
            System.out.print("<td>" + ub.getItemID()+ "</td>");
            System.out.print("<td>" + ub.getQuantity()+ "</td>");
            System.out.print("<td>" + ub.getSize()+ "</td>");

        }
             
    }
}
