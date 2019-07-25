<%-- 
    Document   : signup
    Created on : Jul 2, 2019, 7:21:10 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="all" href="calander/jsDatePick_ltr.min.css"/>
        <script type="text/javascript" src="calander/jsDatePick.min.1.3.js"/></script>
    <script>
        window.onload = function () {
            new JsDatePick({
                useMode: 2,
                target: "dob",
                dateFormat: "%d-%M-%Y"
            });
        };
    </script>
</head>
<body>
    <%@include file="header.html" %>
    <%@include file="main_menu.html" %>

    <%
        if (request.getMethod().equalsIgnoreCase("post")) {
    %>
    <jsp:useBean id="dto" class="com.kulchuri.exam.student.StudentDto"></jsp:useBean>
    <jsp:setProperty name="dto" property="*"></jsp:setProperty>
    <jsp:useBean id="dao" class="com.kulchuri.exam.student.StudentDao"></jsp:useBean>
    <%
        Integer sid = dao.addStudent(dto);
        if (sid != null) {
    %>
    <jsp:forward page="uploadPhoto.jsp">
        <jsp:param name="sid" value="<%=sid%>"></jsp:param>  
    </jsp:forward>
    <%
            }
        }
    %>



    <div style="width: 50%; margin-left: 25%; margin-top: 1%">
        <h1>New Student Registration Form</h1>
        <form action="signup.jsp" method="post" >
            <input class="field" type="text" name="name" placeholder="Enter name" required="" autofocus=""/>
            <input class="field" type="email" name="email" placeholder="Enter email" required=""/>
            <input class="field" type="password" name="pwd" placeholder="Enter password" required=""/>
            <input class="field" type="text" autocomplete="off" id="dob" name="dob" placeholder="Enter date of birth" required=""/>
            
            <input class="field" type="text" name="mno" placeholder="Enter mno" required=""/>
            <label>Gender:</label>   <input type="radio" name="gender" value="Male"/><span style="margin-left: 1%; font-size: 20px; ">Male</span>
            <input type="radio" name="gender" value="Female"/><span style="margin-left: 1%; font-size: 20px; ">Female</span>
            <input type="submit" value="Signup"/>
        </form>
    </div>
</body>
</html>
