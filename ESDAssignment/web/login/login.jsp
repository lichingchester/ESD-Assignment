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
        <title>login Page</title>
    </head>
    <body>
        <form method="post" action="../main">
        <input type="hidden" name="action" value="authenticate">   
        <p>Name <input type="text" name="username"></p>
        <p>Password <input type="text" name="password"></p>
        <input type="submit" value="Login">  <input type="reset">
        <a href="../register.jsp">register</a>
        </form>
    </body>
</html>
