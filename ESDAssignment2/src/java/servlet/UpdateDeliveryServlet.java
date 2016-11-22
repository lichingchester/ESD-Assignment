
package servlet;

import db.OrdersDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a0321
 */
@WebServlet(name = "UpdateDeliveryServlet", urlPatterns = {"/UpdateDeliveryServlet"})
public class UpdateDeliveryServlet extends HttpServlet {
    OrdersDB db;

    public void init() {
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String url = this.getServletContext().getInitParameter("dbUrl");   
        db = new OrdersDB(url, username, password);  
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String OrderID=request.getParameter("OrderID");
            String dTime=request.getParameter("dTime");
            String dDate=request.getParameter("dDate");
            String action=request.getParameter("action");
           
           if ("edit".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer
            //db.editRecord
            // set the result into the attribute
            // redirect the result to the listCustomers.jsp	
            //            response.sendRedirect("list/main.jsp");
            //       RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/list/main.jsp"); 
     //      rd.forward(request, response);
           }else {
            //PrintWriter out = response.getWriter();
            out.println("No such action!!!");
           }
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
