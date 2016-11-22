<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Order Page</title>
    </head>
    <body>
        <%ArrayList ShoppingCartList;%>
       <section class="header">
            <div id="bg">
                <a href="#join" class="navbar">Join us</a>
                <a href="#login" class="navbar">Login</a>
                <a href="order.jsp" class="navbar">Order</a>
            </div>
           <div id="order">
             wait for the shopping cart
               
           </div> </section>
        
           <form action="">
               <div>  //show shopping cart
                 <table border="1">
                     delivery<input type="radio" name="choose" value="delivery">
                     self-pick <input type="radio" name="choose" value="selfPick">
                     <tr><th>Product Name</th> <th>Size</th> <th>Quantity</th> <th>Price</th></tr>
                    
                     <%for(int i=0;i<ShoppingCartList.size();i++){
                         System.out.print("<tr> <td>"+ShoppingCartList.get(i)+"</td> <td>"+ShoppingCartList.get(i)+"</td> "
                                 + "<td>"+ShoppingCartList.get(i)+"</td> <td><"+ShoppingCartList.get(i)+"/td> </tr>");
                         }%> 
                     <input type="hidden" name="SClist" >
                 </table>
               </div>
             <a href="">Edit</a>//go back shopping cart
             
            <input type="submit" value="confirm">//->go sevlet
            <% request.setAttribute("arrayList", ShoppingCartList);
            RequestDispatcher rd = request.getRequestDispatcher("ConfirmOrderServlet");
            rd.forward(request, response);
            %>
            //send ShoppingCartList to ConfirmOrderServlet
           </form>
       
    </body>
</html>
