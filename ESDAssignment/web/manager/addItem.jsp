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
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <jsp:include page="../include/header.jsp" />
        
        <div class="div-center additem">
            <h1><b>Add new item</b></h1>
            <form action="ItemsServlet" method="post" class="formadd">
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
                        <option value="">Australia</option>
                        <option value="ca">Canada</option>
                        <option value="usa">USA</option>
                    </select><br>
                </p>
                <p>
                    <label for="dname">Desinger Name</label><br>
                    <input type="text" id="dname" name="dname" class="input-add"><br>
                </p>
                <p>
                    <label for="Size">Size</label><br>
                    <input type="text" id="price" name="price" class="input-add"><br>
                </p>
                <p>
                    <label for="price">Price</label><br>
                    <input type="text" id="price" name="price" class="input-add"><br>
                </p>
                <p>
                    <label for="lname">Upload</label><br>
                    <input type="text" id="desc" name="desc" class="input-add"><br>
                </p>
            </form>
        </div>
    </body>
</html>
