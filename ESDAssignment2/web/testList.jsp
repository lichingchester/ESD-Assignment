<%-- 
    Document   : testList
    Created on : 2016年11月16日, 下午11:31:47
    Author     : Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
         <table border="1px">
        <form action="CartController" method="post">
    
            <th>Pizza Name</th> <th>Price</th>  <th>Add to Cart</th>
            <tr><td>Muffuleta<input type="hidden" name="ID" value="1"><input type="hidden" name="modelNo" value="Muffuleta"></td><td>$20<input type="hidden" name="price" value="20">
                    <input type="hidden" name="quantity" value="1"><input type="hidden" name="description" value="ABC"></td><td>
            <input type="hidden" name="price" value="20"><input type="hidden" name="action" value="add"><input type="submit" value="Add To Cart"></td>
        </tr>
        </form>
        <!--<form action="CartController.java" method="POST">
            <tr><td>Veggie Delight<input type="hidden" name="ID" value="2"><input type="hidden" name="modelNo" value="Veggie Delight"></td><td>$40<input type="hidden" name="price" value="40">
                <input type="hidden" name="quantity" value="1"><input type="hidden" name="description" value="ABC"></td><td>
            <input type="hidden" name="action" value="add"><input type="submit" name="addToCart" value="Add To Cart"></td>
        </tr>  
        </form>
         <form action="CartController.java" method="POST">
            <tr><td>Margherita<input type="hidden" name="ID" value="3"><input type="hidden" name="modelNo" value="Margherita"></td><td>$10<input type="hidden" name="price" value="10">
                <input type="hidden" name="quantity" value="1"><input type="hidden" name="description" value="ABC"></td><td>
               <input type="hidden" name="action" value="add"><input type="submit" name="addToCart" value="Add To Cart"></td>
            </tr>
            
        </form>-->
</table>
    </body>
</html>
