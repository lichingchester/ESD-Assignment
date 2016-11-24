<%-- 
    Document   : header2
    Created on : 2016年11月23日, 上午11:04:38
    Author     : Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="header">
            <div id="bg">
                <jsp:useBean id="user" type="bean.UserBean" scope="session">
                    <jsp:getProperty name="user" property="tel" />
                    <jsp:getProperty name="user" property="username" />
               </jsp:useBean>
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:<%out.print(ub.getName());%></label>
                <a href="startup" class="navbar">Logout</a>
                
                <a href="CartController?action=list" class="navbar">MyShoppingCart</a>
                <a href="UpdateInfo.jsp?action=<%out.print(user.getTel());%>&Uname=<%out.print(user.getName());%>&address=<%out.print(user.getAddress()); %>&Tel=<%out.print(user.getTel());%>" class="navbar">Setting</a>
                <a href="ItemsServlet?action=list&Tel=<%out.print(user.getTel());%>&UB=<%=user%>" class="navbar">BuyThings</a>
            </div>
        </section>
    </body>
</html>
