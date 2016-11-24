<%@page import="bean.UserBean"%>
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
            String Tel=request.getParameter("Tel");
            String action="login";
            UserBean ub = (UserBean) request.getAttribute("ub");
            double price=1;
            String ItemID="";
            String path="";
            String ID = (String) request.getAttribute("name");
            if(detail == null) out.println("safdasf");
            
                for(int i=0;i<detail.size();i++){
                    ItemBean ib = (ItemBean)detail.get(i);
                    if(ID.equals(ib.getItemID())){
                    ItemName=ib.getItemName();
                    ItemID=ib.getItemID();
                    price=ib.getPrice();
                    path=ib.getPath();
                    
                    }
                }
        %>
        
        <!-- css import-->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <c:when test="${Tel.equals(null)}">
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
                <a href="ItemsServlet?action=list" id="btn"  >News</a>
                <a href="ItemsServlet?action=searchByCategory&category=short" id="btn"  >Short</a>
                <a href="ItemsServlet?action=searchByCategory&category=middle"  id="btn"   >Middle</a>
                <a href="ItemsServlet?action=searchByCategory&category=long"  id="btn" >Long</a>
                <a href="ItemsServlet?action=searchByCategory&category=sheath"  id="btn"  >Sheath</a>
        </c:when>
        <c:otherwise>
            <div id="bg">
                <% out.println("<input type='hidden' name='list'>"); %>
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white ;font-size:large " >Name:<%out.print(ub.getName());%></label>
                <a href="startup" class="navbar">Logout</a>
                
                <a href="CartController?action=list" class="navbar">MyShoppingCart</a>
                <a href="UpdateInfo.jsp?action=<%out.print(ub.getTel());%>&Uname=<%out.print(ub.getName());%>&address=<%out.print(ub.getAddress()); %>&Tel=<%out.print(ub.getTel());%>" class="navbar">Setting</a>
                <a href="ItemsServlet?action=list&Tel=<%out.print(ub.getTel());%>&UB=<%=ub%>" class="navbar">BuyThings</a>
                
            </div>
        </c:otherwise>
    </c:choose>
   
            </div>
            <hr size="2" width="80%">
            <div id="container">
                 <div id="item3">
                   <img src='<%out.print(path);%>'>
                 </div>
                 <div id="iteminfo">
                     <form action='CartController'>
                     <br>
                     <br>
                     <input type="hidden" name="CustTel" value=<%=Tel %>>
                     <input type="hidden" name="ID" value=<%=ItemID %>>
                     Name:<%out.print(ItemName);%><input type="hidden" name="name" value=<%=ItemName%>>
                     <br/>
                     Price:<%out.print(price);%><input type="hidden" name="price" value=<%=price%>>
                     <hr size="2" width="80%">
                     <form>
                         <select name="size">
                             
                     <option>XS</option>
                     <option>S</option>
                     <option selected="true">M</option>
                     <option >L</option>
                     <option >XL</option>
                     </select>
                         <br>
                         <br>
                         Quantity:<input type="number" name="quantity" value="1" min="1">
                         <br>
                         <br>
                         <%
                           if(!Tel.equals("null")){action = "add";}  
                         %>
                     <input type="hidden" name="Tel" value=<%=Tel%>>
                     <input type="hidden" name="action" value=<%=action%>>
                     <input type="submit" value="Shopping Cart">
                     </form>
                 </div> 
            </div>
            
    </body>
</html>
