/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import bean.User;
import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ken42
 */
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController extends HttpServlet {
    
    private UserDB db;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         doPost(request, response);
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
        String action =request.getParameter("action");
        if(!isAuthenticated(request)&&
                !("authenticate").equals(action)){
            doLogin(request, response);
            } 
        if("authenticate").equals(action)){
                doAuthenticate(request, response);
        }else if ("logout".equals(action)){
                doLogout(request, response);
                }
                else{
                response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
                }
    }  

    
    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username=request.getParameter("id");
        String password=request.getParameter("pw");
        String targetURL;
        boolean isValid=db.isValidUser(username, password);
        if("abc".equals(username)&&"123".equals(password)){
            HttpSession session=request.getSession(true);
            User bean =new User();
            bean.setId(username);
            bean.setPw(password);
            //store the userInfo to the session
            session.setAttribute("User", bean);
            targetURL="/welcome.jsp";
        }else{
            targetURL="/loginError.jsp";
        }
        RequestDispatcher rd;
        rd=getServletContext().getRequestDispatcher("/"+targetURL);
        rd.forward(request,response);
    }
    
    private boolean isAuthenticated (HttpServletRequest request, HttpServletResponse response){
        boolean result=false;
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            result=true;
        }
        return result;
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String targetURL="login.jsp";
        
        RequestDispatcher rd;
        rd=getServletContext().getRequestDispatcher("/"+targetURL);
        rd.forward(request,response);
    }
    
        private void doLogout (HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(false);
        if(session!=null){
           //remove the Attribute from session
           session.removeAttribute("User");
           //invalidate the session
           session.invalidate();
        }
        doLogout(request,response);
    }
        
    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB (dbUrl, dbUser, dbPassword); 
            }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
