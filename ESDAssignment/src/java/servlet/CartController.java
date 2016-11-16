/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
 
import java.io.IOException;

import bean.CartBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Wang
 */
public class CartController extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  String strAction = request.getParameter("action");
   
   
  if(strAction!=null && !strAction.equals("")) {
   if(strAction.equals("add")) {
   // addToCart(request);
   } else if (strAction.equals("Update")) {
  //  updateCart(request);
   } else if (strAction.equals("Delete")) {
   // deleteCart(request);
   }
  }
  response.sendRedirect("../ShoppingCart.jsp");
 }
    
    
}
