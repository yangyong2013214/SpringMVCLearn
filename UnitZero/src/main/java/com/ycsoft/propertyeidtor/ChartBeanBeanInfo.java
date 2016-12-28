package com.ycsoft.propertyeidtor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class ChartBeanBeanInfo extends SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            //①将TitlePositionEditor绑定到ChartBean的titlePosition属性中
            PropertyDescriptor titlePositionDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
            titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);

            //②将InverseEditor绑定到ChartBean的inverse属性中
            PropertyDescriptor inverseDescriptor = new PropertyDescriptor("inverse", ChartBean.class);
            inverseDescriptor.setPropertyEditorClass(InverseEditor.class);

            return new PropertyDescriptor[]{titlePositionDescriptor, inverseDescriptor};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
