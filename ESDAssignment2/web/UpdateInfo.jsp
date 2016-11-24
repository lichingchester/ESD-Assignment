<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>
<%@page import="db.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Order Page</title>
        <%
        String action=request.getParameter("action");
        String Uname=request.getParameter("Uname");
        String Address=request.getParameter("address");
        String Tel = request.getParameter("Tel");
        %> 
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:<%out.print(Uname); %></label>
                <a href="#join" class="navbar">Join us</a>
                <a href="startup" class="navbar">Logout</a>
                <a href="order.jsp" class="navbar">Setting</a>
                <a href="ItemsServlet?action=list&Tel=<%=Tel%>" class="navbar">BuyThings</a>
            </div>
           <br>
           <div id="container">
               <form action="UpdateInfoServlet">
               <h1>Modify Personal Information</h1>
               <hr size="2" width="100%">
               
               Name:<input type="text" name="name" value="<%out.print(Uname); %>" required="required">
               <br/>
               <br/>
               Password:<input type="text" name="pwd" required="required">
               <br/>
               <br/>
               Delivery address:<input type="text" name="address" required="required" value='<%out.print(Address); %>'>
               <br/>
               <br/>
               <input type="submit" value="Submit">
               <input name="tel" type="hidden" value='<%out.print(action);%>'>
               </form>
               
           </div>
               
        </section>
    </body>
</html>
