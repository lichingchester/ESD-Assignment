/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.ItemsDB;
import db.OrdersDB;
import db.UserDB;
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
 * @author lichi
 */
@WebServlet(name = "startup", urlPatterns = {"/startup"})
public class startup extends HttpServlet {

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
        
        OrdersDB odb = new OrdersDB (dbUrl, dbUser, dbPassword);
        odb.createOrderTable();
        odb.addRecord("001", "1", "1", "87654321", "M", "2", "2016-11-22", 5, "Flat2402", "deliverying", 2);
        odb.addRecord("002", "1", "2", "12345678", "M", "2", "2016-11-22", 5, "Flat2402", "canceled", 2);
        
       // INSERT INTO APP.ORDERS (ORDERID, ITEMID, USERTEL, "SIZE", DELIVERYTYPE, DELIVERYDATE, DELIVERYTIME, DELIVERYADDRESS, STATUS) 
	//VALUES ('001', '1', '1', '1', '1', '2016-11-22', CURRENT_TIME, '12', '12')
       // odb.addRecord("002","001","23237964","size","deliveryType","18-06-12","7:00:00 AM","fuck","available");
        
        UserDB udb = new UserDB (dbUrl, dbUser, dbPassword);
        udb.createCustTable();
        
        udb.addRecord("admin", "admin", "Chester", "68916799", "chester@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 2);
        udb.addRecord("", "", "Amon", "12345678", "amon@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 0);
        udb.addRecord("robot", "robot", "Robot", "87654321", "robot@gmail.com", "1679 DUI YOU HSE, FUK KIL EST, TIN TIN DUI, NT", 0, 0);
        
        ItemsDB idb = new ItemsDB(dbUrl, dbUser, dbPassword);  
        idb.dropItemsTable();
        idb.createItemsTable();
        
//        long dress
        idb.addRecord("item001", "Brown dress", "Long dress for party", 
                "long", "Chester Li", 599, "img/long/lng001.jpg");
        idb.addRecord("item002", "White dress", "Long dress for party", 
                "long", "Enriqueta Como", 230, "img/long/lng002.jpg");
        idb.addRecord("item003", "Colorful dress", "Long dress for wedding", 
                "long", "Meda Germaine", 167, "img/long/lng003.jpg");
        idb.addRecord("item004", "Red dress", "Long dress for travel", 
                "long", "Meda Germaine", 1099, "img/long/lng004.jpg");
        idb.addRecord("item005", "Red dress", "Long dress for travel", 
                "long", "Antwan Potter", 689, "img/long/lng005.jpg");
    
//        middle dress
        idb.addRecord("item006", "Black dress", "Middle dress for party", 
                "middle", "Enriqueta Como", 1000, "img/middle/mid001.jpg");
        idb.addRecord("item007", "White dress", "Middle dress for party", 
                    "middle", "Enriqueta Como", 520, "img/middle/mid002.jpg");
        idb.addRecord("item008", "Yellow dress", "Middle dress for wedding", 
                    "middle", "Harriet Scicchitano", 1000, "img/middle/mid003.jpg");
        idb.addRecord("item009", "Brown dress", "Middle dress for travel", 
                    "middle", "Katharyn Smalling", 3999, "img/middle/mid004.jpg");
        idb.addRecord("item010", "White dress", "Middle dress for travel", 
                    "middle", "Clarinda Ardrey ", 350, "img/middle/mid005.jpg");
    
//        short dress
        idb.addRecord("item011", "White dress", "Middle dress for party", 
                "short", "Enriqueta Como", 560, "img/short/sht001.jpg");
        idb.addRecord("item012", "White dress", "Middle dress for party", 
                    "short", "Enriqueta Como", 689, "img/short/sht002.jpg");
        idb.addRecord("item013", "Yellow dress", "Middle dress for wedding", 
                    "short", "Harriet Scicchitano", 689, "img/short/sht003.jpg");
        idb.addRecord("item014", "Brown dress", "Middle dress for travel", 
                    "short", "Katharyn Smalling", 689, "img/short/sht004.jpg");
        idb.addRecord("item015", "White dress", "Middle dress for travel", 
                    "short", "Clarinda Ardrey ", 999, "img/short/sht005.jpg");
        
    //        sheath dress
        idb.addRecord("item016", "Deep Blue dress", "Sheath dress for party", 
                "sheath", "Enriqueta Como", 560, "img/sheath/shh001.jpg");
        idb.addRecord("item017", "Blue dress", "Sheath dress for party", 
                    "sheath", "Enriqueta Como", 786, "img/sheath/shh002.jpg");
        idb.addRecord("item018", "White dress", "Sheath dress for wedding", 
                    "sheath", "Harriet Scicchitano", 344, "img/sheath/shh003.jpg");
        idb.addRecord("item019", "White dress", "Sheath dress for travel", 
                    "sheath", "Katharyn Smalling", 8000, "img/sheath/shh004.jpg");
        idb.addRecord("item020", "Red dress", "Sheath dress for travel", 
                    "sheath", "Clarinda Ardrey ", 999, "img/sheath/shh005.jpg");
    
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp"); 
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
