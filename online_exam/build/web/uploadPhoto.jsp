<%-- 
    Document   : uploadPhoto
    Created on : Jul 2, 2019, 7:50:14 AM
    Author     : DELL
--%>

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
        <%@include file="main_menu.html" %>
        <div>
            <%
                int sid = Integer.parseInt(request.getParameter("sid"));

            %>
            <form action="PhotoUploadServlet" method="post" enctype="multipart/form-data">
                <input type="hidden" name="stid" value="<%=sid%>"/>
                <input class="field" type="file" name="photo" required=""/>
                <input type="submit" value="Upload Photo"/>
            </form>
        </div>
    </body>
</html>
