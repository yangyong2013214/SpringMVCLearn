package com.ycsoft.web.controller.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yong on 2017/1/11 0011.
 */
@Controller
@RequestMapping("/customers/**")
public class RequestMethodController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showFor() {
        System.out.println("=====================GET");
        return "customer/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submit() {
        System.out.println("=====================POST");
        return "redirect:/success";
    }

    @RequestMapping(value="/methodOr", method = {RequestMethod.POST, RequestMethod.GET})
    public String or() {
        System.out.println("================GET or POST");
        return "redirect:/success";
    }
}
