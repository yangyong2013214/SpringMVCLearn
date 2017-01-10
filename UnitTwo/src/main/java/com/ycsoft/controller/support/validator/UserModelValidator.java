package com.ycsoft.controller.support.validator;

import com.ycsoft.model.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by yong on 2017/1/10 0010.
 */
public class UserModelValidator implements Validator {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z]\\w{4,19}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]\\w{5,20}");
    private static final Set<String> FORBINDDEN_WORD_SET = new HashSet<String>();

    static {
        FORBINDDEN_WORD_SET.add("fuck");
        FORBINDDEN_WORD_SET.add("admin");
    }


    public boolean supports(Class<?> clazz) {
        return UserModel.class == clazz;
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "username.not.empty");
        UserModel user = (UserModel) target;

        if (!USERNAME_PATTERN.matcher(user.getUsername()).matches()) {
            errors.rejectValue("username", "username.not.illegal");

        }

        for (String forbiddenWord : FORBINDDEN_WORD_SET) {
            if (user.getUsername().contains(forbiddenWord)) {
                errors.rejectValue("username", "username.forbidden", new Object[]{forbiddenWord}, "  您的用户名包含非法关键词");
                break;
            }
        }

        if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            errors.rejectValue("password", "password.not.illegal", "密码不合法");
        }
    }
}
