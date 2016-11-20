<%-- 
    Document   : testShoppingCart
    Created on : 2016年11月16日, 下午11:46:16
    Author     : Wang
--%>

<%@page import="bean.CartListBean"%>
<%@page import="bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            ArrayList<CartListBean> list =
           (ArrayList<CartListBean> )request.getAttribute("CartList");
            out.println("<h1>Customers</h1>");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>CustId</th> <th> name</th><th> tel</th><th> age</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record
            for (int i = 0; i < list.size(); i++) {
            CartListBean c = list.get(i);
            out.println("<tr>");
            out.println("<td>" + c.getListId() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getPrice() + "</td>");
            out.println("</tr>");
            }
            out.println("</table>");
           %>
    </body>
</html>
