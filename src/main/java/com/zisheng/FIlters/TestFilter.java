package com.zisheng.FIlters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//@Component
@Slf4j
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器执行了~~~~~~~~");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURL().toString();
        log.info(httpServletRequest.getMethod() + "：  {}，",url);
        Long begin = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        Long end = System.currentTimeMillis();
        log.info("执行时间为：{}秒",(end - begin) / 1000.0);
    }
}
