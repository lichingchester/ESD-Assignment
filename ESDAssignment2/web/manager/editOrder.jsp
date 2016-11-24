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
        <title>editOrder</title>
       <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        <%
            OrderBean ob=(OrderBean)request.getAttribute("OrderBean");
        %>
    </head>
    <body>
        
  <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="index.jsp" class="navbar">Log out</a>
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
                </ul>
                     
                 <div id="container">
                    <form action="OrderEdit" class="formadd">
                        <p><label for="OrderID">Order ID:</label><br>
                            <input class="input-add" type="text" name="orderID" value="<%= ob.getOrderID() %>" readonly ></p><br>
                        
                        <p><label for="GroupID">Group ID</lable><br>
                            <input class="input-add" type="text" name="groupID" value="<%= ob.getGroupID() %>" disabled></p><br>
                        
                        <p><label for="ItemID">Item ID</label><br>
                            <input class="input-add" type="text" name="itemID" value="<%= ob.getItemID() %>" disabled></p><br>
                        
                        <p> <label for="Size">size</label><br>
                          <input class="input-add" type="text" name="size" value="<%= ob.getSize() %>" disabled></p> <br>
                        
                        <p><label for="DeliveryType">delivery Type</label><br>
                            <input class="input-add" type="text" name="deliveryType" value="<%= ob.getDeliveryType() %>" disabled> </p><br>
                        
                        <p><label for="DeliveryDate">Delivery Date</label><br>
                            <input class="input-add" type="text" name="deliveryDate" value="<%= ob.getDeliveryDate() %>" disabled></p><br>
                        
                        <p><label for="DeliveryTime">Delivery Time</label><br>
                            <input class="input-add" type="text" name="deliveryTime" value="<%= ob.getDeliveryTime() %>" disabled></p><br>
                        
                        <p><label for="DeliveryAddress">Delivery Address</label><br>
                            <input class="input-add" type="text" name="deliveryAddress" value="<%= ob.getDeliveryAddress() %>" disabled></p><br>
                        
                         <p><label for="Status">Status</label><br>
                            <input class="input-add" type="text" name="status" value="<%= ob.getStatus() %>"> </p><br>
                         
                        <p>
                            <input class="additem-submit edititem" type="submit" value="Edit">
                            <input class="additem-submit edititem" type="reset" value="Cancel">
                        </p>
                    </form>
                </div>
                  
         </div>                
    </body>
</html>
