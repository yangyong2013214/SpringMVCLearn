package com.ycsoft.controller;

import com.ycsoft.model.DataBinderTestModel;
import com.ycsoft.controller.support.editor.PhoneNumberEditor;
import com.ycsoft.model.PhoneNumberModel;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class DataBinderTestController extends AbstractCommandController {

    public DataBinderTestController() {
        setCommandClass(DataBinderTestModel.class);
        setCommandName("dataBinderTest");
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        System.out.println(command);
        return new ModelAndView("bindAndValidate/success").addObject("dataBinderTest", command);
    }
// 模式二的时候需要注释掉initBinder方法
//    @Override
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//        super.initBinder(request, binder);
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
//        binder.registerCustomEditor(Date.class, dateEditor);
//
//        binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
//
//    }

    // 模式三的时候
    //把binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());”注释掉
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
        //binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
    }
}
