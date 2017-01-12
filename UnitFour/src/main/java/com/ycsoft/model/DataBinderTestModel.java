package com.ycsoft.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yong on 2017/1/10 0010.
 *
 */
public class DataBinderTestModel {

    private String username;
    private boolean bool;
    private SchoolInfoModel schoolInfo;
    private List hobbyList;
    private Map map;
    private PhoneNumberModel phoneNumber;
    private Date date;
    private UserState state;

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
     * Getter for property 'bool'.
     *
     * @return Value for property 'bool'.
     */
    public boolean isBool() {
        return bool;
    }

    /**
     * Setter for property 'bool'.
     *
     * @param bool Value to set for property 'bool'.
     */
    public void setBool(boolean bool) {
        this.bool = bool;
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

    /**
     * Getter for property 'hobbyList'.
     *
     * @return Value for property 'hobbyList'.
     */
    public List getHobbyList() {
        return hobbyList;
    }

    /**
     * Setter for property 'hobbyList'.
     *
     * @param hobbyList Value to set for property 'hobbyList'.
     */
    public void setHobbyList(List hobbyList) {
        this.hobbyList = hobbyList;
    }

    /**
     * Getter for property 'map'.
     *
     * @return Value for property 'map'.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Setter for property 'map'.
     *
     * @param map Value to set for property 'map'.
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Getter for property 'phoneNumber'.
     *
     * @return Value for property 'phoneNumber'.
     */
    public PhoneNumberModel getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for property 'phoneNumber'.
     *
     * @param phoneNumber Value to set for property 'phoneNumber'.
     */
    public void setPhoneNumber(PhoneNumberModel phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for property 'date'.
     *
     * @param date Value to set for property 'date'.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for property 'state'.
     *
     * @return Value for property 'state'.
     */
    public UserState getState() {
        return state;
    }

    /**
     * Setter for property 'state'.
     *
     * @param state Value to set for property 'state'.
     */
    public void setState(UserState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DataBinderTestModel{" +
                "username='" + username + '\'' +
                ", bool=" + bool +
                ", schoolInfo=" + schoolInfo +
                ", hobbyList=" + hobbyList +
                ", map=" + map +
                ", phoneNumber=" + phoneNumber +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
