package com.icu.schedule.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter(
        filterName = "loggingFilter",
        initParams = {@WebInitParam(name = "dateTimePattern", value = "yyyy-MM-dd HH:mm:ss")},
        urlPatterns = {"/servletA", "*.html"},
        servletNames = {"servletBName"}
)
public class LogFilter implements Filter {
    private SimpleDateFormat dateFormat;

    /* init初始化方法,通过filterConfig获取初始化参数
     * init方法中,可以用于定义一些其他初始化功能代码
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取初始参数
        String dateTimePattern = filterConfig.getInitParameter("dateTimePattern");
        // 初始化成员变量
        dateFormat = new SimpleDateFormat(dateTimePattern);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 拼接日志文本
        String requestURI = request.getRequestURI();
        String time = dateFormat.format(new Date());
        String beforeLogging = requestURI + "在" + time + "被请求了";
        // 打印日志
        System.out.println(beforeLogging);
        // 获取系统时间
        long t1 = System.currentTimeMillis();

        // 放行请求
        filterChain.doFilter(request, response);

        // 获取系统时间
        long t2 = System.currentTimeMillis();
        String afterLogging = requestURI + "在" + time + "的请求耗时:" + (t2 - t1) + "毫秒";
        // 打印日志
        System.out.println(afterLogging);
    }

    @Override
    public void destroy() {

    }
}
