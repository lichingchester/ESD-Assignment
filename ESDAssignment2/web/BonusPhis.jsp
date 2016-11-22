<%-- 
    Document   : BonusPhis
    Created on : 2016年11月23日, 上午05:36:01
    Author     : a0321
--%>

<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            UserBean ub = new UserBean();
            ArrayList<UserBean> list2 = null;
            if((ArrayList) request.getAttribute("list") != null){
                list2 = (ArrayList) request.getAttribute("list");
                ub = (UserBean)list2.get(0);
            }
           

%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:<%out.print(ub.getName());%></label>
                <a href="startup" class="navbar">Logout</a>
                <a href="order.jsp" class="navbar">Order</a>
                <a href="#asdf" class="navbar">asdf</a>
            </div>
           <br>
           <div id="container">
               <form>
                  
                   <h1>Order History</h1>
                   <a href="BonusPServlet?ID=<%out.print(ub.getTel());%>" >Check Bonus Point</a>
               <hr size="2" width="100%">
               
               <table border='2'>
                    <%
                                out.print("The Bonus Point:");
                                out.print(ub.getBonusPoint());
                                
                    %>
                    <br>
                    <tr><td><img src='img/accessories/earring.JPG'height="320" weight='240'><h4> Earring </h4><br>
                            price:500</td>
                        <td><img src='img/accessories/hand.jpg'   height="320" weight='240'> <h4>Bracelet</h4> <br>
                            price:700<td></tr>
                    <tr><td><img src='img/accessories/ring.jpg' height="320" width='450'> <h4>Ring </h4><br>
                              price:1000  </td>
                        <td><img src='img/accessories/rolex.jpg' height="320" width='450' ><h4>Rolex</h4> <br>
                              price:15000 </td></tr>
               </table>
               </form>
               
               
                 
            </div>
        </section>
    </body>
</html>
