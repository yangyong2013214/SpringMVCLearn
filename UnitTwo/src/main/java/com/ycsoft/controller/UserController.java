package com.ycsoft.controller;

import com.ycsoft.model.UserModel;
import com.ycsoft.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yong on 2017/1/3 0003.
 */
public class UserController extends MultiActionController {
    //用户服务类
    private UserService userService;

    private String createView;
    private String updateView;
    private String deleteView;
    private String listView;
    private String redirectToListView;

    public String create(HttpServletRequest req, HttpServletResponse resp, UserModel userModel) {
        if ("GET".equals(req.getMethod())) {
            //如果是get请求 我们转向 新增页面
            return getCreateView();
        }
        userService.create(userModel);
        //直接重定向到列表页面
        return getRedirectToListView();
    }

    public ModelAndView update(HttpServletRequest req, HttpServletResponse resp, UserModel userModel) {
        if ("GET".equals(req.getMethod())) {
            //如果是get请求 我们转向 更新页面
            ModelAndView mv = new ModelAndView();
            //查询要更新的数据
            mv.addObject("command", userService.get(userModel.getUsername()));
            mv.setViewName(getUpdateView());
            return mv;
        }
        userService.update(userModel);
        //直接重定向到列表页面
        return new ModelAndView(getRedirectToListView());
    }

    public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp, UserModel userModel) {
        if ("GET".equals(req.getMethod())) {
            //如果是get请求 我们转向 删除页面
            ModelAndView mv = new ModelAndView();
            //查询要更新的数据
            mv.addObject("command", userService.get(userModel.getUsername()));
            mv.setViewName(getDeleteView());
            return mv;
        }
        userService.delete(userModel);
        //直接重定向到列表页面
        return new ModelAndView(getRedirectToListView());
    }


    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();
        //列表数据
        mv.addObject("userList", userService.list());
        mv.setViewName(getListView());
        return mv;
    }

    @Override
    //如果使用委托方式，命令对象名称只能是command
    protected String getCommandName(Object command) {
        //命令对象的名字 默认command
        return "command";
    }

    /**
     * Getter for property 'userService'.
     *
     * @return Value for property 'userService'.
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Setter for property 'userService'.
     *
     * @param userService Value to set for property 'userService'.
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Getter for property 'createView'.
     *
     * @return Value for property 'createView'.
     */
    public String getCreateView() {
        return createView;
    }

    /**
     * Setter for property 'createView'.
     *
     * @param createView Value to set for property 'createView'.
     */
    public void setCreateView(String createView) {
        this.createView = createView;
    }

    /**
     * Getter for property 'updateView'.
     *
     * @return Value for property 'updateView'.
     */
    public String getUpdateView() {
        return updateView;
    }

    /**
     * Setter for property 'updateView'.
     *
     * @param updateView Value to set for property 'updateView'.
     */
    public void setUpdateView(String updateView) {
        this.updateView = updateView;
    }

    /**
     * Getter for property 'deleteView'.
     *
     * @return Value for property 'deleteView'.
     */
    public String getDeleteView() {
        return deleteView;
    }

    /**
     * Setter for property 'deleteView'.
     *
     * @param deleteView Value to set for property 'deleteView'.
     */
    public void setDeleteView(String deleteView) {
        this.deleteView = deleteView;
    }

    /**
     * Getter for property 'listView'.
     *
     * @return Value for property 'listView'.
     */
    public String getListView() {
        return listView;
    }

    /**
     * Setter for property 'listView'.
     *
     * @param listView Value to set for property 'listView'.
     */
    public void setListView(String listView) {
        this.listView = listView;
    }

    /**
     * Getter for property 'redirectToListView'.
     *
     * @return Value for property 'redirectToListView'.
     */
    public String getRedirectToListView() {
        return redirectToListView;
    }

    /**
     * Setter for property 'redirectToListView'.
     *
     * @param redirectToListView Value to set for property 'redirectToListView'.
     */
    public void setRedirectToListView(String redirectToListView) {
        this.redirectToListView = redirectToListView;
    }
}
