package com.ycsoft.propertyeditor;

import com.ycsoft.propertyeidtor.Boss;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadDaoImplTest {
      
    public  static void main(String[] args){  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
  
        context.start();

        Boss bean = (Boss) context.getBean("boss");
        System.out.println(bean.getCar().getBrand());
    }  
      
}  