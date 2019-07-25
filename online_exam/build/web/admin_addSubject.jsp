<%-- 
    Document   : signin
    Created on : Jul 2, 2019, 7:21:03 AM
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
        <jsp:useBean id="dao" class="com.kulchuri.exam.subject.SubjectDao"></jsp:useBean>
        <%
            if (request.getMethod().equalsIgnoreCase("post")) {
        %>
        <jsp:useBean id="dto" class="com.kulchuri.exam.subject.SubjectDto"></jsp:useBean>
        <jsp:setProperty name="dto" property="*"></jsp:setProperty>
        <%
                dao.addSubject(dto);
            }
        %>
        <div style="width: 50%; margin-left: 25%; margin-top: 1%">
            <h1>Add New Subject Form</h1>
            <form action="admin_addSubject.jsp" method="post" >
                <input class="field" type="text" name="name" placeholder="Enter subject name" required="" autofocus=""/>
                <input type="submit" value="Add"/>
            </form>
        </div>

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
