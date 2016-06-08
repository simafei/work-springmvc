package com.facishare.operation.webportal.impl;

import com.facishare.operation.webportal.CommonService;
import com.facishare.operation.webportal.QueryService;
import com.facishare.operation.webportal.config.BusinessConfig;
import com.facishare.operation.webportal.config.ConfigUtil;
import com.facishare.operation.webportal.model.DisplayTemplate;
import com.facishare.operation.webportal.util.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/5/30.
 * 通用业务查询服务
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    private static final Logger logger = Logger.getLogger(CommonServiceImpl.class);

    @Resource
    private QueryService queryService;

    @Override
    public List<DisplayTemplate> getDisplayTemplateList(String businessName, String startDate, String endDate, boolean fsExclude) {
        BusinessConfig config = ConfigUtil.getBusinessConfigByName(businessName);
        String tableName = String.format("%s_data", businessName);

        List<String> keys = ArrayUtils.filterIllegalColumn(config.getDataPointKeysList());
        String sql = String.format("SELECT * FROM %s where stat_date>? and stat_date<? and fs_exclude=?", tableName);

        List<Map<String, Object>> data = queryService.find(sql, keys, startDate, endDate, fsExclude);

        return format(data);
    }

    private List<DisplayTemplate> format(List<Map<String, Object>> data) {
        List<DisplayTemplate> displayTemplateList = new ArrayList<>();

        DisplayTemplate template;
        for (Map<String, Object> row : data) {
            template = new DisplayTemplate();
            template.getDataPoints().add(row);
            displayTemplateList.add(template);
        }
        return displayTemplateList;
    }

//    private List<DisplayTemplate> formatByName(List<Map<String, Object>> data) {
//        List<DisplayTemplate> displayTemplateList = new ArrayList<>();
//
//        Map<String, DisplayTemplate> classifyMap = new HashMap<>();
//        for (Map<String, Object> row : data) {
//            String name = (String) row.get("name");
//            DisplayTemplate template = classifyMap.get(name);
//            if (template == null) {
//                template = new DisplayTemplate();
//                template.setName(name);
//                classifyMap.put(name, template);
//            }
//            template.getDataPoints().add(row);
//        }
//        displayTemplateList.addAll(classifyMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
//        return displayTemplateList;
//    }

}
