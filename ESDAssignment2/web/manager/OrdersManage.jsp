<%-- 
    Document   : OrdersManage
    Created on : 2016年11月20日, 下午01:30:32
    Author     : lichi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.OrderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        
        <%
            ArrayList<OrderBean> list = null;
            OrderBean ub = null;
            if(request.getAttribute("itemsList") != null){
                list = (ArrayList) request.getAttribute("itemsList");
            }
            if(request.getAttribute("userBean") != null){
                ub = (OrderBean) request.getAttribute("userBean");
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
        </div>
                
        <table>
                    <tr><td>orderID</td>  <td>  groupID </td>   <td> itemID</td>  <td> userTel</td>  <td>size</td>  <td>delivery Type</td> <td>delivery Date</td> 
                        <td>delivery Time</td> <td>delivery Address</td>  <td> status </td> <td> quantity </td> <td>Edit</td> <td>Delete</td> </tr>
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
                                out.print("<td class='td-button'>"
                                        + "<a href='managerHandle?action=editOrder&id="+ob.getOrderID()+"'>"
                                                + "<button class='admin-button'>Edit</button>"
                                        + "</a></td>");
                                out.print("<td class='td-button'>"
                                        + "<a href='managerHandle?action=deleteOrder&id="+ob.getOrderID()+"'>"
                                                + "<button class='admin-button'>Delete</button>"
                                        + "</a></td>");
                                out.print("</tr>");
                            }
                        }
                    %>
                </table>
    </body>
</html>
