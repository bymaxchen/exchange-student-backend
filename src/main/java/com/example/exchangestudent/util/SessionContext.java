package com.example.exchangestudent.util;

import com.alibaba.fastjson2.JSONObject;

public class SessionContext {
    private static final ThreadLocal<JSONObject> context = ThreadLocal.withInitial(JSONObject::new);

    public static String getEmail() {
        return context.get().getString("email");
    }

    public static void setEmail(String email) {
        context.get().put("email", email);
    }

    public static String getUserName() {
        return context.get().getString("userName");
    }

    public static void setUserName(String userName) {
        context.get().put("userName", userName);
    }

    public static Long getUserId() {
        return context.get().getLong("userId");
    }

    public static void setUserId(Long userId) {
        context.get().put("userId", userId);
    }
}
