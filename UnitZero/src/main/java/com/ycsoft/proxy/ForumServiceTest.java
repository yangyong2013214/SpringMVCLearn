package com.ycsoft.proxy;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class ForumServiceTest {
    public static void main(String[] args) {
        ForumService service = new ForumServiceImpl();
        service.removeForum(10);
        service.removeTopic(1012);
    }

}
