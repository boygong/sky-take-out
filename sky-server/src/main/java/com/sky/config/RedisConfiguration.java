package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */

@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建Redis模板对象...");
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置Redis的连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置Redis key 的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
