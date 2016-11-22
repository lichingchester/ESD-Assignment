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
            request.getSession().setAttribute("list",list);
            if(list == null) out.println("safdasf");
            
            double totalPrice = 0;
            
            out.println("<h1>Shopping Cart</h1>");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>ItemID</th> <th>Product Name</th><th>Quantity</th><th>Size</th ><th>Each Of The Price</th ><th>Delete Record</th >");
            out.println("</tr>");
                for(int i=0;i<list.size();i++){
                    CartListBean cb = (CartListBean)list.get(i);
                    totalPrice += Double.parseDouble(cb.getQuantity()) * Double.parseDouble(cb.getPrice());
                    String ID = cb.getItemID();
                    String size = cb.getSize();
                    out.println("<form action='CartController'>");
                    out.println("<input type='hidden' name='action' value='delete'>"+"<input type='hidden' name='ID' value='"+ID+"'>"+"<input type='hidden' name='size' value='"+size+"'>");
                    out.println("<tr><td>"+cb.getItemID()+"</td><td>"+cb.getName()+"</td><td>"+cb.getQuantity()+"</td><td>"+cb.getSize()+"</td><td>"+cb.getPrice()+"</td><td><input type='submit' value='DELETE'></td></tr>");
                    out.println("</form>");
                }
           out.println("<tr><td colspan='5'>"+"Total Price:"+"</td><td>"+totalPrice+"</td></tr>");
           out.println("</table>");
           out.println("<br><br>");
           out.println("<form action='ConfirmOrderServlet'>");
           out.println("<input type='hidden' name='list'>");
           out.println("<input type='submit' value='Buy Now'>");
           out.println("</form>");
         %>
         
         <a href="ItemsServlet?action=list" class="a-white">Back to OrderPage.
    </body>
</html>
