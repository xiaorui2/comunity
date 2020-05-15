package com.spring.community2;

import com.spring.community2.dao.UserMapper;
import com.spring.community2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
//        User user = userMapper.selectById(101);
//        System.out.println(user);

        User user = userMapper.selectByName("liubei");
        System.out.println(user);

//        user = userMapper.selectByEmail("nowcoder101@sina.com");
//        System.out.println(user);

        System.out.println(0);
    }
}
