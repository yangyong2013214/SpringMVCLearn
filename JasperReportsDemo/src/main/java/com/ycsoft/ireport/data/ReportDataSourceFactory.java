package com.ycsoft.ireport.data;

import com.ycsoft.ireport.domain.ReportData;

import java.util.Arrays;

/**
 * Created by yong on 2016/12/21 0021.
 */
public class ReportDataSourceFactory {

    private static ReportData[] data = null;

    public static ReportData[] getData() {
        data = new ReportData[2];

        data[0] = new ReportData();
        data[0].setId("001");
        data[0].setName("陈");
        data[0].setClassName("一班");
        data[0].setChildren(Arrays.asList(ReportChildSourceFactory.getData()));

        data[1] = new ReportData();
        data[1].setId("002");
        data[1].setName("拉拉");
        data[1].setClassName("二班");
        data[1].setChildren(Arrays.asList(ReportChildSourceFactory.getData()));

        return data;
    }
}
