<%-- 
    Document   : AdminShip
    Created on : 2016年11月20日, 上午03:14:55
    Author     : lichi
--%>


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
<!--               <a href="/managerHandle?action=users" class="adminitemmt">Users Mamagement</a>
               <a href="/managerHandle?action=orderps" class="adminitemmt">Orders Mamagement</a>
               <a href="/managerHandle?action=item" class="adminitemmt">Items Mamagement</a>
               <a href="/managerHandle?action=report" class="adminitemmt">Incomplete Order Report</a>
               -->
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
                    %>
                </table>
               
               
                 
            </div>
    </body>
</html>
