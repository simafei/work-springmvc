package com.facishare.operation.webportal.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fengpj on 2016/6/7.
 */
public class BusinessConfig {

    private String name;
    private String dataPointKeys;
    private String totalDataPointKeys;
    private String detailKeys;

    public String getDetailKeys() {
        return detailKeys;
    }

    public void setDetailKeys(String detailKeys) {
        this.detailKeys = detailKeys;
    }

    public void setDataPointKeys(String dataPointKeys) {
        this.dataPointKeys = dataPointKeys;
    }

    public List<String> getTotalDataPointKeysList() {
        return Arrays.asList(totalDataPointKeys.split(","));
    }

    public void setTotalDataPointKeys(String totalDataPointKeys) {
        this.totalDataPointKeys = totalDataPointKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataPointKeys() {
        return dataPointKeys;
    }

    public String getTotalDataPointKeys() {
        return totalDataPointKeys;
    }

    public List<String> getDataPointKeysList() {
        return Arrays.asList(dataPointKeys.split(","));
    }

    public List<String> getDetailKeysList() {
        return Arrays.asList(detailKeys.split(","));
    }
}
