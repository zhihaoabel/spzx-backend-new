package com.abel.model.utils;

import com.abel.model.vo.system.UserInfoVo;

public class ContextUtil {

    private static final ThreadLocal<UserInfoVo> userThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> tokenThreadLocal = new ThreadLocal<>();

    public static void setUser(UserInfoVo userInfo) {
        userThreadLocal.set(userInfo);
    }

    public static void setToken(String token) {
        tokenThreadLocal.set(token);
    }

    public static UserInfoVo getUser() {
        return userThreadLocal.get();
    }

    public static String getToken() {
        return tokenThreadLocal.get();
    }

    public static void removeUser() {
        userThreadLocal.remove();
    }

    public static void removeToken() {
        tokenThreadLocal.remove();
    }

    public static void removeAll() {
        removeUser();
        removeToken();
    }
}
