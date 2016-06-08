package com.facishare.operation.webportal;

import com.facishare.operation.webportal.model.DisplayTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/6/1.
 * 通用的业务查询服务
 */
public interface CommonService {

    /**
     * 获取应用使用情况
     * @param businessName 业务名称
     * @param startDate 开始时间 格式为 yyyy-MM-dd
     * @param endDate 结束时间 格式为 yyyy-MM-dd
     * @param fsExclude 是否排除纷享用户
     * @return
     */
    public List<DisplayTemplate> getDisplayTemplateList(String businessName, String startDate, String endDate, boolean fsExclude);
}
