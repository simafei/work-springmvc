package com.facishare.operation.webportal;

import com.facishare.operation.webportal.config.ConfigUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("containerPostListener")
public class ContainerPostListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(ContainerPostListener.class.getName());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // init the template configuration
        ConfigUtil.initConfigTemplate();
        
        logger.info("Init ContainerPostListener start");
    }

}
