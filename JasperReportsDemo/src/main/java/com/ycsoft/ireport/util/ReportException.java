package com.ycsoft.ireport.util;

/**
 * Created by yong on 2016/12/22 0022.
 */
public class ReportException extends Exception {

    public ReportException() {
        super();
    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(String message) {
        super(message);
    }

    public ReportException(Throwable cause) {
        super(cause);
    }
}
