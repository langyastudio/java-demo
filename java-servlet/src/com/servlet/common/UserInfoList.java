package com.servlet.common;

import java.util.HashSet;

public class UserInfoList {
    private static UserInfoList user     = new UserInfoList();
    private        HashSet      userHash = null;

    public UserInfoList() {
        this.userHash = new HashSet();
    }

    public static UserInfoList getInstance() {
        return user;
    }

    public boolean addUserInfo(String userName) {
        if (userName != null) {
            userHash.add(userName);
            return true;
        }
        else {
            return false;
        }
    }

    public void removeUserInfo(String userName) {
        if (userName != null) {
            userHash.remove(userName);
        }
    }

    public HashSet getList() {
        return userHash;
    }
}
