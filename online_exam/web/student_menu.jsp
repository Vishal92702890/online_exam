<%-- 
    Document   : student_menu
    Created on : Jul 11, 2019, 7:27:29 AM
    Author     : DELL
--%>
<%
    Integer stid = (Integer) session.getAttribute("stid");
    if (stid == null) {
        response.sendRedirect("signin.jsp");
    }
%>
<ul>
    <li><a href="studentHome.jsp">Home</a></li>
    <li><a href="studentSelectSubject.jsp">Exam</a></li>
    <li><a href="studentResult.jsp">Result</a></li>
    <li><a href="signout.jsp?opn=0">Signout</a></li>
</ul>
