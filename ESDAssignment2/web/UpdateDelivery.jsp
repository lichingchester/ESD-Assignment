<%-- 
    Document   : order
    Created on : 2016年11月22日, 下午07:04:49
    Author     : huen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Register Page</title>
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <a href="#join" class="navbar">Join us</a>
            </div>
           <br>
           <div id="container">
               <form action="UpdateDeliveryServlet">  
               <h1>Update Delivery Information</h1>
               <hr size="2" width="100%">
               
               <%String orderID=request.getParameter("order");
               
               %>
               
               OrderID:<input type="text" name="orderID" value="<%out.print(orderID);%>" readonly="readonly">
               <br/>
               <br/>
               Delivery Time:<input type="number" name="dTime">
               <br/>
               <br/>
               Delivery Date:<input type="date" name="dDate">
               <br/>
               <br/>
               Size:<input type="text" name="size">
               <br/>
               <br/>
               Quantity<input type="text" name="qty">
               <input type="submit" value="Submit">  <input type="reset" value="reset">
               </form>
               
           </div>
               
        </section>
    </body>
</html>

