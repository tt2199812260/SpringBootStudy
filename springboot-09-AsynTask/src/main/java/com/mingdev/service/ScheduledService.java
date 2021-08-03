package com.mingdev.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    @Scheduled(cron = "20 * * * * ?")
    public void hello(){
        System.out.println("hello,定时执行");
    }
}
