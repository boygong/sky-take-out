package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 * 配置类，用于创建AliOssUtil对象
 */

@Configuration
@Slf4j
public class OssConfiguration {
    @Bean
    @ConditionalOnMissingBean //保证容器中只有一个bean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){
        log.info("开始创建阿里云文件上传工具对象：{}",aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint()
                , aliOssProperties.getAccessKeyId()
                , aliOssProperties.getAccessKeySecret()
                , aliOssProperties.getBucketName());
    }
}
