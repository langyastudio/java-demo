package com.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器 —— 字符乱码
 *
 * Web容器内部使用了 ISO-8859-1 编码格式，不支持中文 —— 重新指定编码格式
 */
public class FilterChar implements Filter {
    private String encoding = null;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 设置字符编码
        if(encoding != null)
        {
            req.setCharacterEncoding(encoding);
            resp.setContentType("text/html; charset="+encoding);
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }
}
