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
               <form action="RegisterServlet">  
               <h1>Register Information</h1>
               <hr size="2" width="100%">
               
               Name:<input type="text" name="name">
               <br/>
               <br/>
               Tel:<input type="text" name="tel">
               <br/>
               <br/>
               Email:<input type="text" name="email">
               <br/>
               <br/>
               Address<input type="text" name="address">
               <br/>
               <br/>
               <input type="submit" value="Submit">  <input type="reset" value="reset"></p>
               <input name="action" type="hidden" value="edit">
               </form>
               
           </div>
               
        </section>
    </body>
</html>

