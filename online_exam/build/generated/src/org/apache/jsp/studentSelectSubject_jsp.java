package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.exam.question.QuestionDao;
import com.kulchuri.exam.question.QuestionDto;
import com.kulchuri.exam.subject.SubjectDao;
import java.util.ArrayList;
import com.kulchuri.exam.subject.SubjectDto;

public final class studentSelectSubject_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/student_menu.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("            <img src=\"images/logo_exam.png\" width=\"80\" height=\"80\">\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <h1>Online Exam Application</h1>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>");
      out.write("\n");
      out.write("        ");
      out.write("<ul>\n");
      out.write("    <li><a href=\"studentHome.jsp\">Home</a></li>\n");
      out.write("    <li><a href=\"studentSelectSubject.jsp\">Exam</a></li>\n");
      out.write("    <li><a href=\"studentResult.jsp\">Result</a></li>\n");
      out.write("    <li><a href=\"studentSignout.jsp\">Signout</a></li>\n");
      out.write("</ul>");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"width: 50%; margin-left: 25%; margin-top: 1%\">\n");
      out.write("\n");
      out.write("            ");

                if (request.getMethod().equalsIgnoreCase("post")) {
                    String sid = request.getParameter("sid");
                    ArrayList<QuestionDto> al = new QuestionDao().getAllQuestionsBySubjects(Integer.parseInt(sid));
                    if (al != null) {
                        session.setAttribute("al", al);
                        response.sendRedirect("studentExam.jsp");
                    } else {
            
      out.write("\n");
      out.write("            <center>\n");
      out.write("                <script>\n");
      out.write("                    alert(\"There is no questions in database\");\n");
      out.write("                </script>\n");
      out.write("            </center>\n");
      out.write("            ");
            
                    }
                }
            
      out.write("\n");
      out.write("            <h1>Select Subject For Exam</h1>\n");
      out.write("            <form action=\"studentSelectSubject.jsp\" method=\"post\" >\n");
      out.write("                ");
        
                    ArrayList<SubjectDto> al = new SubjectDao().getAllSubjects();
                    if (al != null) {
                
      out.write("\n");
      out.write("                <select class=\"field\" name=\"sid\" required=\"\">\n");
      out.write("                    <option value=\"\">---Select Subject---</option>\n");
      out.write("                    ");
        
                        for (SubjectDto sd : al) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(sd.getSid());
      out.write('"');
      out.write('>');
      out.print(sd.getName());
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <input type=\"submit\" value=\"Submit\"/>\n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                <h1>No Subjects</h1>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
