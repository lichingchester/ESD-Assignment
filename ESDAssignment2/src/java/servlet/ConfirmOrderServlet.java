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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConfirmOrderServlet", urlPatterns = {"/ConfirmOrderServlet"})
public class ConfirmOrderServlet extends HttpServlet {
    
    OrdersDB od;
    OrderBean ob;
    
    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        od = new OrdersDB(dbUrl, dbUser, dbPassword);
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ArrayList list = (ArrayList) request.getSession().getAttribute("list");
        List myList = (List)request.getAttribute("arrayList");
        String GroupID;
        int lastGroupID, orderTotal=0,BonusPoints;
        double doubleBonusPoints;
        if(od.queryLastGroupID()==null){
            GroupID="1";
        }else{
            lastGroupID=Integer.parseInt(od.queryLastGroupID());
            lastGroupID++;
            GroupID=String.valueOf(lastGroupID);
        }
        
        for(int i=0;i<myList.size();i++){
            String orderId;
            int lastID;
            if(od.queryLastOrderID()==null){
                orderId="1";
            }else{
                lastID=Integer.parseInt(od.queryLastOrderID());
                lastID++;
                orderId=String.valueOf(lastID);
            }//set orderId
            
        }
        if(orderTotal>=2000){
            doubleBonusPoints=(orderTotal*0.05);
            BonusPoints=(int)doubleBonusPoints;
        }
        if(orderTotal>=10000){
            //cookie 24hour >>>pay $500
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
