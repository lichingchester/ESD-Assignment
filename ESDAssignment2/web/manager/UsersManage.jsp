<%-- 
    Document   : ItemsManage
    Created on : 2016年11月20日, 上午03:51:23
    Author     : lichi
--%>

<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
        
        <%
            ArrayList<UserBean> list = null;
            String type = "";
            if((ArrayList) request.getAttribute("list") != null){
                list = (ArrayList) request.getAttribute("list");
            }
            if(request.getParameter("type") != null){
                type = request.getParameter("type");
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
                            Username
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Telephone
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Address
                        </td>
                        <td>
                            BonusPoint
                        </td>
                        <td>
                            Status
                        </td>
                    </tr>
                    <%
                        
                        if(list != null){
                            if(type.equals("confirmed")){
                                for(UserBean ub : list){
                                    out.print("<tr>");
                                    out.print("<td>" + ub.getUsername()+ "</td>");
                                    out.print("<td>" + ub.getPassword()+ "</td>");
                                    out.print("<td>" + ub.getName()+ "</td>");
                                    out.print("<td>" + ub.getTel()+ "</td>");
                                    out.print("<td>" + ub.getEmail()+ "</td>");
                                    out.print("<td>" + ub.getAddress()+ "</td>");
                                    out.print("<td>" + ub.getBonusPoint() + "</td>");
                                    out.print("<td>" + ub.getStatus() + "</td>");
                                    out.print("</tr>");
                                }
                            }else{
                                for(UserBean ub : list){
                                    out.print("<tr>");
                                    out.print("<td>" + ub.getUsername()+ "</td>");
                                    out.print("<td>" + ub.getPassword()+ "</td>");
                                    out.print("<td>" + ub.getName()+ "</td>");
                                    out.print("<td>" + ub.getTel()+ "</td>");
                                    out.print("<td>" + ub.getEmail()+ "</td>");
                                    out.print("<td>" + ub.getAddress()+ "</td>");
                                    out.print("<td>" + ub.getBonusPoint() + "</td>");
                                    out.print("<td>" + ub.getStatus() + "</td>");
                                    out.print("</tr>");
                                }
                            }
                        }
                    
                    %>
    </body>
</html>
