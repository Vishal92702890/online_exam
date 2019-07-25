package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.exam.question.QuestionDto;
import java.util.ArrayList;

public final class admin_005fviewAllQuestion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/main_menu.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      com.kulchuri.exam.question.QuestionDao dao = null;
      synchronized (_jspx_page_context) {
        dao = (com.kulchuri.exam.question.QuestionDao) _jspx_page_context.getAttribute("dao", PageContext.PAGE_SCOPE);
        if (dao == null){
          dao = new com.kulchuri.exam.question.QuestionDao();
          _jspx_page_context.setAttribute("dao", dao, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
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
      out.write("<ul>\r\n");
      out.write("    <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("    <li><a href=\"about.jsp\">About Us</a></li>\r\n");
      out.write("    <li><a href=\"services.jsp\">Services</a></li>\r\n");
      out.write("    <li><a href=\"signin.jsp\">Signin</a></li>\r\n");
      out.write("    <li><a href=\"contact.jsp\">Contact Us</a></li>\r\n");
      out.write("</ul>");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            ");

                ArrayList<QuestionDto> al = dao.getAllQuestions();
                if (al != null) {
            
      out.write("\n");
      out.write("            <h1 style=\"margin: 1%\">List of Questions</h1>\n");
      out.write("            <table id=\"customers\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S.No.</th>\n");
      out.write("                    <th>Question</th>\n");
      out.write("                    <th>Option 1</th>\n");
      out.write("                    <th>Option 2</th>\n");
      out.write("                    <th>Option 3</th>\n");
      out.write("                    <th>Option 4</th>\n");
      out.write("                    <th>Answer</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    int s = 0;
                    for (QuestionDto dto : al) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(++s);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getQuestion());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getOption1());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getOption2());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getOption3());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getOption4());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getAnswer());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a>Edit</a>\n");
      out.write("                        <a>Delete</a>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <center>\n");
      out.write("                <h1>No Questions</h1>\n");
      out.write("            </center>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
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
