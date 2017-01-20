package com.ycsoft.web.controller.validate;

import com.ycsoft.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by yong on 2017/1/20 0020.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/validate/hello")
    public String validate(@Valid @ModelAttribute("user") UserModel user, Errors errors) {
        if (errors.hasErrors()) {
            return "validate/error";
        }
        return "redirect:/success";
    }
}
