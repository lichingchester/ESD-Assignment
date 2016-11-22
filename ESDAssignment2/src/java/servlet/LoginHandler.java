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
 * @author lichi
 */
@WebServlet(name = "LoginHandler", urlPatterns = {"/LoginHandler"})
public class LoginHandler extends HttpServlet {
    
    UserDB db;
    UserBean ub;
    OrdersDB od;
    ItemsDB id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB (dbUrl, dbUser, dbPassword);
        od = new OrdersDB(dbUrl, dbUser, dbPassword);
        id = new ItemsDB(dbUrl, dbUser, dbPassword);
     }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String loginname = request.getParameter("username");
        String loginpwd = request.getParameter("password");
        String username = "";
        String userpwd = "";
        String url = "";

        ArrayList<UserBean> list = db.queryItems();
        ArrayList<OrderBean> olist = od.queryOrders();
        ArrayList<ItemBean> ilist = id.queryItems();

        for(UserBean ub : list){
            username = ub.getUsername();
            userpwd = ub.getPassword();
            if(loginname.equals(username)){
                if(loginpwd.equals(userpwd)){
                    if(ub.getUsername().equals("admin")){
                        request.setAttribute("userBean", ub);
                        request.setAttribute("itemsList", ilist);
                        url = "/manager/AdminShip.jsp";
                        break;
                    }else{
                        request.setAttribute("userBean", ub);
                        request.setAttribute("orderList", olist);
                        url = "/MemberShip.jsp";
    //                    request.getSession().setAttribute("userBean", ub);	
                        break;
                    }
                }
            }
            url="/login/loginError.jsp";
        }

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url); 
        rd.forward(request, response);
        
//        response.sendRedirect("MemberShip.jsp");

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
