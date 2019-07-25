<%-- 
    Document   : admin_viewAllStudents
    Created on : Jul 4, 2019, 7:06:29 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.exam.student.StudentDao"%>
<%@page import="com.kulchuri.exam.student.StudentDto"%>
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
        <%@include  file="header.html" %>
        <%@include file="admin_menu.jsp" %>
        <div>
            <%
                ArrayList<StudentDto> al = new StudentDao().getAllStudents();
                if (al != null) {
            %>
            <h1 style="margin: 1%">List of Students</h1>
            <table id="customers">
                <tr>
                    <th>S.NO.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>D.O.B</th>
                    <th>Gender</th>
                    <th>Photo</th>
                    <th>Action</th>
                </tr>

                <%
                    int s = 0;
                    for (StudentDto dto : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getName()%></td>
                    <td><%=dto.getEmail()%></td>
                    <td><%=dto.getPwd()%></td>
                    <td><%=dto.getDob()%></td>
                    <td><%=dto.getGender()%></td>
                    <td>
                        <img src="data:image/jpeg;base64,<%=dto.getPhoto()%>" width="50" height="50">
                    </td>
                    <td>
                        <a>Edit</a>
                        <a>Delete</a>
                    </td>
                </tr>
                <%}%>
            </table>
            <%} else {%>
            <center><h1 style="color: red">No Student Available In Data Base</h1></center>
                <%}%>
        </div>
    </body>
</html>
