package com.ycsoft.model;

/**
 * Created by yong on 2017/1/2 0002.
 */
public class SchoolInfoModel {
    //学校类型：高中、中专、大学
    private String schoolType;
    //学校名称
    private String schoolName;
    //专业
    private String specialty;

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
