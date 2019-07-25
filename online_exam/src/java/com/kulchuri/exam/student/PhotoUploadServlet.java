package com.kulchuri.exam.student;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 997989898)
public class PhotoUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int stid = Integer.parseInt(request.getParameter("stid"));
            Part part = request.getPart("photo");
            InputStream photo = part.getInputStream();
            if (new StudentDao().addPhoto(stid, photo)) {
                response.sendRedirect("signin.jsp");
            } else {
                response.sendRedirect("uploadPhoto.jsp?sid=" + stid);
            }
        }
    }
}
