<%-- 
    Document   : welcome
    Created on : 2016年11月18日, 下午11:25:10
    Author     : ken42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>welcome Page</title>
    </head>
    <body>
        <jsp:useBean id="User" class="bean.User" scope="session"/>
        <h1>Welcome</h1>
        <jsp:getProperty name="User" property="id"/>
    </body>
</html>
