package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("LogFilter: process " + ((HttpServletRequest)servletRequest).getRequestURI());

        //继续处理:
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
