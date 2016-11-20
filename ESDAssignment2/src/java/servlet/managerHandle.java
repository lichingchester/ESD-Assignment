/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.ItemBean;
import bean.UserBean;
import db.ItemsDB;
import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lichi
 */
@WebServlet(name = "managerHandle", urlPatterns = {"/managerHandle"})
public class managerHandle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UserDB udb;
    ItemsDB idb;
    UserBean ub;
    ItemBean ib;
    
    public void init(){
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String userUrl = this.getServletContext().getInitParameter("dbUrluser");   
        String itemUrl = this.getServletContext().getInitParameter("dbUrlitems");   
        udb = new UserDB(userUrl, username, password);
        idb = new ItemsDB(itemUrl, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        
        if ("users".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = udb.queryUsersByConfirmed();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/AdminShip.jsp"); 
            rd.forward(request, response);
 
        }else if ("ncusers".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = udb.queryUsersByUnconfirmed();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/AdminShip.jsp"); 
            rd.forward(request, response);
 
        }else if ("item".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = idb.queryItems();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/ItemsManage.jsp"); 
            rd.forward(request, response);
 
        }else if ("itemByName".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            // call the query db to get retrieve for all customer
            ArrayList list = idb.queryItemsByName(name);
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/ItemsManage.jsp"); 
            rd.forward(request, response);
 
        }else if ("itemByCty".equalsIgnoreCase(action)) {
            String cty = request.getParameter("cty");
            // call the query db to get retrieve for all customer
            ArrayList list = idb.queryItemsByName(cty);
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/ItemsManage.jsp"); 
            rd.forward(request, response);
 
        }else if ("orderps".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = db.queryItems();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
            rd.forward(request, response);
 
        }else if ("orderhis".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = db.queryItems();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
            rd.forward(request, response);
 
        }else if ("report".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = db.queryItems();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
            rd.forward(request, response);
 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}