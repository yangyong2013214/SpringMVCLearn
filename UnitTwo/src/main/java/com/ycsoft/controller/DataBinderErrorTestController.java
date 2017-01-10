package com.ycsoft.controller;

import com.ycsoft.model.DataBinderTestModel;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class DataBinderErrorTestController extends SimpleFormController {

    public DataBinderErrorTestController() {
        setCommandClass(DataBinderTestModel.class);
        setCommandName("dataBinderTest");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
        System.out.println(errors);
        return super.showForm(request, response, errors);
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        System.out.println(command);
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        super.initBinder(request, binder);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);

        //binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
    }
}
