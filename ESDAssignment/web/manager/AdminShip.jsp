<%-- 
    Document   : AdminShip
    Created on : 2016年11月20日, 上午03:14:55
    Author     : lichi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <section class="header">
        <div id="bg">
            <img src="/ESDAssignment/img/LOGO.png">
            <a href="order.jsp" class="navbar">Order</a>
            <a href="#logout" class="navbar">Log out</a>
        </div>         
    </section>
        
        <br>
           <div id="container">
               <h1 style="font-size: 50px">Top Confidential Management Room</h1>
               <br>
               <a href="AdminShip.jsp" class="adminitemmt">Users Mamagement</a>
               <a href="ItemsManage.jsp" class="adminitemmt">Items Mamagement</a>
               <a href="ICOReport.jsp" class="adminitemmt">Incomplete Order Report</a>
               <hr size="2" width="100%">
               
               <table>
                    <tr>
                    <th>Items Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    </tr>
                    
                    <tr>
                    <td>Fucking Dress</td>
                    <td>Delivering</td>
                    <td>100$</td>
                    </tr>
               </table>
               
               
                 
            </div>
    </body>
</html>
