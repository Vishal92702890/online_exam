<%-- 
    Document   : studentSignout
    Created on : Jul 8, 2019, 4:12:12 AM
    Author     : DELL
--%>
<%
    Integer stid = (Integer) session.getAttribute("stid");
    if (stid != null) {
        response.sendRedirect("login.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>