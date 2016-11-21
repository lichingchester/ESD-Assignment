<!DOCTYPE html>
<!-- 
emmet key
http://docs.emmet.io/abbreviations/syntax/

free image download
https://www.pexels.com/photo/street-car-vehicle-blur-1459/

colour physiological
https://buzzorange.com/techorange/2015/05/26/color/ 
-->

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
                <!--java import-->
        <%@page import="java.util.ArrayList"%>
        <%@page import="bean.ItemBean"%>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <%
            
            ArrayList detail = (ArrayList) request.getAttribute("detail");
            String ItemName="";
            double price=1;
            String path="";
            String ID = (String) request.getAttribute("name");
            if(detail == null) out.println("safdasf");
            
                for(int i=0;i<detail.size();i++){
                    ItemBean ib = (ItemBean)detail.get(i);
                    if(ID.equals(ib.getItemID())){
                    ItemName=ib.getItemName();
                    price=ib.getPrice();
                    path=ib.getPath();
                    
                    }
                }
        %>
        
        <!-- css import-->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="header">
            
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <a href="register.jsp" class="navbar">Join us</a>
                <a href="login.jsp" class="navbar">Login</a>
                <a href="order.jsp" class="navbar">Order</a>
            </div>         
        </section>
        
        <section class="logo">
            <div class="brand">
                <a href="index.jsp" class="brand-name"><font id="font-red">C</font>&<font id="font-red">F</font> <font id="font-red">D</font>ress</a>
            </div>
        </section>
        
        <section class="search-bar">
            <div class="center-search-bar">
                <input type="text" name="search" class="search-box" placeholder="Search..">
                <button class="search-btn" style="vertical-align:middle">
                    <span>Search</span>
                </button>
            </div>
        </section>
            <hr size="2" width="80%">
            <div id="order">
                <a href="itemdetail.jsp"  id="btn"  >News</a>
                <a href="itemdetail.jsp"  id="btn"  >Shoes</a>
                <a href="itemdetail.jsp"  id="btn"  >Women</a>
                <a href="itemdetail.jsp"  id="btn"   >Men</a>
                <a href="itemdetail.jsp"  id="btn" >Shopping Cart</a>
            
            </div>
            <hr size="2" width="80%">
            
            <div id="container">
                 <div id="item3">
                   <img src='<%out.print(path);%>'>
                 </div>
                 <div id="iteminfo">
                     <br>
                     <br>
                     Name:<%out.print(ItemName);%>
                     <br/>
                     Price:<%out.print(price);%>
                     <hr size="2" width="80%">
                     <form>
                         <select>
                     <option>S size</option>
                     <option selected="true">M size</option>
                     <option >L size</option>
                     </select>   
                         <br>
                         <br>
                     <input type="button" id="btn" value="Shopping Cart">
                     </form>
                 </div> 
            </div>
            
    </body>
</html>
