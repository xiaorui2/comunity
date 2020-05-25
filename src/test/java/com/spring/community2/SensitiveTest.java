package com.spring.community2;

/**
 * @ClassName SensitiveTest
 * @Author ruizhou
 * @Date 2020/5/23 22:06
 **/

import com.spring.community2.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SensitiveTest {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "这里可以赌博,可以嫖娼,可以吸毒,可以开票,哈哈哈!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

    }
}
