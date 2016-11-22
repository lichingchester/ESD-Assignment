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
        <%
            ArrayList<OrderBean> list = (ArrayList) request.getAttribute("itemsList");
            OrderBean ub = (OrderBean) request.getAttribute("userBean");
        %>
    </head>
    <body>
        <table>
                    <tr><td>orderID</td>  <td>  groupID </td>   <td> itemID</td>  <td> userTel</td>  <td>size</td>  <td>delivery Type</td> <td>delivery Date</td> 
                        <td>delivery Time</td> <td>delivery Address</td>  <td> status </td> <td> quantity </td> <td>Edit</td> <td>Delete</td> </tr>
                    <%
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
                                    + "<a href='managerHandle?action=editItem&id="+ib.getItemID()+"'>"
                                            + "<button class='admin-button'>Edit</button>"
                                    + "</a></td>");
                            out.print("<td class='td-button'>"
                                    + "<a href='managerHandle?action=deleteItem&id="+ib.getItemID()+"'>"
                                            + "<button class='admin-button'>Delete</button>"
                                    + "</a></td>");
                            out.print("</tr>");
                        }
                    %>
                </table>
    </body>
</html>
