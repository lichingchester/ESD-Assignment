<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Order Page</title>
        
        <jsp:useBean id="user" class="bean.User"/>
        <jsp:setProperty name="user" property="id" value="1" />
        <jsp:setProperty name="user" property="id" value="1" /> 
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:<jsp:getProperty name="user"property="id"/></label>
                <a href="#join" class="navbar">Join us</a>
                <a href="order.jsp" class="navbar">Logout</a>
                <a href="order.jsp" class="navbar">Order</a>
                <a href="order.jsp" class="navbar">Setting</a>
            </div>
           <br>
           <div id="container">
               <form action="UpdateInfoServlet">
               <h1>Modify Personal Information</h1>
               <hr size="2" width="100%">
               
               Name:<input type="text" name="name">
               <br/>
               <br/>
               Password:<input type="text" name="pwd">
               <br/>
               <br/>
               Delivery address:<input type="text" name="address">
               <br/>
               <br/>
               <input type="submit" value="Submit">
               </form>
               
           </div>
               
        </section>
    </body>
</html>