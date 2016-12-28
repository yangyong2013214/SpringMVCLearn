package com.ycsoft.ireport.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yong on 2016/12/21 0021.
 */
public class ReportData implements Serializable {
    private static final long serialVersionUID = 6771893147766089586L;
    private String id;
    private String name;
    private String className;
    private List<ReportChild> children;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'className'.
     *
     * @return Value for property 'className'.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter for property 'className'.
     *
     * @param className Value to set for property 'className'.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Getter for property 'children'.
     *
     * @return Value for property 'children'.
     */
    public List<ReportChild> getChildren() {
        return children;
    }

    /**
     * Setter for property 'children'.
     *
     * @param children Value to set for property 'children'.
     */
    public void setChildren(List<ReportChild> children) {
        this.children = children;
    }
}
