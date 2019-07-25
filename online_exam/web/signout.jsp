<%-- 
    Document   : signout
    Created on : Jul 11, 2019, 7:14:49 AM
    Author     : DELL
--%>
<%
    String opn = request.getParameter("opn");
    if (opn.equalsIgnoreCase("1")) {
        session.removeAttribute("uname");
    } else if (opn.equalsIgnoreCase("0")) {
        session.removeAttribute("stid");
    }
    response.sendRedirect("signin.jsp");
%>