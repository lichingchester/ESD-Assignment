<%-- 
    Document   : registration
    Created on : 2016年11月19日, 下午06:15:20
    Author     : ken42
--%>


<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registration Page</title>
    </head>
    <body>
       <%@ page import ="java.sql.*" %>
       <%@ page import="java.io.*,java.util.Locale" %>
        <%@ page import="javax.servlet.*,javax.servlet.http.* "%>
        <%@ page import="java.text.DateFormat,java.util.Date" %>
    <%
        String user = request.getParameter("uname");    
        String pwd = request.getParameter("pass");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost/User",
                "abc", "123");
        Statement st = con.createStatement();
        //ResultSet rs;
        Locale locale = request.getLocale( );
        String date = DateFormat.getDateTimeInstance(DateFormat.FULL, 
                                                    DateFormat.SHORT, 
                                                locale).format(new Date( ));

        int i = st.executeUpdate("insert into CUSTOMER(UserName, Password, Tel, Email, Address, regdate) values ('" + user + "','" + pwd + "','" + tel + "','" + email + "','" + address + "', "+date+")");
        if (i > 0) {
            //session.setAttribute("userid", user);
            response.sendRedirect("welcome.jsp");
           // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
    </body>
</html>
