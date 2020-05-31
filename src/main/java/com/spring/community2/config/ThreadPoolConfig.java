package com.spring.community2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName ThreadPoolConfig
 * @Author ruizhou
 * @Date 2020/5/31 15:38
 **/
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}

