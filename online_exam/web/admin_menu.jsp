<%-- 
    Document   : admin_menu
    Created on : Jul 11, 2019, 7:11:26 AM
    Author     : DELL
--%>
<%
    String uname = (String) session.getAttribute("uname");
    if (uname == null) {
        response.sendRedirect("signin.jsp");
    }
%>


<ul>
    <li><a href="admin_Home.jsp">Home</a></li>
    <li><a href="admin_addSubject.jsp">Add Subject</a></li>
    <li><a href="admin_viewAllSubjects.jsp">View Subjects</a></li>
    <li><a href="admin_addQuestion.jsp">Add Question</a></li>
    <li><a href="admin_viewAllQuestion.jsp">View Questions</a></li>
    <li><a href="admin_viewAllStudents.jsp">View Students</a></li>
    <li><a href="signout.jsp?opn=1">Signout</a></li>
</ul>