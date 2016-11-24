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
            String action=request.getParameter("action");
            String Uname=request.getParameter("Uname");
            String Address=request.getParameter("address");
            
            UserBean ub = null;
            if(request.getAttribute("ub") != null){
                ub = (UserBean) request.getAttribute("ub");
            }else{
//                out.println("userbean");
            }
            ArrayList olist = null;
            if(request.getAttribute("ol") != null){
                olist = (ArrayList) request.getAttribute("ol");
            }else{
//                out.println("list");
            }
            
//            request.setAttribute("ub", ub);
//            request.setAttribute("ol", olist);
        %>
    </head>
    <body>
    <% 
        if(Tel.equals("null")){
    %>
        <jsp:include page='../include/header.jsp' />
    <%
        }else{
    %>
        <section class="header">
            <div id="bg">
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png">
                <label style="color:white ;font-size:large " >Name:<%=Uname%></label>
                <a href="startup" class="navbar">Logout</a>
                <a href="CartController?action=list" class="navbar">MyShoppingCart</a>
                <a href="UpdateInfo.jsp?action=<%=Tel%>&Uname=<%=Uname%>&address=<%=Address%>&Tel=<%=Tel%>" class="navbar">Setting</a>
                <a href="ItemsServlet?action=list&Tel=<%=Tel%>&Uname=<%=Uname%>&address=<%=Address%>&Tel=<%=Tel%>" class="navbar">BuyThings</a>
                <a href="LoginHandler?mode=fuck&Tel=<%= ub.getTel() %>" class="navbar">Member Center</a>
            </div>
        </section>
            
        <section class="logo">
            <div class="brand">
                <a href="#home" class="brand-name"><font id="font-red">C</font>&<font id="font-red">F</font> <font id="font-red">D</font>ress</a>
            </div>
        </section>
       <%
           }
       %>
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
            <a href="ItemsServlet?action=list&Tel=<%=Tel%>&Uname=<%=Uname%>" id="btn" >News</a>
            <a href="ItemsServlet?action=searchByCategory&category=short&Tel=<%=Tel%>&Uname=<%=Uname%>" id="btn"  >Short</a>
            <a href="ItemsServlet?action=searchByCategory&category=middle&Tel=<%=Tel%>&Uname=<%=Uname%>"  id="btn"   >Middle</a>
            <a href="ItemsServlet?action=searchByCategory&category=long&Tel=<%=Tel%>&Uname=<%=Uname%>"  id="btn" >Long</a>
            <a href="ItemsServlet?action=searchByCategory&category=sheath&Tel=<%=Tel%>&Uname=<%=Uname%>"  id="btn"  >Sheath</a>
        </div>
        
        <hr size="2" width="80%">
        <div id="container">
            
            
            <%
                for(int i=0;i<list.size();i++){
                    ItemBean ib = (ItemBean)list.get(i);
                    String name=ib.getItemID();
                    out.print("<div id='item1'>"
                            +"<a href='ItemsServlet?action=itemdetail&name="
                            +name+"&Tel="+Tel+"&Uname="+Uname+"'>"
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
