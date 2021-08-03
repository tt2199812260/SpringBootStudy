package com.mingdev.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//zookeeper：服务注册与发现

@Service  //可以被扫描到，项目已启动就会被注册到注册中心
@org.springframework.stereotype.Service
//@Component  //这里使用了dubbo后尽量不用service注解
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "《MingDev》";
    }
}
