package com.ycsoft.web.interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yong on 2017/1/11 0011.
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {


    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long begintTime = startTimeThreadLocal.get();
        long consumeTime = endTime - begintTime;
        if (consumeTime > 5) {
            System.out.println(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();
        startTimeThreadLocal.set(beginTime);

        return true;
    }
}
