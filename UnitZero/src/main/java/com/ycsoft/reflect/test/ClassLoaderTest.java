package com.ycsoft.reflect.test;


/**
 * Created by yong on 2016/12/23 0023.
 * 通过以上的输出信息，
 * 我们知道当前的ClassLoader是AppClassLoader，
 * 父ClassLoader是ExtClassLoader，
 * 祖父ClassLoader是根类装载器，
 * 因为在Java中无法获得它的句柄，所以仅返回null
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader = " + loader);
        System.out.println("parent loader = " + loader.getParent());
        System.out.println("grandparent loader = " + loader.getParent().getParent());
    }
}
