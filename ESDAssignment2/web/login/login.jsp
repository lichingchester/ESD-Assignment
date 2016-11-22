<%-- 
    Document   : login
    Created on : 2016年11月16日, 下午06:34:05
    Author     : ken42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="..\css/style.css">
        <title>login Page</title>
    </head>
    <body>
           <section class="header">
           <div id="bg">
               <a href="..\index.jsp"><img src="/ESDAssignment2/img/LOGO.png"></a>
            <a href="register.jsp" class="navbar">Join us</a>
            <a href="order.jsp" class="navbar">Order</a>
          </div>         
    </section>       
         
        <div id="container">
        <form method="post" action="../LoginHandler">
            <!--<input type="hidden" name="action" value="authenticate"/>-->
            <h1>Login</h1>
            <p>
                Name <input type="text" name="username"><br/>
            </p>
            <p>
                Password <input type="password" name="password"><br/>
            </p>
            <br/>
            <input type="submit" value="Login">  <input type="reset">
            
            <a href="../register.jsp">register</a>
        </form>
         
    
    </body>
</html>
