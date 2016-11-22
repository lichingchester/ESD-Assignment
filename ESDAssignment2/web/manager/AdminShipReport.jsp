<%-- 
    Document   : AdminShip
    Created on : 2016年11月20日, 上午03:14:55
    Author     : lichi
--%>


<%@page import="bean.OrderBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        <%@page import="bean.UserBean"%>

        <%@page import="bean.ItemBean"%>
        <%@page import="java.util.ArrayList"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="bean.UserBean"%>

        
        <%
            ArrayList<OrderBean> list2 = null;
            if((ArrayList) request.getAttribute("OrderList") != null){
                list2 = (ArrayList) request.getAttribute("OrderList");
            }
        %>
    </head>
    <body>
        <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="#logout" class="navbar">Log out</a>
            </div>         
        </section>
        
        <br>
           <div id="container">
               <h1 style="font-size: 50px">Top Confidential Management Room</h1>
               <br>
<!--               <a href="/managerHandle?action=users" class="adminitemmt">Users Mamagement</a>
               <a href="/managerHandle?action=orderps" class="adminitemmt">Orders Mamagement</a>
               <a href="/managerHandle?action=item" class="adminitemmt">Items Mamagement</a>
               <a href="/managerHandle?action=report" class="adminitemmt">Incomplete Order Report</a>
               -->
                <ul>
                    <li>
                        <a href="managerHandle?action=item">Items Management</a>
                    </li>
                    <li>
                        <a href="managerHandle?action=report">Incompleted Report</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropbtn">Users Management</a>
                        <div class="dropdown-content">
                            <a href="/managerHandle?action=users">Confirmed Users</a>
                            <a href="/managerHandle?action=ncusers">Unconfirmed Users</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropbtn">Orders Management</a>
                        <div class="dropdown-content">
                            <a href="managerHandle?action=orderps">Processing Orders</a>
                            <a href="managerHandle?action=orderhis">Orders History</a>
                        </div>
                    </li>
                </ul>
               
                <br>
                
                <table>
                    <tr>
                        <td>
                            OrderID
                        </td>
                        <td>
                            ItemID
                        </td>
                        <td>
                            Quantity
                        </td>
                        <td>
                            Size
                        </td>
                        <td>
                            Delivery Address
                        </td>
                        <td>
                            User Tel
                        </td>
                        <td>
                            Status
                        </td>
                    </tr>
                    <%
                        if(list2!=null){
                            for(OrderBean ub : list2){
                                out.print("<tr>");
                                out.print("<td>" + ub.getOrderID()+ "</td>");
                                out.print("<td>" + ub.getItemID()+ "</td>");
                                out.print("<td>" + ub.getQuantity()+ "</td>");
                                out.print("<td>" + ub.getSize()+ "</td>");
                                out.print("<td>" + ub.getDeliveryAddress()+ "</td>");
                                out.print("<td>" + ub.getDeliveryDate()+ "</td>");
                                out.print("<td>" + ub.getUserTel()+ "</td>");
                                out.print("<td>" + ub.getStatus()+ "</td>");
                                out.print("</tr>");
                            }
                        }
 
                    %>
                </table>
               
               
                 
            </div>
    </body>
</html>
