/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.46
 * Generated at: 2021-09-26 14:07:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sider_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/윤소영/final-project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/HomeOneHana-Admin/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1629721598702L));
  }

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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- <link\r\n");
      out.write("      href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap\"\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("    /> -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- Google Font -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("	<link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/dashboard/tailwind.output.css\" />\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js\"\r\n");
      out.write("      defer\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/dashboard/init-alpine.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- Desktop sidebar -->\r\n");
      out.write("      <aside\r\n");
      out.write("        class=\"z-20 hidden w-64 overflow-y-auto bg-white dark:bg-gray-800 md:block flex-shrink-0\"\r\n");
      out.write("      >\r\n");
      out.write("        <div class=\"py-4 text-gray-500 dark:text-gray-400\">\r\n");
      out.write("          <a\r\n");
      out.write("            class=\"ml-6 text-lg font-bold text-gray-800 dark:text-gray-200\"\r\n");
      out.write("            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main\"\r\n");
      out.write("          >\r\n");
      out.write("            HomeOneHana\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"mt-6\">\r\n");
      out.write("            <li id=\"dashboard\" class=\"relative px-6 py-3\">\r\n");
      out.write("\r\n");
      out.write("              <a\r\n");
      out.write("                class=\"inline-flex items-center w-full text-sm font-semibold text-gray-800 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200 dark:text-gray-100\"\r\n");
      out.write("                href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main\"\r\n");
      out.write("              >\r\n");
      out.write("                <svg\r\n");
      out.write("                  class=\"w-5 h-5\"\r\n");
      out.write("                  aria-hidden=\"true\"\r\n");
      out.write("                  fill=\"none\"\r\n");
      out.write("                  stroke-linecap=\"round\"\r\n");
      out.write("                  stroke-linejoin=\"round\"\r\n");
      out.write("                  stroke-width=\"2\"\r\n");
      out.write("                  viewBox=\"0 0 24 24\"\r\n");
      out.write("                  stroke=\"currentColor\"\r\n");
      out.write("                >\r\n");
      out.write("                  <path\r\n");
      out.write("                    d=\"M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6\"\r\n");
      out.write("                  ></path>\r\n");
      out.write("                </svg>\r\n");
      out.write("                <span class=\"ml-4\">Dashboard</span>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("          <ul>\r\n");
      out.write("           \r\n");
      out.write("            <li id=\"chatMenu\" class=\"relative px-6 py-3\">\r\n");
      out.write("              <a\r\n");
      out.write("                class=\"inline-flex items-center w-full text-sm font-semibold transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200\"\r\n");
      out.write("                href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/consult/chat\"\r\n");
      out.write("              >\r\n");
      out.write("                <svg\r\n");
      out.write("                  class=\"w-5 h-5\"\r\n");
      out.write("                  aria-hidden=\"true\"\r\n");
      out.write("                  fill=\"none\"\r\n");
      out.write("                  stroke-linecap=\"round\"\r\n");
      out.write("                  stroke-linejoin=\"round\"\r\n");
      out.write("                  stroke-width=\"2\"\r\n");
      out.write("                  viewBox=\"0 0 24 24\"\r\n");
      out.write("                  stroke=\"currentColor\"\r\n");
      out.write("                >\r\n");
      out.write("                  <path\r\n");
      out.write("                    d=\"M15 15l-2 5L9 9l11 4-5 2zm0 0l5 5M7.188 2.239l.777 2.897M5.136 7.965l-2.898-.777M13.95 4.05l-2.122 2.122m-5.657 5.656l-2.12 2.122\"\r\n");
      out.write("                  ></path>\r\n");
      out.write("                </svg>\r\n");
      out.write("                <span class=\"ml-4\">상담하기</span>\r\n");
      out.write("              </a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul> \r\n");
      out.write("           \r\n");
      out.write("    \r\n");
      out.write("        </div>\r\n");
      out.write("      </aside>\r\n");
      out.write("      <!-- Mobile sidebar -->");
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