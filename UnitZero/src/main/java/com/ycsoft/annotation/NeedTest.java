package com.ycsoft.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yong on 2016/12/28 0028.
 */
//①声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
//②声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
public @interface NeedTest { //③定义注解
    boolean value() default true; //④声明注解成员
}
