<%-- 
    Document   : addItem
    Created on : 2016年11月17日, 下午01:42:56
    Author     : lichingchester
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/admin.css">
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
        </div>
        
        <br>
        <br>
                
        <div class="div-center additem">
            <h1><b>Add new item</b></h1>
            <form action="../ItemUpload" method="post" class="formadd">
                <p>
                    <label for="name">Item Name</label><br>
                    <input type="text" id="name" name="name" class="input-add"><br>
                </p>
                <p>
                    <label for="desc">description</label><br>
                    <input type="text" id="desc" name="desc" class="input-add"><br>
                </p>
                <p>
                    <label for="cty">Category</label><br>
                    <select id="cty" name="cty" class="input-add">
                        <option value="long">Long dress</option>
                        <option value="middle">Middle dress</option>
                        <option value="short">Short dress</option>
                        <option value="sheath">Sheath dress</option>
                    </select><br>
                </p>
                <p>
                    <label for="dname">Designer Name</label><br>
                    <input type="text" id="dname" name="dname" class="input-add"><br>
                </p>
                <p>
                    <label for="Size">Size</label><br>
                    <select id="size" name="size" class="input-add">
                        <option value="XS">XS</option>
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                    </select><br>
                </p>
                <p>
                    <label for="price">Price</label><br>
                    <input type="text" id="price" name="price" class="input-add"><br>
                </p>
                <p>
                    <label for="path">Upload</label><br>
                    <input type="file" id="path" name="path" multiple="false" class="input-add"><br>
                </p>
                <p>
                    <input type="submit" value="Submit" class="additem-submit">
                    <input type="reset" value="Reset" class="additem-submit">
                </p>
            </form>
        </div>
    </body>
</html>
