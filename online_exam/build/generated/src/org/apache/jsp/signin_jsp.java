package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\">\n");
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
      out.write("<ul>\r\n");
      out.write("    <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("    <li><a href=\"about.jsp\">About Us</a></li>\r\n");
      out.write("    <li><a href=\"services.jsp\">Services</a></li>\r\n");
      out.write("    <li><a href=\"signin.jsp\">Signin</a></li>\r\n");
      out.write("    <li><a href=\"contact.jsp\">Contact Us</a></li>\r\n");
      out.write("</ul>");
      out.write("\n");
      out.write("        <div style=\"width: 50%; margin-left: 25%; margin-top: 5%\">\n");
      out.write("            <h1>Login Form</h1>\n");
      out.write("            <form action=\"#\" method=\"post\" >\n");
      out.write("                <input class=\"field\" type=\"text\" name=\"uname\" placeholder=\"Enter username\" required=\"\" autofocus=\"\"/>\n");
      out.write("                <input class=\"field\" type=\"password\" name=\"pwd\" placeholder=\"Enter password\" required=\"\"/>\n");
      out.write("                <input type=\"radio\" name=\"ltype\" value=\"Admin\"/>Admin\n");
      out.write("                <input type=\"radio\" name=\"ltype\" value=\"Student\"/>Student\n");
      out.write("                <input type=\"submit\" value=\"Signin\"/>\n");
      out.write("                <a href=\"signup.jsp\">New Student</a>\n");
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
