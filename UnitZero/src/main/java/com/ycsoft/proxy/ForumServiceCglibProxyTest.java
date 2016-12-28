package com.ycsoft.proxy;


import net.sf.cglib.proxy.Proxy;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class ForumServiceCglibProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        //我们通过CglibProxy为ForumServiceImpl动态创建了一个织入性能监视逻辑的代理对象
        ForumServiceImpl service = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);

        service.removeForum(10);
        service.removeTopic(1012);
    }

}
