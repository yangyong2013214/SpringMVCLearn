package com.ycsoft.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.AbstractCollection;

/**
 * Created by yong on 2016/12/29 0029.
 */
public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified {
    private long lastModified;

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }

    public long getLastModified(HttpServletRequest request) {
        if (lastModified == 0L) {
            //TODO 此处更新的条件：如果内容有更新，应该重新返回内容最新修改的时间戳
            lastModified = System.currentTimeMillis();
        }
        return lastModified;
    }
}
