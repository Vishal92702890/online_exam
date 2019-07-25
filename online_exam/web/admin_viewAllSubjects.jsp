<%-- 
    Document   : admin_viewAllSubjects
    Created on : Jul 11, 2019, 7:13:11 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.exam.subject.SubjectDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.html" %>
        <%@include file="admin_menu.jsp" %>
        <jsp:useBean id="dao" class="com.kulchuri.exam.subject.SubjectDao"/>
        <div style="width: 50%; margin-left: 25%">
            <%
                ArrayList<SubjectDto> al = dao.getAllSubjects();
                if (al != null) {
            %>
            <h1 style="margin: 2%">List of Subjects</h1>
            <table id="customers">
                <tr>
                    <th>S.No.</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
                <%
                    int s = 0;
                    for (SubjectDto sd : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=sd.getName()%></td>
                    <td>
                        <a>Edit</a>
                        <a>Delete</a>
                    </td>
                </tr>
                <%}%>
            </table>
            <%} else {%>
            <center><h1 style="color: red">No Subject in Data Base</h1></center>
                <%}%>
        </div>
    </body>
</html>
