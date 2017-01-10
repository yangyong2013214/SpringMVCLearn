package com.ycsoft.controller;

import com.ycsoft.model.DataBinderTestModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class ErrorController extends AbstractCommandController {
    public ErrorController() {
        setCommandClass(DataBinderTestModel.class);
        setCommandName("command");
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        errors.reject("username.not.empty");
        errors.reject("username.not.empty1", "用户名不能为空1");
        errors.reject("username.length.error", new Object[]{5, 10}, "用户名长度不合法");
        Map model = errors.getModel();

        return new ModelAndView("bindAndValidate/error", model);
    }
}
