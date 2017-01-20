package com.ycsoft.model;

/**
 * Created by yong on 2017/1/10 0010.
 * //如格式010-12345678
 */
public class PhoneNumberModel {
    //区号
    private String areaCode;
    //电话号码
    private String phoneNumber;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberModel() {
    }

    public PhoneNumberModel(String areaCode, String phoneNumber) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumberModel{" +
                "areaCode='" + areaCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
