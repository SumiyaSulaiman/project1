/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.47
 * Generated at: 2017-12-21 08:30:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shoppingcart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<style>\r\n");
      out.write("\t.table>tbody>tr>td, .table>tfoot>tr>td{\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("@media screen and (max-width: 600px) {\r\n");
      out.write("    table#cart tbody td .form-control{\r\n");
      out.write("\t\twidth:20%;\r\n");
      out.write("\t\tdisplay: inline !important;\r\n");
      out.write("\t}\r\n");
      out.write("\t.actions .btn{\r\n");
      out.write("\t\twidth:36%;\r\n");
      out.write("\t\tmargin:1.5em 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.actions .btn-info{\r\n");
      out.write("\t\tfloat:left;\r\n");
      out.write("\t}\r\n");
      out.write("\t.actions .btn-danger{\r\n");
      out.write("\t\tfloat:right;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\ttable#cart thead { display: none; }\r\n");
      out.write("\ttable#cart tbody td { display: block; padding: .6rem; min-width:320px;}\r\n");
      out.write("\ttable#cart tbody tr td:first-child { background: #333; color: #fff; }\r\n");
      out.write("\ttable#cart tbody td:before {\r\n");
      out.write("\t\tcontent: attr(data-th); font-weight: bold;\r\n");
      out.write("\t\tdisplay: inline-block; width: 8rem;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\ttable#cart tfoot td{display:block; }\r\n");
      out.write("\ttable#cart tfoot td .btn{display:block;}\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<table id=\"cart\" class=\"table table-hover table-condensed\">\r\n");
      out.write("    \t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th style=\"width:50%\">Product</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th style=\"width:10%\">Price</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th style=\"width:8%\">Quantity</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th style=\"width:22%\" class=\"text-center\">Subtotal</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th style=\"width:10%\"></th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td data-th=\"Product\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-2 hidden-xs\"><img src=\"./resources/baby3.jpg\" alt=\"...\" class=\"img-responsive\"/></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h4 class=\"nomargin\">baby cycle</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p>Luvlap Starlight Baby Ride On (Blue)</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td data-th=\"Price\">1200</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td data-th=\"Quantity\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control text-center\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td data-th=\"Subtotal\" class=\"text-center\">1200</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"actions\" data-th=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-info btn-sm\"><i class=\"fa fa-refresh\"></i></button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-danger btn-sm\"><i class=\"fa fa-trash-o\"></i></button>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"visible-xs\">\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"text-center\"><strong>Total 1200</strong></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><a href=\"#\" class=\"btn btn-warning\"><i class=\"fa fa-angle-left\"></i> Continue Shopping</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" class=\"hidden-xs\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"hidden-xs text-center\"><strong>Total 1200</strong></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><a href=\"#\" class=\"btn btn-success btn-block\">Checkout <i class=\"fa fa-angle-right\"></i></a></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}