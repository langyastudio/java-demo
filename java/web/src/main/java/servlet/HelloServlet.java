package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 早期的Servlet需要在web.xml中配置映射路径，但最新Servlet版本只需要通过WebServlet注解就可以完成映射。
 * @author hk
 */
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        //session test
        req.getSession().setAttribute("web-user", "abc");

        //cookie
        Cookie cookie = new Cookie("token", "123456");
        cookie.setPath("/");
        cookie.setMaxAge(8640000);
        resp.addCookie(cookie);

        String name = req.getParameter("name");
        if (name == null) {
            name = "world";
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Hello, " + name + "!</h1>");

        // 最后不要忘记flush强制输出:
        printWriter.flush();
    }
}