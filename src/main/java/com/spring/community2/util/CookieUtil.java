package com.spring.community2.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CookieUtil
 * @Author ruizhou
 * @Date 2020/5/22 22:15
 **/
public class CookieUtil {
    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        if (httpServletRequest == null || name == null) {
            throw new IllegalArgumentException("参数为空！");
        }

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
