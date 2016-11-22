<%-- 
    Document   : editOrder
    Created on : 2016年11月23日, 上午12:32:34
    Author     : ken42
--%>

<%@page import="bean.OrderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%
            OrderBean ob=(OrderBean)request.getAttribute("OrderBean");
        %>
    </head>
    <body>
        
        <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="#logout" class="navbar">Log out</a>
            </div>         
        </section>
        
        <br/>
        
        <div id="container">
            
                <h1 style="font-size: 50px">Top Confidential Management Room</h1>
            <br>
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
                     
                     
                     
                 <div id="container">
                    <form action="OrderEdit" class="formadd">
                        <p><label for="OrderID">Order ID:</label><br>
                            <input class="input-add" type="text" name="OrderID" value="<%= ob.getOrderID() %>" readonly></p><br>
                        
                        <p><label for="GroupID">Group IDe</lable><br>
                            <input class="input-add" type="text" name="GroupID" value="<%= ob.getGroupID() %>"></p><br>
                        
                        <p><label for="ItemID">Item ID</label><br>
                            <input class="input-add" type="text" name="ItemID" value="<%= ob.getItemID() %>"></p><br>
                        
                        <p> <label for="Size">size</label><br>
                          <input class="input-add" type="text" name="Size" value="<%= ob.getSize() %>"></p> <br>
                        
                        <p><label for="DeliveryType">delivery Type</label><br>
                            <input class="input-add" type="text" name="DeliveryType" value="<%= ob.getDeliveryType() %>"> </p><br>
                        
                        <p><label for="DeliveryDate">Delivery Date</label><br>
                            <input class="input-add" type="text" name="DeliveryDate" value="<%= ob.getDeliveryDate() %>"></p><br>
                        
                        <p><label for="DeliveryTime">Delivery Time</label><br>
                            <input class="input-add" type="text" name="DeliveryTime" value="<%= ob.getDeliveryTime() %>"></p><br>
                        
                        <p><label for="DeliveryAddress">Delivery Address</label><br>
                            <input class="input-add" type="text" name="DeliveryAddress" value="<%= ob.getDeliveryAddress() %>"></p><br>
                        
                         <p><label for="Status">Status</label><br>
                            <input class="input-add" type="text" name="Status" value="<%= ob.getStatus() %>"> </p><br>
                         
                        <p>
                            <input class="additem-submit edititem" type="submit" value="Edit">
                            <input class="additem-submit edititem" type="reset" value="Cancel">
                        </p>
                    </form>
                </div>
                     
                     
         </div>                
    </body>
</html>
