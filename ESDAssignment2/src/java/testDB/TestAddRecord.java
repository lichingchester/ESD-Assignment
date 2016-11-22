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
import java.util.ArrayList;
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
        
        String date = "2016-11-26";
        
//        odb.dropItemsTable();
        odb.createOrderTable();

        odb.addRecord("1", "1", "1", "87654321", "M", "2", "2016-11-22", 5, "Flat2402", "deliverying", 2);
        
        ob.setOrderID("1");
        ob.setGroupID("1");
        ob.setItemID("1");
        ob.setUserTel("qesdasdasdasd");
        ob.setSize("M");
        ob.setDeliveryType("2");
        ob.setDeliveryDate(date);
        ob.setDeliveryTime(5);
        ob.setDeliveryAddress("asdf");
        ob.setStatus("asdf");
        ob.setQuantity(1);
        
        odb.editRecord(ob);
        
        ArrayList<OrderBean> list = odb.queryOrders();
        if(list != null){
            System.out.println(list.get(0).getUserTel());
        }
    }
}
