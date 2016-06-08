package com.facishare.operation.webportal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/6/6.
 * 前天展示模板
 */
public class DisplayTemplate {

    private String name;

    private List<Map<String, Object>> dataPoints = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<Map<String, Object>> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
