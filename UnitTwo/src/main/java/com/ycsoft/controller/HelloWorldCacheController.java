package com.ycsoft.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yong on 2016/12/20 0020.
 */
public class HelloWorldCacheController extends AbstractController {

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //点击后再次请求当前页面
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }
}
