package com.ycsoft.web.controller.support.initializer;


import com.ycsoft.model.PhoneNumberModel;
import com.ycsoft.web.controller.support.editor.PhoneNumberEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class MyWebBindingInitializer implements WebBindingInitializer {
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);

        binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
    }
}
