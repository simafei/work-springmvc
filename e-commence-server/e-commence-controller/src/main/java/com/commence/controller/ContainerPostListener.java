package com.commence.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("containerPostListener")
public class ContainerPostListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(ContainerPostListener.class.getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //TODO 启动时调用
        logger.info("Init ContainerPostListener start");
    }

}
