<%-- 
    Document   : OrderHis
    Created on : 2016年11月23日, 上午04:56:54
    Author     : ken42
--%>

<%@page import="bean.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History Page</title>
 
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        
        <%
            ArrayList<OrderBean> list = null;
            if(request.getAttribute("list") != null){
                list = (ArrayList) request.getAttribute("list");
            }
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
             <br>
        </div>
        <table>
                    <tr><td>orderID</td>  <td>  groupID </td>   <td> itemID</td>  <td> userTel</td>  <td>size</td>  <td>delivery Type</td> <td>delivery Date</td> 
                        <td>delivery Time</td> <td>delivery Address</td>  <td> status </td> <td> quantity </td> 
                    </tr>
                    <%
                        if(list != null){
                            for(OrderBean ob : list){
                                out.print("<tr>");
                                out.print("<td>"+ ob.getOrderID() +"</td>");
                                out.print("<td>" + ob.getGroupID()+ "</td>");
                                out.print("<td>" + ob.getItemID()+ "</td>");
                                out.print("<td>" + ob.getUserTel()+ "</td>");
                                out.print("<td>" + ob.getSize() +"</td>");
                                out.print("<td>" + ob.getDeliveryType()+ "</td>");
                                out.print("<td>" + ob.getDeliveryDate()+"</td>");
                                out.print("<td>" + ob.getDeliveryTime()+"</td>");
                                out.print("<td>" + ob.getDeliveryAddress()+"</td>");
                                out.print("<td>" + ob.getStatus()+"</td>");
                                out.print("<td>" + ob.getQuantity()+"</td>");
                                out.print("</tr>");
                            }
                        }else{
                            out.print("<tr>");out.print("<td> Null</td>");
                        }
                    %>
                </table>
        
    </body>
</html>
