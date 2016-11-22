<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Order Page</title>
        
        <%@page import="bean.OrderBean"%>
        <%@page import="bean.UserBean"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <% 
        UserBean ub = (UserBean) request.getAttribute("userBean");
        ArrayList<OrderBean> list = (ArrayList) request.getAttribute("orderList");
        %> 
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:fuck</label>
                <a href="#join" class="navbar">Join us</a>
                <a href="order.jsp" class="navbar">Logout</a>
                <a href="order.jsp" class="navbar">Order</a>
                <a href="UpdateInfo.jsp" class="navbar">Setting</a>
            </div>
           <br>
           <div id="container">
               <form>
               <h1>Order History</h1><input type="button" value="Manage Order" >
               <hr size="2" width="100%">
               
               <table>
                    <tr>
                    <th>UserID</th>
                    <th>Items ID</th>
                    <th>Size</th>
                    <th>Delivery Type</th>
                    <th>Delivery Address</th>
                    <th>Status</th>
                    </tr>
                    
                    <%
                        for(int i=0;i<list.size();i++){
                            OrderBean ob = (OrderBean)list.get(i);
                            if(ob.getUserTel().equals(ub.getTel())){
                            out.print("<tr>");
                            out.print("<td> "+ ob.getOrderID() +" </td>");
                            out.print("<td> "+ ob.getItemID() +" </td>");
                            out.print("<td> "+ ob.getSize()+" </td>");
                            out.print("<td> "+ ob.getDeliveryType()+" </td>");
                            out.print("<td> "+ ob.getDeliveryAddress()+" </td>");
                            out.print("<td> "+ ob.getStatus()+" </td>");
                            out.print("</tr>");
                            }
                        }
                    %>
               </table>
               </form>
               
               
                 
            </div>
        </section>
    </body>
</html>
