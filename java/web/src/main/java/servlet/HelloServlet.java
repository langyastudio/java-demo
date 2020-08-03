package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hk
 */
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

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