package com.xuanf.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(cron = "0/2 * * * * ?")
    public void helloScheduled(){
        System.out.println("hello,你被执行了...");
    }
}
