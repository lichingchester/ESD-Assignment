/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author chingli
 */
@WebServlet(name = "ItemUpload", urlPatterns = {"/ItemUpload"})
public class ItemUpload extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            File uploads = null; 
            String name = request.getParameter("name");
            String desc = request.getParameter("desc");
            String cty = request.getParameter("cty");
            String dname = request.getParameter("dname");
            String size = request.getParameter("size");
            Double price = Double.parseDouble(request.getParameter("price"));
            Part filePart = request.getPart("file"); 
            
            String fileName = extractFileName(filePart);
            if(cty.equals("long")){
                uploads = new File("/img/long");
            }else if(cty.equals("middle")){
                uploads = new File("/img/middle");
            }else if(cty.equals("short")){
                uploads = new File("/img/short");
            }else if(cty.equals("sheath")){
                uploads = new File("/img/sheath");
            }
            try (InputStream input = filePart.getInputStream()) {
                File file = new File(uploads, fileName+".jpg");
                Files.copy(input, file.toPath());
            }
            
            //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//            InputStream fileContent = filePart.getInputStream();
        }
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet test</title>");            
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Add Item success</h1>");
//        out.println("</body>");
//        out.println("</html>");
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
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
