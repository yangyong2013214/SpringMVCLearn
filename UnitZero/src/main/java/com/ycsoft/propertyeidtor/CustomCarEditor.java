package com.ycsoft.propertyeidtor;

import java.beans.PropertyEditorSupport;

/**
 * Created by yong on 2016/12/27 0027.
 */
public class CustomCarEditor extends PropertyEditorSupport {
    //①将字面值转换为属性类型对象
    public void setAsText(String text) {
        if (text == null || text.indexOf(",") == -1) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        //②调用父类的setValue()方法设置转换后的属性对象
        setValue(car);
    }
}
