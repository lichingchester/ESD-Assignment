<%-- 
    Document   : order
    Created on : 2016年11月16日, 下午07:04:49
    Author     : huen
--%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        
        <link rel="stylesheet" href="css/style.css">

        <%@page import="bean.OrderBean"%>
        <%@page import="bean.UserBean"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <% 
            UserBean ub = null;
            ArrayList<OrderBean> list = null;
            if(request.getAttribute("ub") != null){
                ub = (UserBean) request.getAttribute("ub");
                request.getSession().setAttribute("ub",ub);
            }
            if(request.getAttribute("ol") != null){
                list = (ArrayList) request.getAttribute("ol");
                request.getSession().setAttribute("ol", list);
            }
        
        %> 
        
        <%
            if(request.getParameter("message") != null){
                if(request.getParameter("message").equals("redeemOK")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('redeemOK');");
                    /*out.println("location='index.jsp';");*/
                    out.println("</script>");
                }else if (request.getParameter("message").equals("redeemFail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('redeemFail');");
                    /*out.println("location='index.jsp';");*/
                    out.println("</script>");
                }
            }
            
        %>
    </head>
    <body>
       <section class="header">
            <div id="bg">
                <% out.println("<input type='hidden' name='list'>"); %>
                <a href="index.jsp"><img src="img\LOGO.png"></a>
                <img src="img\icon.png"><label style="color:white" class="navbar" >Name:<%out.print(ub.getName());%></label>
                <a href="startup" class="navbar">Logout</a>
                
                <a href="CartController?action=list" class="navbar">MyShoppingCart</a>
                <a href="UpdateInfo.jsp?action=<%out.print(ub.getTel());%>&Uname=<%out.print(ub.getName());%>&address=<%out.print(ub.getAddress()); %>&Tel=<%out.print(ub.getTel());%>" class="navbar">Setting</a>
                <a href="ItemsServlet?action=list&Tel=<%out.print(ub.getTel());%>&Uname=<%out.print(ub.getName());%>" class="navbar">BuyThings</a>
                
            </div>
           <br>
           <div id="container">
               <form>
               <h1>Order History</h1><a href="BonusPServlet?ID=<%out.print(ub.getTel());%>">Check Bonus Point</a>
               <hr size="2" width="100%">
               
               <table>
                    <tr>
                    <th>UserID</th>
                    <th>Items ID</th>
                    <th>Quantity</th>
                    <th>Size</th>
                    <th>Delivery Type</th>
                    <th>Delivery Address</th>
                    <th>Delivery Time</th>
                    <th>Delivery Date</th>
                    <th>Status</th>
                    <th>Edit</th>
                    <th>Cancel Order</th>
                    </tr>
                    
                    <%
                        if(list != null && ub != null){
                            for(int i=0;i<list.size();i++){
                                OrderBean ob = (OrderBean)list.get(i);
                                if(ob.getUserTel().equals(ub.getTel())){
                                int orderID=ob.getOrderID();
                                out.print("<tr>");
                                out.print("<td> "+ ob.getOrderID() +" </td>");
                                out.print("<td> "+ ob.getItemID() +" </td>");
                                out.print("<td> "+ ob.getQuantity() +" </td>");
                                out.print("<td> "+ ob.getSize()+" </td>");
                                out.print("<td> "+ ob.getDeliveryType()+" </td>");
                                out.print("<td> "+ ob.getDeliveryAddress()+" </td>");
                                out.print("<td> "+ ob.getDeliveryDate()+" </td>");
                                out.print("<td> "+ ob.getDeliveryTime()+" </td>");
                                out.print("<td> "+ ob.getStatus()+" </td>");
                                out.print("<td><a href='UpdateDelivery.jsp?order="+orderID+"'>Edit</a></td>");
                                out.print("<td><a href='DeleteOrder?order="+orderID+"'>Cancel Order</a></td>");
                                out.print("</tr>");
                                }
                            }
                        }
                    %>
               </table>
               </form>
               
               
                 
            </div>
        </section>
    </body>
</html>
