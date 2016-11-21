/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
 
import java.io.IOException;

import bean.CartListBean;
import db.ItemsDB;
import db.ShoppingCartDB;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
//import bean.CartBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Wang
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet{
    private ShoppingCartDB db;
    //private ItemsDB db;
    
        public void init() {
        String username = "abc";
        String password = "123";
        String url = "jdbc:derby://localhost/ShoppingCartDB"; 
        //db = new ItemsDB(url, username, password);
        db = new ShoppingCartDB(url, username, password);
        db.dropTable();
        db.createTable();
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  String strAction = request.getParameter("action");
   
   
   if(strAction.equals("add")) {
    addToCart(request,response);
   } /*else if (strAction.equals("Update")) {
    updateCart(request);
   } else if (strAction.equals("Delete")) {
    deleteCart(request);
   }*/

 }
    protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        //String ID = request.getParameter("ID");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String size = request.getParameter("size");

        db.addRecord(name,price,size);
        ArrayList list = db.queryItems();
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
        rd.forward(request, response);
        //Object objCartBean = session.getAttribute("cart");
        
        /*if(objCartBean!=null) {
         cartBean = (CartBean) objCartBean ;
        } else {
         cartBean = new CartBean();
         session.setAttribute("cart", cartBean);
        }*/
     }
    
   /* protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean!=null) {
         cartBean = (CartBean) objCartBean ;
        } else {
         cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
     }
    
    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if(objCartBean!=null) {
         cartBean = (CartBean) objCartBean ;
        } else {
         cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemIndex);
     }*/
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
