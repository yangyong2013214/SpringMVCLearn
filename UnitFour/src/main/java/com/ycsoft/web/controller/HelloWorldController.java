package com.ycsoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yong on 2017/1/11 0011.
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value = "/hello")
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World");
        mv.setViewName("hello");
        return mv;
    }
}
