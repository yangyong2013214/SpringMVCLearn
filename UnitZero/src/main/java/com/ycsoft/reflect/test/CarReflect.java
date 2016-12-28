package com.ycsoft.reflect.test;


import com.ycsoft.reflect.bean.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class CarReflect {
    public static Car initByDefaultConst() throws Exception {
        //①通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.ycsoft.reflect.bean.Car");
        //②获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getDeclaredConstructor((Class<?>[]) null);
        Car car = (Car) constructor.newInstance();

        //③通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Exception {
        Car car = initByDefaultConst();
        car.introduce();
    }

}
