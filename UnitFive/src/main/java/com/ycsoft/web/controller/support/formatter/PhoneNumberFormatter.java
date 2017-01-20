package com.ycsoft.web.controller.support.formatter;

import com.ycsoft.model.PhoneNumberModel;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yong on 2017/1/19 0019.
 */
public class PhoneNumberFormatter implements Formatter<PhoneNumberModel> {
    Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

    public PhoneNumberModel parse(String text, Locale locale) throws ParseException {
        if (text == null || !StringUtils.hasLength(text)) {
            //如果没值，设值为null
            return null;
        }
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            PhoneNumberModel phoneNumber = new PhoneNumberModel();
            phoneNumber.setAreaCode(matcher.group(1));
            phoneNumber.setPhoneNumber(matcher.group(2));
            return phoneNumber;
        } else {
            throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", text));
        }
    }

    public String print(PhoneNumberModel object, Locale locale) {
        if (object == null) {
            return "";
        }
        return new StringBuilder().append(object.getAreaCode()).append("-")
                .append(object.getPhoneNumber()).toString();
    }
}
