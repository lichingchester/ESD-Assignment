<!DOCTYPE html>
<!-- 
emmet key
http://docs.emmet.io/abbreviations/syntax/

free image download
https://www.pexels.com/photo/street-car-vehicle-blur-1459/

colour physiological
https://buzzorange.com/techorange/2015/05/26/color/ 
-->

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- css import-->
        <link rel="stylesheet" href="css/style.css">
        
        <%
            if(request.getParameter("message") != null){
                if(request.getParameter("message").equals("signup")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Sign up seccuss');");
                    /*out.println("location='index.jsp';");*/
                    out.println("</script>");
                }
            }
            String Tel = null;
        %>
        
    </head>
    <body class="cover-page">
        <section class="logo">
            <div class="brand2">
                <a href="#home" class="brand-name"><font id="font-red">C</font>&<font id="font-red">F</font> <font id="font-red">D</font>ress</a>
            </div>
        </section>
        
       <div class="index-center">
           <div class="index-center-left">
               <!--fucking wrong in here!!!-->
               <!--fucking wrong in here!!!-->
               <!--fucking wrong in here!!!-->
               <!--fucking wrong in here!!!-->
<!--               <form action="ItemsServlet" method="get">
                   <input type="hidden" name="action" value="list" />
                   <input type="submit" class="cover-btn" style="vertical-align: middle" value="Let's get your amazing clothes!" />
               </form>-->
                <a href="ItemsServlet?action=list&Tel=<%=Tel%>" class="a-white">
                    <button class="cover-btn" style="vertical-align:middle">
                             <span>Let's get your amazing clothes!</span>
                    </button>
                </a>

           </div>
           <div class="index-center-right">
               <a href="login/login.jsp">
                    <button class="cover-btn cover-btn2" style="vertical-align:middle">
                         <span>Login</span>
                     </button>
               </a>
               <a href="register.jsp">
               <button class="cover-btn cover-btn2" style="vertical-align:middle">
                    <span>Sign Up</span>
                </button>
               
             
              <!-- <a href="testList.jsp">
               <button class="cover-btn cover-btn2" style="vertical-align:middle">
                    <span>CartList</span>
                </button>
               </a>-->
               
               
           </div>
       </div>
    </body>
</html>
