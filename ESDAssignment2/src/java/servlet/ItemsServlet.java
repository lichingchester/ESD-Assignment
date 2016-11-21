/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.ItemBean;
import db.ItemsDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lichingchester
 */
@WebServlet(name = "ItemsServlet", urlPatterns = {"/ItemsServlet"})
public class ItemsServlet extends HttpServlet {
    ItemsDB db;
    ItemBean ib;
    
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
        String url = this.getServletContext().getInitParameter("dbUrlitems");   
        db = new ItemsDB(url, username, password);  
        
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
//            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
            rd.forward(request, response);
 
        }
        else if("itemdetail".equalsIgnoreCase(action)){
            // call the query db to get retrieve for all customer
            ArrayList detail = db.queryItems();
            // set the result into the attribute
            request.setAttribute("detail", detail);
            String name=request.getParameter("name");
            request.setAttribute("name", name);
            // redirect the result to the listCustomers.jsp	
            //            response.sendRedirect("list/main.jsp");
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/itemdetail.jsp"); 
            rd.forward(request, response);
        }
        else if ("edit".equalsIgnoreCase(action)) {
            //get the id from request
            String itemID = request.getParameter("itemID");
            //get the customer record by Id
            ib = db.queryItemByID(itemID);
            // set the result into the attribute
            request.getSession().setAttribute("list", ib);	
            // redirect the result to the editCustomerById.jsp
            response.sendRedirect("index.jsp");
        }        
        else if ("add".equalsIgnoreCase(action)) {
            // redirect the result to the addCustomer.jsp
            response.sendRedirect("manage/addItem.jsp");
        }        
        else if ("delete".equalsIgnoreCase(action)) {
            //get the id from request
            String itemID = request.getParameter("itemID");
            if (itemID != null) {
                //delete record
                int result = db.delRecord(itemID);
                // reload data and update into the attribute
                // redirect the result to the listCustomers.jsp
                request.getSession().setAttribute("list", ib);	
                response.sendRedirect("index.jsp");
            }

        } else if ("searchByName".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            String itemName = request.getParameter("itemName");
            if (itemName != null) {
                // set the result into the attribute
                ArrayList list = db.queryItemsByName(itemName);
                request.setAttribute("list", list);
                // redirect the result to the listCustomers.jsp
                request.getSession().setAttribute("list", list);	
                response.sendRedirect("index.jsp");
            }
        } else if ("searchByCategory".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            String category = request.getParameter("category");
            
            if (category != null) {
                // set the result into the attribute
                ArrayList list = db.queryItemsByName(category);
                // redirect the result to the listCustomers.jsp
                request.getSession().setAttribute("list", list);	
                response.sendRedirect("/list/main.jsp");
                
               // RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
               //  rd.forward(request, response);
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
