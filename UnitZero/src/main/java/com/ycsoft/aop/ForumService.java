package com.ycsoft.aop;

public class ForumService {
    private TransactionManager transManager;
    private PerformanceMonitor pmonitor;
    private TopicDao topicDao;
    private ForumDao forumDao;

    public void removeTopic(int topicId) {
        //①-1性能监控开始
        pmonitor.start();
        //②-1 事务处理开始
        transManager.beginTransaction();
        //③-1 业务逻辑
        topicDao.removeTopic(topicId);
        //②-1事务处理结束
        transManager.endTransaction();
        //①-2 性能监控结束
        pmonitor.end();
    }

    public void CreateForum(Forum forum) {
        pmonitor.start();
        transManager.beginTransaction();

        forumDao.create(forum);

        transManager.endTransaction();
        pmonitor.end();
    }
}
