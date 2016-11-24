/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.ItemBean;
import bean.OrderBean;
import bean.UserBean;
import db.ItemsDB;
import db.OrdersDB;
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
 * @author ken42
 */
@WebServlet(name = "redeemServlet", urlPatterns = {"/redeemServlet"})
public class redeemServlet extends HttpServlet {
    UserDB db;
    UserBean ub;
    OrdersDB od;
    
    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB (dbUrl, dbUser, dbPassword);
        od = new OrdersDB(dbUrl, dbUser, dbPassword);
        //id = new ItemsDB(dbUrl, dbUser, dbPassword);
     }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       
        ArrayList<OrderBean> olist = od.queryOrders();
        String accessories=request.getParameter("accessories");
        String tel=request.getParameter("user");
        
        ub=db.queryItemByTel(tel);
        
        int ac=Integer.parseInt(accessories);
        int userBP=Integer.parseInt(ub.getBonusPoint());
        
        int cal=(userBP-ac);
        
        if(cal>=0){
            
            ub.setBonusPoint(String.valueOf(cal));
            db.editBonusPoint(ub);
            request.setAttribute("ub", ub);
            request.setAttribute("ol", olist);
//            response.sendRedirect("index.jsp?message=redeemOK");//redeem OK
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginHandler?mode=asd&Tel="+tel+"&message=redeemOK"); 
            rd.forward(request, response);
        }else{
            request.setAttribute("ub", ub);
            request.setAttribute("ol", olist);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginHandler?mode=asd&Tel="+tel+"&message=redeemFail"); 
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
