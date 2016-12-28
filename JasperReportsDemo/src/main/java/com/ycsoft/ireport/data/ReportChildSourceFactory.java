package com.ycsoft.ireport.data;

import com.ycsoft.ireport.domain.ReportChild;

public class ReportChildSourceFactory {

    private static ReportChild[] data = null;

    public static ReportChild[] getData() {
        data = new ReportChild[2];

        data[0] = new ReportChild();
        data[0].setDegree(30);
        data[0].setCourse("合格");

        data[1] = new ReportChild();
        data[1].setDegree(70);
        data[1].setCourse("不合格");
        return data;
    }
}