package com.ycsoft.aop;

public interface TransactionManager {
    void beginTransaction();
    void endTransaction();
}
