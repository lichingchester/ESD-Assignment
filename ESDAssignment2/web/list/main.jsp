<%-- 
    Document   : main
    Created on : 2016年11月19日, 下午07:18:42
    Author     : lichi
--%>

<%@page import="bean.UserBean"%>
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
            String type = request.getParameter("type");
            String Tel=request.getParameter("Tel");
            boolean login = false;
            UserBean ub = (UserBean) request.getAttribute("ub");
        %>
    </head>
    <body>
        <% 
            if(Tel.equals(null)){
                login = false;
            }else{
                login = true;
            }
        %>
        <c:if test="${'login' == false}">
            <jsp:include page='../include/header.jsp' />
            <continue>
        </c:if>
        <c:if test="${'login' == true}">
            <jsp:include page='../include/header.jsp' />
        </c:if>

       <section class="search-bar">
            <div class="center-search-bar">
                <form action="ItemsServlet">
                <input name="action" type="hidden" value="searchByName">
                <input type="text"  name="itemName" class="search-box" placeholder="Search...">
                <button class="search-btn" style="vertical-align:middle">
                    <span>Search</span>
                </button>
                </form>
            </div>
        </section>
       
       
        <hr size="2" width="80%">
        <div id="order">
            <a href="ItemsServlet?action=list" id="btn"  >News</a>
            <a href="ItemsServlet?action=searchByCategory&category=short" id="btn"  >Short</a>
            <a href="ItemsServlet?action=searchByCategory&category=middle"  id="btn"   >Middle</a>
            <a href="ItemsServlet?action=searchByCategory&category=long"  id="btn" >Long</a>
            <a href="ItemsServlet?action=searchByCategory&category=sheath"  id="btn"  >Sheath</a>
        </div>
        
        <hr size="2" width="80%">
        <div id="container">
            
            
            <%
                for(int i=0;i<list.size();i++){
                    ItemBean ib = (ItemBean)list.get(i);
                    String name=ib.getItemID();
                    out.print("<div id='item1'>"
                            +"<a href='ItemsServlet?action=itemdetail&name="
                            +name+"&Tel="+Tel+"'>"
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
