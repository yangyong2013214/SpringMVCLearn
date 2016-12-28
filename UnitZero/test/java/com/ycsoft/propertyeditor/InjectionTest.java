package com.ycsoft.propertyeditor;

import com.ycsoft.propertyeidtor.Boss;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yong on 2016/12/27 0027.
 */
public class InjectionTest extends BaseJunit4Test {
    private BeanFactory factory;


    /*public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    }*/

    public void testInjection1() throws Exception {
        Boss bean = (Boss) factory.getBean("boss");
        System.out.println(bean.getCar().getBrand());
    }
}
