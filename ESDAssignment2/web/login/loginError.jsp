<%-- 
    Document   : loginError
    Created on : 2016年11月18日, 下午11:18:52
    Author     : ken42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Error</title>
    </head>
    <body>
        <p>Incorrect Password</p>
        <p>
            
                <% out.println("<a href=\"" + request.getContextPath() + "/main\">Login again</a>");%>
           
        </p>
    </body>
</html>
