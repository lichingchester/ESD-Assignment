<%-- 
    Document   : register
    Created on : 2016年11月16日, 下午06:09:30
    Author     : ken42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="registration.jsp">  
        <p>Name<input type="text" name="uname"></p>
        <p>Password<input type="text" name="pass"></p>
        <p>Tel<input type="text" name="tel"></p>
        <p>Email<input type="text" name="email"></p>
        <p> Address<input type="text" name="address"></p>
        <p> <input type="submit"> <input type="reset"></p>
        </form>
    </body>
</html>
