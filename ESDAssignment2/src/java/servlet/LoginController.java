/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.UserBean;
import bean.UserInfo;
import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private UserDB db;
    private ArrayList loginList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (!isAuthenticated(request)
                && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }

    }  

    
    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String targetURL="login/login.jsp";
        
        loginList=db.queryItems();
       
        for(int i=0;i<loginList.size();i++){
            if(username.equals(((UserBean) loginList.get(i)).getUsername())
                   &&password.equals(((UserBean) loginList.get(i)).getPassword())){
            //HttpSession session=request.getSession(true);
            //UserInfo bean =new UserInfo();
            //bean.setUsername(username);
            //bean.setPassword(password);
            //store the userInfo to the session
            //session.setAttribute("userInfo", bean);
           targetURL="login/welcome.jsp";
            }else{
            targetURL="login/loginError.jsp";
        }
        }

        RequestDispatcher rd;
        rd=getServletContext().getRequestDispatcher("/"+targetURL);
        rd.forward(request,response);
    }
    
    private boolean isAuthenticated(HttpServletRequest request){
        boolean result=false;
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")!=null){
            result=true;
        }
        return result;
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String targetURL="login/login.jsp";
        
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
        String dbUrl = this.getServletContext().getInitParameter("dbUrluser");
        db = new UserDB (dbUrl, dbUser, dbPassword); 
            }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
