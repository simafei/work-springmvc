package com.commence.controller.ajax;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fengpj on 2016/6/7.
 */
public class AjaxResultUtil {

    public static AjaxResult getAjaxResult(BindingResult bindingResult){
        List<ObjectError> errors = bindingResult.getAllErrors();
        List<String> messages = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
        AjaxResult ajaxResult = new AjaxResult(AjaxCode.PARAM_ERROR, "参数错误!");
        ajaxResult.setData(messages);
        return ajaxResult;
    }
}
