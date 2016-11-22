<%-- 
    Document   : AdminShipMessage
    Created on : 2016年11月22日, 下午11:45:42
    Author     : lichi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
             
             <%
                 if(request.getParameter("message") != null){
                     if(request.getParameter("message").equals("editItem")){
                         out.print("<div class='container'><label>Edit item seccess!</label></div>");
                     }
                 }
             %>
             
        </div>
    </body>
</html>
