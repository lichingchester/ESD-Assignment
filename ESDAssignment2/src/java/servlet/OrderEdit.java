/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.OrderBean;
import db.OrdersDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ken42
 */
@WebServlet(name = "OrderEdit", urlPatterns = {"/OrderEdit"})
public class OrderEdit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    OrdersDB odb;
    OrderBean ob;
    
    public void init(){
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String Url = this.getServletContext().getInitParameter("dbUrl"); 
        odb = new OrdersDB(Url, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ob=new OrderBean();
        ob.setOrderID(request.getParameter("orderID"));
        ob.setGroupID(request.getParameter("groupID"));
        ob.setItemID(request.getParameter("itemID"));
        ob.setSize(request.getParameter("size"));
        ob.setUserTel(request.getParameter("userTel"));
        ob.setDeliveryType(request.getParameter("deliveryType"));
        
        String dDate=request.getParameter("deliveryDate");
        java.sql.Date Date = java.sql.Date.valueOf(dDate);
        ob.setDeliveryDate(Date);
        ob.setDeliveryTime(Integer.parseInt(request.getParameter("deliveryTime")));
        ob.setDeliveryAddress(request.getParameter("deliveryAddress"));
        ob.setStatus(request.getParameter("status"));
        
        odb.editRecord(ob);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/manager/message/AdminShipMessage.jsp?message=editOrder"); 
            rd.forward(request, response);
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
