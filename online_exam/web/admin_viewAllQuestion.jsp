<%-- 
    Document   : admin_viewAllSubjects
    Created on : Jul 5, 2019, 7:27:23 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.exam.question.QuestionDto"%>
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
        <jsp:useBean id="dao" class="com.kulchuri.exam.question.QuestionDao"></jsp:useBean>
        <%@include file="header.html" %>
        <%@include file="admin_menu.jsp" %>
        <div>
            <%
                ArrayList<QuestionDto> al = dao.getAllQuestions();
                if (al != null) {
            %>
            <h1 style="margin: 1%">List of Questions</h1>
            <table id="customers">
                <tr>
                    <th>S.No.</th>
                    <th>Question</th>
                    <th>Option 1</th>
                    <th>Option 2</th>
                    <th>Option 3</th>
                    <th>Option 4</th>
                    <th>Answer</th>
                    <th>Action</th>
                </tr>
                <%
                    int s = 0;
                    for (QuestionDto dto : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getQuestion()%></td>
                    <td><%=dto.getOption1()%></td>
                    <td><%=dto.getOption2()%></td>
                    <td><%=dto.getOption3()%></td>
                    <td><%=dto.getOption4()%></td>
                    <td><%=dto.getAnswer()%></td>
                    <td>
                        <a>Edit</a>
                        <a>Delete</a>
                    </td>

                </tr>
                <%}%>
            </table>
            <%} else {%>
            <center>
                <h1>No Questions</h1>
            </center>
            <%}%>
        </div>


    </body>
</html>
