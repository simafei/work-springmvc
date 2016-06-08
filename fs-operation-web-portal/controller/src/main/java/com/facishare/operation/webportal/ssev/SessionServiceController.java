package com.facishare.operation.webportal.ssev;

import com.facishare.operation.webportal.BaseParam;
import com.facishare.operation.webportal.SessionService;
import com.facishare.operation.webportal.ajax.AjaxResultUtil;
import com.facishare.operation.webportal.ajax.code.AjaxCode;
import com.facishare.operation.webportal.ajax.result.AjaxResult;
import com.facishare.operation.webportal.config.ConfigUtil;
import com.facishare.operation.webportal.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * Created by fengpj on 2016/6/7.
 * 服务号统计相关
 */
@Controller
@RequestMapping("/open/operation/webportal/ssev")
public class SessionServiceController {

    private static final String BUSINESS_NAME = "session_service";

    @Resource
    private SessionService sessionService;

    @RequestMapping(value = "/summary", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult summary(@Valid @RequestBody BaseParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResultUtil.getAjaxResult(bindingResult);
        }
        return new AjaxResult(sessionService.getDisplayTemplateList(BUSINESS_NAME, param.getStartDate(), param.getEndDate(), param.isFxExclude()));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult detail(@Valid @RequestBody DetailParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResultUtil.getAjaxResult(bindingResult);
        }
        try {
            int period = DateUtils.daysBetween(param.getStartDate(), param.getEndDate());

            List<String> detailKeys = ConfigUtil.getBusinessConfigByName(BUSINESS_NAME).getDetailKeysList();
            return new AjaxResult(sessionService.getDetailSortListMap(detailKeys, param.getEndDate(), period, param.getType(), param.isFxExclude()));
        } catch (ParseException e) {
            return new AjaxResult(AjaxCode.PARAM_ERROR, e.getMessage());
        }
    }
}
