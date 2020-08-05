package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 重定向
 *
 * @author hk
 */
@WebServlet(urlPatterns = "/hi")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_FOUND);

        String url = "/hello";
        if(req.getQueryString() != null)
        {
            url += "?" + req.getQueryString();
        }
        resp.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发
        req.getRequestDispatcher("/hello").forward(req, resp);
    }
}
