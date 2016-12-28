package com.ycsoft.reflect.test;


import com.ycsoft.reflect.bean.PrivateCar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //获取类对象
        Class clazz = loader.loadClass("com.ycsoft.reflect.bean.PrivateCar");
        //实例化
        PrivateCar privateCar = (PrivateCar) clazz.newInstance();

        Field colorField = clazz.getDeclaredField("color");
        //①取消Java语言访问检查以访问private变量
        colorField.setAccessible(true);
        colorField.set(privateCar, "红色");

        //②取消Java语言访问检查以访问protected方法
        Method driveMethod = clazz.getDeclaredMethod("drive", (Class[]) null);
        driveMethod.setAccessible(true);
        driveMethod.invoke(privateCar, (Object[]) null);
    }
}
