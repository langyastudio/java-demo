package com.servlet.common;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 监听器 —— 监听Web容器的有效期事件，由容器管理。
 *
 * 例如ServletContext（Web应用程序的生命周期方法）、HttpSession、ServletRequest 等
 */
public class UserInfoTrace implements HttpSessionBindingListener {
    private String user;
    private UserInfoList container = UserInfoList.getInstance();

    public UserInfoTrace()
    {
        user = "";
    }

    /**
     * 设置在线监听人员
     *
     * @param userName
     */
    public void setUser(String userName)
    {
        this.user = userName;
    }

    /**
     * 获取在线监听人员
     *
     * @return
     */
    public String getUser()
    {
        return this.user;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("上线" + this.user);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("下线" + this.user);

        if(this.user.compareTo("") != 0)
        {
            this.container.removeUserInfo(this.user);
        }
    }
}
