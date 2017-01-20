package com.ycsoft.web.controller;

import com.ycsoft.model.FormatterModel;
import com.ycsoft.model.PhoneNumberModel;
import com.ycsoft.web.controller.support.formatter.PhoneNumber;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by yong on 2017/1/19 0019.
 */
@Controller
public class DataFormatTestController {

    @RequestMapping(value = "/format1")
    public String test1(@ModelAttribute("model") FormatterModel formatterModel) {
        return "format/success";
    }

    @RequestMapping(value = "/format2")
    public String test2(@PhoneNumber @RequestParam("phoneNumber") PhoneNumberModel phoneNumber,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date) {
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("date = " + date);
        return "format/success2";
    }
}
