package com.facishare.operation.webportal.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengpj on 2016/6/7.
 */
public class ConfigList {

    private List<BusinessConfig> configs = new ArrayList<>();

    public List<BusinessConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<BusinessConfig> configs) {
        this.configs = configs;
    }

    public void addConfig(BusinessConfig config) {
        configs.add(config);
    }
}
