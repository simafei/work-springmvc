package com.facishare.operation.webportal.app;

import com.facishare.operation.webportal.AppUsageService;
import com.facishare.operation.webportal.ajax.result.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by fengpj on 2016/6/6.
 * App Usage
 */
@Controller
@RequestMapping("/open/operation/webportal/appUsage")
public class AppUsageController {

    @Resource
    private AppUsageService appUsageService;

    @RequestMapping("dataList")
    @ResponseBody
    public AjaxResult getAppUsageDataList() {
        return new AjaxResult("");
    }
}
