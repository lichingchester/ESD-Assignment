<%-- 
    Document   : main
    Created on : 2016年11月19日, 下午07:18:42
    Author     : lichi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- css import-->
        <link rel="stylesheet" href="css/style.css">
        
        <!--java import-->
        <%@page import="java.util.ArrayList"%>
        <%@page import="bean.ItemBean"%>

        <!--list load-->
        <%
            ArrayList list = (ArrayList) request.getAttribute("list");
            if(list == null) out.println("safdasf");
        %>
    </head>
    <body>
        
       <jsp:include page="../include/header.jsp" />

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
            
            <%
                for(int i=0;i<list.size();i++){
                    ItemBean ib = (ItemBean)list.get(i);
                    String name=ib.getItemID();
                    out.print("<div id='item1'>"
                            +"<a href='ItemsServlet?action=itemdetail&name="
                            +name+"'>"
                            + "<img src='"+ib.getPath()+"'></a>"+"<br/>"
                            +ib.getPrice()+"</div>");
                }
            %>
            
<!--            <div id="item1" ><img src="img\clothes\Men\1.png">100$</div>

            <div id="item2" ><img src="img\clothes\Men\2.jpg">200$</div>

            <div id="item3" ><img src="img\clothes\Men\3.jpg">300$</div>-->

        </div>
    </body>
</html>
