package com.ycsoft.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class ForumServiceJDKProxyTest {
    public static void main(String[] args) {
        //①希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        //②将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(target);

        //③根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{ForumService.class},
                handler
        );

        //④调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

}
