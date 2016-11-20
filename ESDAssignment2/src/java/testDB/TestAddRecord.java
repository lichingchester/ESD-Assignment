package testDB;
 
import db.UserDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TestAddRecord {

    public static void main(String[] arg) {

        String url = "jdbc:derby://localhost/User";
        String username = "abc";
        String password = "123";
        UserDB userDb = new UserDB(url, username, password);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String testDate="2016-1935";
        boolean isAdded = userDb.addRecord("123", "123","peterName", "12345689", "Peter@999.com","Flat 1",1000,0);
        if (isAdded) {
            System.out.println("peter2 is added");
        } else {
            System.out.println("added failed");
        }
    }
}
