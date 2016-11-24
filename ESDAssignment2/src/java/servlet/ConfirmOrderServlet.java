/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.CartListBean;
import bean.OrderBean;
import bean.UserBean;
import db.OrdersDB;
import db.ShoppingCartDB;
import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConfirmOrderServlet", urlPatterns = {"/ConfirmOrderServlet"})
public class ConfirmOrderServlet extends HttpServlet {
    
    OrdersDB od;
    OrderBean ob;
    UserDB ud;
    UserBean ub;
    ShoppingCartDB scd;
    
    
    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        od = new OrdersDB(dbUrl, dbUser, dbPassword);
        ud = new UserDB(dbUrl, dbUser, dbPassword);
        scd= new ShoppingCartDB(dbUrl, dbUser, dbPassword);
        
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String tel = (String) request.getSession().getAttribute("TestShoppingCartTel");
        ArrayList<CartListBean> list = (ArrayList) request.getSession().getAttribute("list");
        String choose=request.getParameter("choose");
        
        String inputDate = "";
        if(request.getParameter("inputDate") != null || !request.getParameter("inputDate").equals("")){
            inputDate = request.getParameter("inputDate");
        }
        
        int inputTime = 0;
        if(!request.getParameter("inputTime").equals("")){
            inputTime = Integer.parseInt(request.getParameter("inputTime"));
        }
       // List myList = (List)request.getAttribute("list");
       
        
        String tempItemID,tempName,tempPrice,tempQua,tempSize;
        String  deliveryType, deliveryDate, deliveryTime, deliveryAddress, status;
        int lastGroupID=0;int lastOrderID=0;
        int orderTotal=0,BonusPoints;
        double doubleBonusPoints;
        if(od.queryLastGroupID()==null){
            lastGroupID=1;
        }else{
            lastGroupID=Integer.parseInt(od.queryLastGroupID());
            lastGroupID++;
        }
        
        for(CartListBean tempBean:list){//get CartListBean

            
            
            //set orderId
            for(int i=0;i<list.size();i++){
                String orderId;
                if(od.queryLastOrderID()==null){
                    orderId="1";
                }else{
                    lastOrderID=Integer.parseInt(od.queryLastOrderID());
                    lastOrderID++;
                }
            }
            
            tempItemID=tempBean.getItemID();
            tempName=tempBean.getName();
            tempPrice=tempBean.getPrice();
            tempQua=tempBean.getQuantity();
            tempSize=tempBean.getSize();
            if(choose.equals("delivery")){
                deliveryType="delivery";
                ub=ud.queryItemByTel(tel);
                deliveryAddress=ub.getAddress();
                od.addRecord(lastOrderID, lastGroupID, tempItemID, tel, tempSize, deliveryType, inputDate, inputTime, deliveryAddress, "deliverying",Integer.parseInt(tempQua));
            }else{
                ub=ud.queryItemByTel(tel);
                deliveryType="selfPick";
                od.addRecord(lastOrderID, lastGroupID, tempItemID, tel, tempSize, deliveryType, null, 0, "shop", "deliverying",Integer.parseInt(tempQua));
            }

            scd.delRecord(tel);
   
        }
        
        if(orderTotal>=2000){
            doubleBonusPoints=(orderTotal*0.05);
            BonusPoints=(int)doubleBonusPoints;
        }
        if(orderTotal>=10000){
            //cookie 24hour >>>pay $500
        }
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ItemsServlet?action=list&Tel="+ub.getTel()+"&Uname="+ub.getName()); 
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
