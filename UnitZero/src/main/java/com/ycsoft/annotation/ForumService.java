package com.ycsoft.annotation;

/**
 * Created by yong on 2016/12/28 0028.
 */
public class ForumService {
    @NeedTest(value = true)
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模板：" + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId) {
        System.out.println("删除论坛主题：" + postId);
    }
}
