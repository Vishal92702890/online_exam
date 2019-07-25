<%-- 
    Document   : studentSelectSubject
    Created on : Jul 8, 2019, 4:05:47 AM
    Author     : DELL
--%>
<%@page import="com.kulchuri.exam.question.QuestionDao"%>
<%@page import="com.kulchuri.exam.question.QuestionDto"%>
<%@page import="com.kulchuri.exam.subject.SubjectDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kulchuri.exam.subject.SubjectDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="header.html" %>
        <%@include file="student_menu.jsp" %>

        <div style="width: 50%; margin-left: 25%; margin-top: 1%">

            <%
                if (request.getMethod().equalsIgnoreCase("post")) {
                    String sid = request.getParameter("sid");
                    ArrayList<QuestionDto> al = new QuestionDao().getAllQuestionsBySubjects(Integer.parseInt(sid));
                    if (al != null) {
                        session.setAttribute("al", al);
                        session.setAttribute("sid", sid);
                        response.sendRedirect("studentExam.jsp");
                    } else {
            %>
            <center>
                <script>
                    alert("There is no questions in database");
                </script>
            </center>
            <%
                    }
                }
            %>
            <h1>Select Subject For Exam</h1>
            <form action="studentSelectSubject.jsp" method="post" >
                <%
                    ArrayList<SubjectDto> al = new SubjectDao().getAllSubjects();
                    if (al != null) {
                %>
                <select class="field" name="sid" required="">
                    <option value="">---Select Subject---</option>
                    <%
                        for (SubjectDto sd : al) {
                    %>
                    <option value="<%=sd.getSid()%>"><%=sd.getName()%></option>
                    <%}%>
                </select>
                <input type="submit" value="Submit"/>
                <%} else {%>
                <h1>No Subjects</h1>
                <%}%>
            </form>
        </div>
    </body>
</html>
