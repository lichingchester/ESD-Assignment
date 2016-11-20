<%-- 
    Document   : shoppingCart
    Created on : 2016年11月16日, 下午11:06:22
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
      <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<p><font face="Verdana, Arial, Helvetica, sans-serif"><strong>Shopping Cart</strong></font></p>
<p><a href="/shoppingList.jsp" mce_href="shoppingList.jsp">Model List</a> </p>

  <tr bgcolor="#CCCCCC">
    <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Model
      Description</font></strong></td>
    <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></td>
    <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Unit
      Price</font></strong></td>
    <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font></strong></td>
  </tr>
  <jsp:useBean id="cart" scope="session" class="bean.CartBean" />
  <c:if test="${cart.lineItemCount==0}">
  <tr>
  <td colspan="4"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">- Cart is currently empty -<br/>
  </tr>
  </c:if>
  <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
  <form name="item" method="POST" action="servlet/CartController">
  <tr>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b><c:out value="${cartItem.partNumber}"/></b><br/>
      <c:out value="${cartItem.modelDescription}"/></font></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'><input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'> <input type="submit" name="action" value="Update">
 <br/>         <input type="submit" name="action" value="Delete"></font></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.unitCost}"/></font></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.totalCost}"/></font></td>
  </tr>
  </form>
  </c:forEach>
  <tr>
    <td colspan="2"> </td>
    <td> </td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Subtotal: $<c:out value="${cart.orderTotal}"/></font></td>
  </tr>

</body>
</html>
