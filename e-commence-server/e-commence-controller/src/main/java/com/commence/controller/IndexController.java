package com.commence.controller;

import com.commence.controller.ajax.AjaxResult;
import com.commence.controller.ajax.AjaxResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by fengpj on 2016/6/1.
 * 测试用
 */
@Controller
public class IndexController {

    // POST Form 形式提交的参数
    @RequestMapping("test1")
    @ResponseBody
    public AjaxResult test1(@Valid BaseParam baseParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResultUtil.getAjaxResult(bindingResult);
        }
        return new AjaxResult("SUCCESS");
    }

    // JSON 形式提交的参数
    @RequestMapping("test2")
    @ResponseBody
    public AjaxResult test2(@Valid @RequestBody BaseParam baseParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return AjaxResultUtil.getAjaxResult(bindingResult);
        }
        return new AjaxResult("SUCCESS");
    }
}
