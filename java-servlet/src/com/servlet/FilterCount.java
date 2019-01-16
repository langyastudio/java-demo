package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器 —— 统计访问人数
 *
 * 本质上就是拦截客户端与目标资源的请求，进行相关处理
 */
public class FilterCount implements Filter {
    private int count;

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //访问数量自增
        count++;

        HttpServletRequest reqHttp = (HttpServletRequest)req;
        ServletContext context = reqHttp.getSession().getServletContext();
        context.setAttribute("count", count);

        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        //获取初始化参数
        String param = config.getInitParameter("count");
        count = Integer.valueOf(param);
    }
}
