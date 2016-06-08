package com.facishare.operation.webportal.config;

import org.apache.commons.digester3.Digester;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigUtil {

    private static final Logger logger = Logger.getLogger(ConfigUtil.class.getName());

    private static Map<String,BusinessConfig> configTemplateMap = new HashMap<String,BusinessConfig>();

    public static BusinessConfig getBusinessConfigByName(String businessName) {
        return configTemplateMap.get(businessName);
    }

    public static void  initConfigTemplate() {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("business/configs", ConfigList.class);
        digester.addObjectCreate("business/configs/config", BusinessConfig.class);
        digester.addSetProperties("business/configs/config");
        digester.addBeanPropertySetter("business/configs/config/nameKeys", "nameKeys");
        digester.addBeanPropertySetter("business/configs/config/dataPointKeys", "dataPointKeys");
        digester.addBeanPropertySetter("business/configs/config/totalDataPointKeys", "totalDataPointKeys");
        digester.addBeanPropertySetter("business/configs/config/detailKeys", "detailKeys");
        digester.addSetNext("business/configs/config", "addConfig");
        try {
            URL fileUrl = ConfigUtil.class.getClassLoader().getResource("/business-config.xml");
            ConfigList configList = digester.parse(fileUrl);
            for (BusinessConfig template : configList.getConfigs()) {
                configTemplateMap.put(template.getName(), template);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "init configuration error!");
        }
    }

}
