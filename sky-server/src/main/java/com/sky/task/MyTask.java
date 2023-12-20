package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */


/**
* 自定义的定时任务类
* */
@Component
@Slf4j
public class MyTask {

    /*
     * 定时任务，每隔五秒触发一次
     * */
//    @Scheduled(cron = "0/5 * * * * ?")
    public void executeTask() {
        log.info("定时服务启动:{}",new Date());
    }
}
