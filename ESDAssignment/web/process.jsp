<%-- 
    Document   : process
    Created on : 2016年11月16日, 下午07:05:40
    Author     : ken42
--%>
<%@page import="bean.RegisterDo"%>
<jsp:useBean id="obj" class="bean.User"/>
<jsp:setProperty property="*" name="obj"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
int status=RegisterDo.register(obj);  
if(status>0)  
out.print("You are successfully registered");  
  
%>  
    </body>
</html>
