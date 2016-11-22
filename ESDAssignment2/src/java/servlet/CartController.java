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
        String username = "app";
        String password = "app";
        String url = "jdbc:derby://localhost/database"; 
        db = new ShoppingCartDB(url, username, password);
        db.dropTable();
        db.createTable();
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
  String strAction = request.getParameter("action");
   
   
   if(strAction.equals("add")) {
    addToCart(request,response);
   } else if (strAction.equals("edit")) {
    editCart(request,response);
   } else if (strAction.equals("Delete")) {
    deleteCart(request,response);
   }

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
     }
    
    protected void editCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String quantity = request.getParameter("quantity");
        db.UpdateQuantity(quantity);
        ArrayList list = db.queryItems();
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
        rd.forward(request, response);
        
     }
    
    protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
       String ID = request.getParameter("ID");
       db.delRecord(ID);
       ArrayList list = db.queryItems();
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
        rd.forward(request, response);
     }
    
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
