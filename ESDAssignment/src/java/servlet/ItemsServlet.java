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
import java.util.ArrayList;
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
        String url = this.getServletContext().getInitParameter("dbUrl");   
        db = new ItemsDB(url, username, password);  
        db.createItemsTable();
        System.out.println("table created");
        
//        long dress
        db.addRecord("item001", "Brown dress", "Long dress for party", 
                "long", "Chester Li", 599, "ESDAssignment/img/long/lng001.jpg", "M");
        db.addRecord("item002", "White dress", "Long dress for party", 
                "long", "Enriqueta Como", 230, "ESDAssignment/img/long/lng002.jpg", "L");
        db.addRecord("item003", "Colorful dress", "Long dress for wedding", 
                "long", "Meda Germaine", 167, "ESDAssignment/img/long/lng003.jpg", "M");
        db.addRecord("item004", "Red dress", "Long dress for travel", 
                "long", "Meda Germaine", 1099, "ESDAssignment/img/long/lng004.jpg", "XL");
        db.addRecord("item005", "Red dress", "Long dress for travel", 
                "long", "Antwan Potter", 689, "ESDAssignment/img/long/lng005.jpg", "S");
    
//        middle dress
        db.addRecord("item006", "Black dress", "Middle dress for party", 
                "middle", "Enriqueta Como", 1000, "ESDAssignment/img/long/mid001.jpg", "XS");
        db.addRecord("item007", "White dress", "Middle dress for party", 
                    "middle", "Enriqueta Como", 520, "ESDAssignment/img/long/mid002.jpg", "S");
        db.addRecord("item008", "Yellow dress", "Middle dress for wedding", 
                    "middle", "Harriet Scicchitano", 1000, "ESDAssignment/img/long/mid003.jpg", "XL");
        db.addRecord("item009", "Brown dress", "Middle dress for travel", 
                    "middle", "Katharyn Smalling", 3999, "ESDAssignment/img/long/mid004.jpg", "M");
        db.addRecord("item010", "White dress", "Middle dress for travel", 
                    "middle", "Clarinda Ardrey ", 350, "ESDAssignment/img/long/mid005.jpg", "M");
    
//        short dress
        db.addRecord("item011", "White dress", "Middle dress for party", 
                "middle", "Enriqueta Como", 560, "ESDAssignment/img/long/sht001.jpg", "XS");
        db.addRecord("item012", "White dress", "Middle dress for party", 
                    "middle", "Enriqueta Como", 689, "ESDAssignment/img/long/sht002.jpg", "S");
        db.addRecord("item013", "Yellow dress", "Middle dress for wedding", 
                    "middle", "Harriet Scicchitano", 689, "ESDAssignment/img/long/sht003.jpg", "XXL");
        db.addRecord("item014", "Brown dress", "Middle dress for travel", 
                    "middle", "Katharyn Smalling", 689, "ESDAssignment/img/long/sht004.jpg", "M");
        db.addRecord("item015", "White dress", "Middle dress for travel", 
                    "middle", "Clarinda Ardrey ", 999, "ESDAssignment/img/long/sht005.jpg", "M");
        
    //        sheath dress
        db.addRecord("item016", "Deep Blue dress", "Sheath dress for party", 
                "middle", "Enriqueta Como", 560, "ESDAssignment/img/long/shh001.jpg", "XL");
        db.addRecord("item017", "Blue dress", "Sheath dress for party", 
                    "middle", "Enriqueta Como", 786, "ESDAssignment/img/long/shh002.jpg", "S");
        db.addRecord("item018", "White dress", "Sheath dress for wedding", 
                    "middle", "Harriet Scicchitano", 344, "ESDAssignment/img/long/shh003.jpg", "XXS");
        db.addRecord("item019", "White dress", "Sheath dress for travel", 
                    "middle", "Katharyn Smalling", 8000, "ESDAssignment/img/long/shh004.jpg", "M");
        db.addRecord("item020", "Red dress", "Sheath dress for travel", 
                    "middle", "Clarinda Ardrey ", 999, "ESDAssignment/img/long/shh005.jpg", "M");
    
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
            request.getSession().setAttribute("list", list);
            // redirect the result to the listCustomers.jsp	
            response.sendRedirect("index.jsp");
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
                request.setAttribute("list", list);
                // redirect the result to the listCustomers.jsp
                request.getSession().setAttribute("list", list);	
                response.sendRedirect("index.jsp");
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
