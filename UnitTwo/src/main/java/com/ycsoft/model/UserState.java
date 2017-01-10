package com.ycsoft.model;

/**
 * Created by yong on 2017/1/10 0010.
 */
public enum UserState {
    normal("正常状态"), blocked("锁定");

    private String desc;

    UserState(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for property 'desc'.
     *
     * @return Value for property 'desc'.
     */
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
