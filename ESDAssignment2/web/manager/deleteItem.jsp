<%-- 
    Document   : deleteItem
    Created on : 2016年11月17日, 下午04:59:45
    Author     : lichi
--%>

<%@page import="bean.ItemBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        
        <%
            ItemBean ib = (ItemBean) request.getAttribute("ib");
        %>
        
    </head>
    <body>
        <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="index.jsp" class="navbar">Log out</a>
            </div>         
        </section>
        
        <div id="container">
            <h1 style="font-size: 50px">Top Confidential Management Room</h1>
            <br>
<!--               <a href="/managerHandle?action=users" class="adminitemmt">Users Mamagement</a>
            <a href="/managerHandle?action=orderps" class="adminitemmt">Orders Mamagement</a>
            <a href="/managerHandle?action=item" class="adminitemmt">Items Mamagement</a>
            <a href="/managerHandle?action=report" class="adminitemmt">Incomplete Order Report</a>
            -->
             <ul>
                 <li class="dropdown">
                     <a href="managerHandle?action=item">Items Management</a>
                     <div class="dropdown-content">
                         <a href="managerHandle?action=addItem">Add Item</a>
                     </div>
                 </li>
                 <li>
                     <a href="managerHandle?action=report">Incompleted Report</a>
                 </li>
                 <li class="dropdown">
                     <a href="#" class="dropbtn">Users Management</a>
                     <div class="dropdown-content">
                         <a href="managerHandle?action=users">Confirmed Users</a>
                         <a href="managerHandle?action=ncusers">Unconfirmed Users</a>
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
            
            <p class="deleteItem">Are you sure to delete the dress?</p>
            <form action="deleteItemServlet">
                <input type="hidden" name="id" value="<%= ib.getItemID() %>">
                <input type="submit" value="Delete">
                <a href="managerHandle?action=item"><input type="button" value="Cancel"></a>

            </form>
        </div>
    </body>
</html>
