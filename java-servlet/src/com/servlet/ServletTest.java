package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 主要用于处理业务逻辑，封装了对HTTP请求的处理。
 * 由Servlet容器通知相应的对象进行处理，所以需要注册类
 *
 * HTTPServlet -> GenericServlet -> Servlet + ServletConfig
 *
 * Servlet 3.0 新增的：
 *  1、新增注释替代web.xml配置
 *  2、对文件上传的支持
 * @MultipartConfig
 * 从request对象中获取Part文件对象
 *  3、异步处理
 * Servlet、Fiter
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
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("  <head><title>Servlet sample</title></head>");
        out.println("  <body>");
        out.println("  Servlet sample:");
        out.print(this.getClass());
        out.println("  </body>");
        out.println("</html>");

        String id     = req.getParameter("id");
        String name   = req.getParameter("name");
        String author = req.getParameter("author");
        String price  = req.getParameter("price");
        out.println("<h2>图书信息添加成功</h2><hr>");
        out.println("图书编号：" + id + "<br>");
        out.println("图书名称：" + name + "<br>");
        out.println("作者：" + author + "<br>");
        out.println("价格：" + price + "<br>");

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