<%-- 
    Document   : deleteOrder
    Created on : 2016年11月23日, 上午12:32:45
    Author     : ken42
--%>

<%@page import="bean.OrderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Order Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        <%
            OrderBean ob=(OrderBean)request.getAttribute("ob");
        %>
        
    </head>
    <body>
        <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="#logout" class="navbar">Log out</a>
            </div>         
        </section>
        
        <div id="container">
            <h1 style="font-size: 50px">Top Confidential Management Room</h1>
            <br>
            <ul>
                 <li>
                     <a href="managerHandle?action=item">Items Management</a>
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
             
             
              <p class="deleteItem">Are you sure to delete the Order?</p>
            <form action="deleteOrderServlet">
                <input type="hidden" name="id" value="<%= ob.getOrderID() %>">
                <input type="submit" value="Delete">
                <a href="managerHandle?action=orderps"><input type="button" value="Cancel"></a>

            </form>
        </div>
    </body>
</html>
