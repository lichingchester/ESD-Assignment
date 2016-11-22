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
        UserBean ob = new UserBean();
        UserDB db;
        String url = "jdbc:derby://localhost/database";
        String username = "app";
        String password = "app";
        db = new UserDB (url, username, password);
        
        String ID="87654321";
        ArrayList list = db.queryUsersByTel(ID);
        
        ArrayList<UserBean> list2 = null;
        list2 = (ArrayList)list;
        for(UserBean ub : list2){   
            System.out.print("<td>" + ub.getBonusPoint()+ "</td>");
        }
             
    }
}
