package servlet;

import bean.OrderBean;
import db.OrdersDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            
            String OrderID=request.getParameter("orderID");
            String dTime= request.getParameter("dTime");
            int time =parseInt(dTime);
            
            String dDate=request.getParameter("dDate");
            DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
            Date d = (dateformat.parse(dDate));
            java.sql.Date d1 =(java.sql.Date) d;

            String size=request.getParameter("size");
            int qty=parseInt(request.getParameter("qty"));
            
            OrderBean ob = new OrderBean();
            ob.setDeliveryTime(time);
            ob.setDeliveryDate(d1);
            ob.setSize(size);
            ob.setQuantity(qty);
            ob.setOrderID(OrderID);

            db.editRecord(ob);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/UpdateDelivery.jsp"); 
            rd.forward(request, response);

        }
        catch(Exception e){
        e.getMessage();
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
