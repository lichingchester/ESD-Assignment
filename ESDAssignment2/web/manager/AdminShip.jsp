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
            ArrayList<ItemBean> list = null;
            if((ArrayList) request.getAttribute("itemsList") != null){
                list = (ArrayList) request.getAttribute("itemsList");
            }
        %>
        
        <%
            if(request.getParameter("message") != null){
                if(request.getParameter("message").equals("editItem")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Edit item seccuss');");
                    /*out.println("location='index.jsp';");*/
                    out.println("</script>");
                }
                if(request.getParameter("message").equals("deleteItem")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Delete item seccuss');");
                    /*out.println("location='index.jsp';");*/
                    out.println("</script>");
                }
            }
        %>
        
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
                
                <table>
                    <tr>
                        <td>
                            Image
                        </td>
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
                            Price
                        </td>
                        <td>
                            Edit
                        </td>
                        <td>
                            Delete
                        </td>
                    </tr>
                    <%
                        
                        if(list != null){
                            for(ItemBean ib : list){
                                out.print("<tr>");
                                out.print("<td><img height='100' width='80' src='" + ib.getPath() + "' /></td>");
                                out.print("<td>" + ib.getItemName() + "</td>");
                                out.print("<td>" + ib.getDesc()+ "</td>");
                                out.print("<td>" + ib.getCategory()+ "</td>");
                                out.print("<td>" + ib.getDesignerName()+ "</td>");
                                out.print("<td>" + ib.getPrice()+ "</td>");
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
                        }
                        else if(list2!=null){
                            for(OrderBean ub : list2){
                                out.print("<tr>");
                                out.print("<td><img height='100' width='80' src='" + ub.getOrderID() + "' /></td>");
                                out.print("<td>" + ub.getItemID()+ "</td>");
                                out.print("<td>" + ub.getQuantity()+ "</td>");
                                out.print("<td>" + ub.getSize()+ "</td>");
                                out.print("<td>" + ub.getDeliveryAddress()+ "</td>");
                                out.print("<td>" + ub.getDeliveryDate()+ "</td>");
                                out.print("<td>" + ub.getStatus()+ "</td>");
                                out.print("<td>" + ub.getUserTel()+ "</td>");
                                out.print("</tr>");
                            }
                        
                        
                        
                        
                        }
                        
                    %>
                </table>
               
               
                 
            </div>
    </body>
</html>
