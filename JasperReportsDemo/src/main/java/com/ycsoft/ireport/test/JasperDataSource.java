package com.ycsoft.ireport.test;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * purpose:
 *
 * @author wxzhong
 * @version 3.0
 * @date 2016-12-21
 * <p>
 * Copyright yckjsoft, Allrights reserved
 */
public class JasperDataSource implements JRDataSource {

    int currentRow = -1;

    //name,age,amount,remark
    //Object valuse[][]=new Object[][]{{},{}};


    public Object getFieldValue(JRField arg0) throws JRException {
        if (arg0.getName().equals("inoice_no")) {
            return "张三";
        } else if (arg0.getName().equals("goods_name")) {
            return "123131";
//        } else if (arg0.getName().equals("amount")) {
//            return new BigDecimal(100.00);
//        } else if (arg0.getName().equals("remark")) {
//            return "这是备注";
        } else {
            return null;
        }
    }


    public boolean next() throws JRException {
        currentRow++;
        return currentRow < 10;
    }

}
