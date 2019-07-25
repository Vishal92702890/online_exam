<%-- 
    Document   : studentResult
    Created on : Jul 8, 2019, 4:05:01 AM
    Author     : DELL
--%>
<%@page import="com.kulchuri.exam.result.ResultDao"%>
<%@page import="com.kulchuri.exam.result.ResultDto"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="com.kulchuri.exam.question.QuestionDao"%>
<%@page import="com.sun.javafx.collections.MappingChange.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        Enumeration en = request.getParameterNames();
        ArrayList<Integer> question = new ArrayList<>();
        ArrayList<String> options = new ArrayList<>();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            if (key.contains("ques")) {
                String value = request.getParameter(key);
                question.add(Integer.parseInt(value));
            } else {
                options.add(request.getParameter(key));
            }
        }
        System.out.println("Quest:" + question);
        System.out.println("Options" + options);

        int total = question.size();
        int tattempt = 0;
        int tright = 0;
        int tworng = 0;
        QuestionDao qd = new QuestionDao();
        for (int i = 0; i < total; i++) {
            String opn = options.get(i);
            if (!opn.contains("none")) {
                tattempt++;
                if (qd.getAnswer(question.get(i)).equalsIgnoreCase(opn)) {
                    tright++;
                } else {
                    tworng++;
                }
            }
        }
        String s = (String) session.getAttribute("sid");
        int sid = Integer.parseInt(s);
        int stid = (Integer) session.getAttribute("stid");
        ResultDto dto = new ResultDto(total, stid, sid, tright, tworng, tattempt);
        ResultDao dao = new ResultDao();
        if (dao.addResult(dto)) {
            session.removeAttribute("sid");
            session.removeAttribute("al");
            session.setAttribute("result", dto);
            response.sendRedirect("student_showResult.jsp");
        }
    } else {
        response.sendRedirect("studentSelectSubject.jsp");
    }
%>