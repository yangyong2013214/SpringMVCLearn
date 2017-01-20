package com.ycsoft.web.controller.support.converter;

import com.ycsoft.model.PhoneNumberModel;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by yong on 2017/1/18 0018.
 */
public class PhoneNumberToStringConverter implements Converter<PhoneNumberModel, String> {

    public String convert(PhoneNumberModel source) {
        if (source == null) {
            return "";
        }

        return new StringBuilder()
                .append(source.getAreaCode()).append("-")
                .append(source.getPhoneNumber()).toString();
    }
}
