package com.ycsoft.controller;

import com.ycsoft.model.UserModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yong on 2016/12/30 0030.
 */
public class MyAbstractCommandController extends AbstractCommandController {

    public MyAbstractCommandController() {
        //设置命令对象实现类
        setCommandClass(UserModel.class);
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        //将命令对象转换为实际类型
        UserModel userModel = (UserModel) command;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("abstractCommand");
        mv.addObject("user", userModel);
        return mv;
    }
}
