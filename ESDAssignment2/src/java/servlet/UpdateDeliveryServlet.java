package servlet;

import bean.OrderBean;
import db.OrdersDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Time;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   // DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
    OrdersDB db;

    public void init() {
        String username = this.getServletContext().getInitParameter("dbUser");
        String password = this.getServletContext().getInitParameter("dbPassword");
        String url = this.getServletContext().getInitParameter("dbUrl");   
        db = new OrdersDB(url, username, password);  
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            String OrderID=request.getParameter("orderID");
            
           // DateFormat tf = new SimpleDateFormat("hh:mm");
            String dTime=request.getParameter("dTime");
            Time Time =java.sql.Time.valueOf(dTime);
            
            
            //DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
            String dDate=request.getParameter("dDate");
            java.sql.Date Date = java.sql.Date.valueOf(dDate);
            
            String size=request.getParameter("size");
            int qty=parseInt(request.getParameter("qty"));
            
            String action=request.getParameter("action");
            
            OrderBean ob = new OrderBean();
            ob.setDeliveryTime(Time);
            ob.setDeliveryDate(Date);
            ob.setSize(size);
            ob.setQuantity(qty);
            
           
           if ("edit".equalsIgnoreCase(action)) {
            db.editRecord(ob);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/HIHI.jsp"); 
            rd.forward(request, response);
           }else {
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateDeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateDeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
