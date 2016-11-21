<%-- 
    Document   : testShoppingCart
    Created on : 2016年11月16日, 下午11:46:16
    Author     : Wang
--%>

<%@page import="bean.CartListBean"%>
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
            ArrayList list = (ArrayList) request.getAttribute("list");
            if(list == null) out.println("safdasf");
            
            out.println("<h1>Shopping Cart</h1>");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>CustId</th> <th>Product Name</th><th>Size</th><th>Quantity</th ><th>Each Of The Price</th >");
            out.println("</tr>");
                for(int i=0;i<list.size();i++){
                    CartListBean cb = (CartListBean)list.get(i);
                    out.println("<tr><td>"+/*cb.getCustId()+*/"</td><td>"+cb.getName()+"</td><td>"+cb.getSize()+"</td><td>"+/*cb.getQuantity()+"</td><td>"+*/"</td><td>"+cb.getPrice()+"</td><tr>");     
                }
           out.println("<tr><td colspan='4'>"+"Total Price:"+"</td><td>"+"Test"+"</td></tr>");
           out.println("</table>");
         %>
         
         <a href ="index.jsp"/>Back to HomePage.
         <%/*
            //ArrayList<CartListBean> list =
          // (ArrayList<CartListBean> )request.getAttribute("CartList");
            out.println("<h1>Customers</h1>");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>CustId</th> <th> name</th><th> tel</th><th> age</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record
            if(cb == null){
                System.out.println("No record");
            }else{
            for (int i = 0; i < list.size(); i++) {
          //  CartListBean c = list.get(i);
            out.println("<tr>");
            out.println("<td>" + cb.getListId() + "</td>");
            out.println("<td>" + cb.getName() + "</td>");
            out.println("<td>" + cb.getPrice() + "</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            }*/
           %>
           
           
           
    </body>
</html>
