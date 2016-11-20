<%-- 
    Document   : AdminShip
    Created on : 2016年11月20日, 上午03:14:55
    Author     : lichi
--%>

<%@page import="bean.ItemBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/admin.css">
        
        <%
            ArrayList<ItemBean> list = (ArrayList<ItemBean>) request.getAttribute("list");
        %>
    </head>
    <body>
        <section class="header">
        <div id="bg">
            <img src="/ESDAssignment/img/LOGO.png">
            <a href="order.jsp" class="navbar">Order</a>
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
                        <a href="/managerHandle?action=item">Items Management</a>
                    </li>
                    <li>
                        <a href="/managerHandle?action=report">Incompleted Report</a>
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
                            <a href="/managerHandle?action=orderps">Processing Orders</a>
                            <a href="/managerHandle?action=orderhis">Orders History</a>
                        </div>
                    </li>
                </ul>
               
                <br>
                
                <table>
                    <th>
                        <td>
                            Name
                        </td>
                        <td>
                            Description
                        </td>
                        <td>
                            Category
                        </td>
                        <td>
                            Designer Name
                        </td>
                        <td>
                            Size
                        </td>
                        <td>
                            Price
                        </td>
                    </th>
                    <%
                        for(ItemBean ib : list){
                            out.print("<tr><td>");
                            out.print("");
                        }
                    %>
                </table>
                
<!--                <table>
                    <tr>
                    <th>Items Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    </tr>
                    
                    <tr>
                    <td>Fucking Dress</td>
                    <td>Delivering</td>
                    <td>100$</td>
                    </tr>
               </table>-->
               
               
                 
            </div>
    </body>
</html>
