package com.test;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 主要用于处理业务逻辑，封装了对HTTP请求的处理。
 * 由Servlet容器通知相应的对象进行处理，所以需要注册类
 * <p>
 * HTTPServlet -> GenericServlet -> Servlet + ServletConfig
 *
 * @author jiangjiaxiong
 * @date 2018/12/29
 */
public class ServletTest extends HttpServlet {
    /**
     * 生命周期开始
     */
    @Override
    public void init() throws ServletException {

    }

    /**
     * 生命周期结束
     */
    @Override
    public void destroy() {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("  <head><title>Servlet sample</title></head>");
        out.println("  <body>");
        out.println("  Servlet sample:");
        out.print(this.getClass());
        out.println("  </body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
