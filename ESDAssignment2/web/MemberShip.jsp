<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>
<%@page import="bean.OrderBean"%>
<%@page import="bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
UserDB db;
    UserBean ub;
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Order Page</title>
        
        <% 
        UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
        
        %> 
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:Fuck</label>
                <a href="#join" class="navbar">Join us</a>
                <a href="order.jsp" class="navbar">Logout</a>
                <a href="order.jsp" class="navbar">Order</a>
                <a href="UpdateInfo.jsp" class="navbar">Setting</a>
            </div>
           <br>
           <div id="container">
               <form>
               <h1>Order History</h1><input type="button" value="Manage Order" >
               <hr size="2" width="100%">
               
               <table>
                    <tr>
                    <th>UserID</th>
                    <th>Items Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>DeliveryAddress</th>
                    </tr>
                    
                    <tr>
                    <td>Fucking Dress</td>
                    <td>Delivering</td>
                    <td>100$</td>
                    </tr>
               </table>
               </form>
               
               
                 
            </div>
        </section>
    </body>
</html>
