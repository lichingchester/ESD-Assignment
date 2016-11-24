<%-- 
    Document   : editItem
    Created on : 2016年11月17日, 下午04:59:20
    Author     : lichi
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">

        <%@page import="bean.ItemBean"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            ItemBean ib = (ItemBean) request.getAttribute("itemBean");
        %>
        
    </head>
    <body>
        <section class="header">
            <div id="bg">
                <img src="/ESDAssignment2/img/LOGO.png">
                <a href="index.jsp" class="navbar">Log out</a>
            </div>         
        </section>
        
        <br>
        
           <div id="container">
            <h1 style="font-size: 50px">Top Confidential Management Room</h1>
            <br>
<!--               <a href="/managerHandle?action=users" class="adminitemmt">Users Mamagement</a>
            <a href="/managerHandle?action=orderps" class="adminitemmt">Orders Mamagement</a>
            <a href="/managerHandle?action=item" class="adminitemmt">Items Mamagement</a>
            <a href="/managerHandle?action=report" class="adminitemmt">Incomplete Order Report</a>
            -->
             <ul>
                 <li class="dropdown">
                     <a href="managerHandle?action=item">Items Management</a>
                     <div class="dropdown-content">
                         <a href="managerHandle?action=addItem">Add Item</a>
                     </div>
                 </li>
                 <li>
                     <a href="managerHandle?action=report">Incompleted Report</a>
                 </li>
                 <li class="dropdown">
                     <a href="#" class="dropbtn">Users Management</a>
                     <div class="dropdown-content">
                         <a href="managerHandle?action=users">Confirmed Users</a>
                         <a href="managerHandle?action=ncusers">Unconfirmed Users</a>
                     </div>
                 </li>
                 <li class="dropdown">
                     <a href="#" class="dropbtn">Orders Management</a>
                     <div class="dropdown-content">
                         <a href="managerHandle?action=orderps">Processing Orders</a>
                         <a href="managerHandle?action=orderhis">Orders History</a>
                     </div>
                 </li>
             </ul>
             <br>
                
            <div id="container">
                <form action="ItemEdit" class="formadd">
                    <p>
                        <label for="itemID">Item ID:</label><br>
                        <input class="input-add" type="text" name="itemID" value="<%= ib.getItemID() %>" readonly>
                    </p>
                    <br>
                    <p>
                        <label for="name">Item Name</lable><br>
                        <input class="input-add" type="text" name="name" value="<%= ib.getItemName() %>">
                    </p>
                    <br>
                    <p>
                        <label for="desc">Description</label><br>
                        <textarea class="input-add" name="desc" cols="50" rows="5"><%= ib.getDesc() %></textarea>
                    </p>    
                    <br>
                    <p>
                        <label for="cty">Category</label><br>
                        <select class="input-add" name="cty">
                            <option value='long'
                                    <%
                                        if(ib.getCategory().equals("long")){
                                            out.print("selected='selected'");
                                        }
                                    %>
                                >Long</option>
                            <option value="middle" 
                                    <%
                                        if(ib.getCategory().equals("middle")){
                                            out.print("selected='selected'");
                                        }
                                    %>
                                >Middle</option>
                            <option value="short"
                                    <%
                                        if(ib.getCategory().equals("short")){
                                            out.print("selected='selected'");
                                        }
                                    %>
                                >Short</option>
                            <option value="sheath"
                                    <%
                                        if(ib.getCategory().equals("sheath")){
                                            out.print("selected='selected'");
                                        }
                                    %>
                                >Sheath</option>
                        </select>
                    </p>
                    <br>
                    <p>
                        <label for="dname">Designer Name</label><br>
                        <input class="input-add" type="text" name="dname" value="<%= ib.getDesignerName() %>">
                    </p>
                    <br>
                    <p>
                        <label for="price">Price</label><br>
                        <input class="input-add" type="text" name="price" value="<%= ib.getPrice() %>">
                    </p>
                    <br>
                    <p>
                        <input class="additem-submit edititem" type="submit" value="Edit">
                        <input class="additem-submit edititem" type="reset" value="Cancel">
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>
