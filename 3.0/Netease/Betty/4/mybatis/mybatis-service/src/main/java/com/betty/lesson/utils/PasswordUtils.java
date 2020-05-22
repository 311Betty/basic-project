package com.betty.lesson.utils;

import java.util.UUID;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName PasswordUtils.java
 * @Description TODO
 * @createTime 2020年05月21日 16:03:00
 */
public class PasswordUtils {
    /**
     * 匹配密码
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文加密
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
