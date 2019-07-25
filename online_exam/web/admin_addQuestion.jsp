<%@page import="com.kulchuri.exam.subject.SubjectDao"%>
<%@page import="com.kulchuri.exam.subject.SubjectDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator"%>
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
        <%
            if (request.getMethod().equalsIgnoreCase("post")) {
        %>
        <jsp:useBean id="dto" class="com.kulchuri.exam.question.QuestionDto"></jsp:useBean>
        <jsp:setProperty name="dto" property="*" ></jsp:setProperty>
        <jsp:useBean id="dao" class="com.kulchuri.exam.question.QuestionDao"></jsp:useBean>
        <%    if (dao.addQuestion(dto)) {
                    response.sendRedirect("admin_viewAllQuestion.jsp");
                }
            }%>

        <div style="width: 50%; margin-left: 25%; margin-top: 1%">
            <h1>Add New Question Form</h1>
            <form action="admin_addQuestion.jsp" method="post" >

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


                <input class="field" type="text" name="question" placeholder="Enter question" required="" autofocus=""/>
                <input class="field" type="text" name="option1" placeholder="Enter option1"required=""/>
                <input class="field" type="text" name="option2" placeholder="Enter option2" required=""/>
                <input class="field" type="text" name="option3" placeholder="Enter option3" required=""/>
                <input class="field" type="text" name="option4" placeholder="Enter option4" required=""/>
                <input class="field" type="text" name="answer" placeholder="Enter answer" required=""/>
                <input type="submit" value="Submit"/>
                <%} else {%>
                <h1>No Subjects</h1>
                <%}%>
            </form>
        </div>
    </body>
</html>
