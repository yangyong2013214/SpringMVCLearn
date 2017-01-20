package com.ycsoft.web.controller;

import com.ycsoft.model.DataBinderTestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;


/**
 * Created by yong on 2017/1/14 0014.
 */
@Controller
public class DataBinderTestController {

    private static Logger logger = LoggerFactory.getLogger(DataBinderTestController.class);

    @RequestMapping(value = "/dataBind")
    public String test(DataBinderTestModel command, Model model) {
        //System.out.println(command);
        logger.info(command.toString());
        model.addAttribute("dataBinderTest", command);
        return "bind/success";
    }
}
