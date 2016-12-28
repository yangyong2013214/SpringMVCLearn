package com.ycsoft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yong on 2016/12/23 0023.
 */
//①实现InvocationHandler
public class PerformanceHandler implements InvocationHandler {

    private Object target;
    //②target为目标的业务类
    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        //③-2通过反射方法调用业务类的目标方法
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
