/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
 
import java.io.IOException;

import bean.CartListBean;
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
  System.out.println("Enter");
   
   
   if(strAction.equals("add")) {
    addToCart(request,response);
   } else if (strAction.equals("edit")) {
    editCart(request,response);
   } else if (strAction.equals("delete")) {
    deleteCart(request,response);
   } else if (strAction.equals("login")){
    login(request,response);
   } else if (strAction.equals("list")){
    ListCart(request,response);
   }

 }
    protected void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        String ID = request.getParameter("ID");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String size = request.getParameter("size");
        String quantity = request.getParameter("quantity");
        String Tel = request.getParameter("Tel");
        
        if(db.checkByIdSize(ID,size) == true){
            db.UpdateQuantity(ID,quantity);
            ArrayList list = db.queryItems();
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
            rd.forward(request, response);
        }else{
            db.addRecord(Tel,ID,name,price,quantity,size);
            ArrayList list = db.queryItems();
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
            rd.forward(request, response);
        }
     }
    
    protected void editCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String Tel = request.getParameter("Tel");
        String ID = request.getParameter("ID");
        String quantity = request.getParameter("quantity");
        db.UpdateQuantity(ID,quantity);
        ArrayList list = db.queryItemsByTel(Tel);
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
        rd.forward(request, response);
        
     }
    
    protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       
       String Tel = request.getParameter("Tel");
       String ID = request.getParameter("ID");
       String size = request.getParameter("size");
       db.delRecord(ID,size);
       ArrayList list = db.queryItemsByTel(Tel);
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/testShoppingCart.jsp"); 
        rd.forward(request, response);
     }
    
    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        // RequestDispatcher rd = request.getServletContext().getRequestDispatcher();
         response.sendRedirect("http://localhost:8080/ESDAssignment2/login/login.jsp");
    }
    
     protected void ListCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String Tel = request.getParameter("Tel");
        ArrayList list = db.queryItemsByTel(Tel);
        request.setAttribute("list", list);
        request.setAttribute("Tel", Tel);
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
