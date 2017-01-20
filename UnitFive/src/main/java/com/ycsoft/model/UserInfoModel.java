package com.ycsoft.model;

/**
 * Created by yong on 2017/1/2 0002.
 */
public class UserInfoModel {
    private String username;
    private String password;
    //真实姓名
    private String realname;
    private WorkInfoModel workInfo;
    private SchoolInfoModel schoolInfo;

    /**
     * Getter for property 'username'.
     *
     * @return Value for property 'username'.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for property 'username'.
     *
     * @param username Value to set for property 'username'.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property 'realname'.
     *
     * @return Value for property 'realname'.
     */
    public String getRealname() {
        return realname;
    }

    /**
     * Setter for property 'realname'.
     *
     * @param realname Value to set for property 'realname'.
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * Getter for property 'workInfo'.
     *
     * @return Value for property 'workInfo'.
     */
    public WorkInfoModel getWorkInfo() {
        return workInfo;
    }

    /**
     * Setter for property 'workInfo'.
     *
     * @param workInfo Value to set for property 'workInfo'.
     */
    public void setWorkInfo(WorkInfoModel workInfo) {
        this.workInfo = workInfo;
    }

    /**
     * Getter for property 'schoolInfo'.
     *
     * @return Value for property 'schoolInfo'.
     */
    public SchoolInfoModel getSchoolInfo() {
        return schoolInfo;
    }

    /**
     * Setter for property 'schoolInfo'.
     *
     * @param schoolInfo Value to set for property 'schoolInfo'.
     */
    public void setSchoolInfo(SchoolInfoModel schoolInfo) {
        this.schoolInfo = schoolInfo;
    }
}
