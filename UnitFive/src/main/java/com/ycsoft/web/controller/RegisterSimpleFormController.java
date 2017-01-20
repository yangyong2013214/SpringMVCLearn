package com.ycsoft.web.controller;

import com.ycsoft.model.UserModel;
import com.ycsoft.web.controller.support.validator.UserModelValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yong on 2017/1/20 0020.
 */
@Controller
public class RegisterSimpleFormController {
    private UserModelValidator validator = new UserModelValidator();

    @ModelAttribute("user")
    public UserModel getUser() {
        return new UserModel();

    }

    @RequestMapping(value = "/validator", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "validate/registerAndValidator";
    }

    @RequestMapping(value = "/validator", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") UserModel user,
                             Errors errors) {
        validator.validate(user, errors);
        if (errors.hasErrors()) {
            return showRegisterForm();
        }
        return "redirect:/success";
    }
}
