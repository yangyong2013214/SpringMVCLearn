package com.ycsoft.web.controller.support.converter;

import com.ycsoft.model.PhoneNumberModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yong on 2017/1/18 0018.
 */
public class StringToPhoneNumberConverter implements Converter<String, PhoneNumberModel> {
    Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");


    public PhoneNumberModel convert(String source) {
        //如果source为空， 返回null
        if (!StringUtils.hasLength(source)) {
            return null;
        }
        Matcher matcher = pattern.matcher(source);
        //如果匹配，进行转换
        if (matcher.matches()) {
            PhoneNumberModel phoneNumber = new PhoneNumberModel();
            phoneNumber.setAreaCode(matcher.group(1));
            phoneNumber.setPhoneNumber(matcher.group(2));
            return phoneNumber;
        } else {
            //不匹配，转换失败
            throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", source));
        }
    }
}
