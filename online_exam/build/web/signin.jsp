<%-- 
    Document   : signin
    Created on : Jul 2, 2019, 7:21:03 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.exam.student.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
    </head>


    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String ltype = request.getParameter("ltype");
            StudentDao dao = new StudentDao();
            if (ltype.equalsIgnoreCase("admin")) {
                if (dao.adminLogin(uname, pwd)) {
                    session.setAttribute("uname", uname);
                    response.sendRedirect("admin_Home.jsp");
                } else {
                    out.print("<script>alert('Please Enter Valid Login Details!')</script>");
                }
            } else {
                Integer stid = dao.login(uname, pwd);
                if (stid != null) {
                    session.setAttribute("stid", stid);
                    response.sendRedirect("studentHome.jsp");
                } else {
                    out.print("<script>alert('Please Enter Valid Login Details!')</script>");
                }
            }
        }
    %>


    <body>
        <%@include file="header.html" %>
        <%@include file="main_menu.html" %>
        <div style="width: 50%; margin-left: 25%; margin-top: 5%">
            <h1>Login Form</h1>
            <form action="signin.jsp" method="post" >
                <input class="field" type="text" name="uname" placeholder="Enter username" required="" autofocus=""/>
                <input class="field" type="password" name="pwd" placeholder="Enter password" required=""/>
                <input checked="" type="radio" name="ltype" value="Admin"/><span style="margin-left: 1%;">Admin</span>
                <input type="radio" name="ltype" value="Student"/><span style="margin-left: 1%;">Student</span>
                <input type="submit" value="Signin"/>
                <a href="signup.jsp">New Student</a>
            </form>
        </div>
    </body>
</html>
