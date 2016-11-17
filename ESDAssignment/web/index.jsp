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
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- css import-->
        <link rel="stylesheet" href="css/style.css">
        
        <!--java import-->
        <%@page import="java.util.ArrayList"%>
        
        <!--list load-->
        <jsp:include page="/ItemsServlet.java" />
        <%
            ArrayList list = (ArrayList) request.getAttribute("list");
        %>
    </head>
    <body>
        
       <jsp:include page="include/header.jsp" />
       
       <section class="search-bar">
            <div class="center-search-bar">
                <input type="text" name="search" class="search-box" placeholder="Search...">
                <button class="search-btn" style="vertical-align:middle">
                    <span>Search</span>
                </button>
            </div>
        </section>
       
        <hr size="2" width="80%">
        <div id="order">
            <a href="itemdetail"  id="btn"  >News</a>
            <a href="itemdetail"  id="btn"  >Short</a>
            <a href="itemdetail"  id="btn"   >Middle</a>
            <a href="itemdetail"  id="btn" >Long</a>
            <a href="itemdetail"  id="btn"  >Sheath</a>

        </div>
        <hr size="2" width="80%">
        <div id="container">
            <div id="item1" ><img src="img\clothes\Men\1.png">100$</div>

            <div id="item2" ><img src="img\clothes\Men\2.jpg">200$</div>

            <div id="item3" ><img src="img\clothes\Men\3.jpg">300$</div>

        </div>
    </body>
</html>
