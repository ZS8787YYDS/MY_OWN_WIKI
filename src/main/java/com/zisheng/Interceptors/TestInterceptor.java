//package com.zisheng.Interceptors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class TestInterceptor implements HandlerInterceptor {
//    private static final Logger log = LoggerFactory.getLogger(TestInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String url = request.getRequestURL().toString();
//        log.info(request.getMethod() + ": " + url);
//        log.info("目的主机地址：{}",request.getRemoteHost() + ":" + request.getRemotePort());
////      begin = System.currentTimeMillis();
//        request.setAttribute("executeStartTime",System.currentTimeMillis());
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 存放开始时间
//        Long begin = (Long) request.getAttribute("executeStartTime");
//        Long end = System.currentTimeMillis();
//        log.info("接口执行了：{}秒",(end - begin) / 1000.0);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion方法执行了！！！");
//    }
//}
