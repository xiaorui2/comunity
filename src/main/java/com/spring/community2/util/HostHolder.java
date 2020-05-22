package com.spring.community2.util;

import com.spring.community2.entity.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName HostHolder
 * @Author ruizhou
 * @Date 2020/5/22 22:19
 **/
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
