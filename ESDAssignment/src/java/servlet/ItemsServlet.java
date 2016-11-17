/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.ItemsDB;
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
@WebServlet(name = "itemsServlet", urlPatterns = {"/itemsServlet"})
public class ItemsServlet extends HttpServlet {
    ItemsDB db;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init() {
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String url = this.getServletContext().getInitParameter("dbUrl");   
        db = new ItemsDB(url, username, password);  
        db.createItemsTable();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        System.out.println("action:"+action);

        if ("list".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ArrayList list = db.queryItems();
            // set the result into the attribute
            request.setAttribute("list", list);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        else if ("editById".equalsIgnoreCase(action)) {
			//get the id from request
			............
			//get the customer record by Id
			............
			// set the result into the attribute
            ............
            // redirect the result to the editCustomerById.jsp
			............
        }        
        else if ("add".equalsIgnoreCase(action)) {
			// redirect the result to the addCustomer.jsp
			............
        }        
        else if ("delete".equalsIgnoreCase(action)) {
            //get the id from request
            ............
            if (id != null) {
				//delete record
                ............
                // reload data and update into the attribute
                // redirect the result to the listCustomers.jsp
				............
            }

        } else if ("search".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            ............
            if (name != null) {
                // set the result into the attribute
                // redirect the result to the listCustomers.jsp
                ............
            }
        } 
        else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
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
