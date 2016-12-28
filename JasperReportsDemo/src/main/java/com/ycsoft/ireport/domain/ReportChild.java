package com.ycsoft.ireport.domain;

import java.io.Serializable;

/**
 * Created by yong on 2016/12/21 0021.
 */
public class ReportChild implements Serializable{

    private static final long serialVersionUID = 268860238160998055L;
    private String course;
    private int degree;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
