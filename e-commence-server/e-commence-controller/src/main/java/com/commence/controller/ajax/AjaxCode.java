package com.commence.controller.ajax;

/**
 * 返回页面的请求错误信息，一般 非0表示有异常。
 * 
 * @author huanghp
 * @date 2016年02月25日
 */
public interface AjaxCode {
    /**
     * 请求处理成功
     */
    int OK = 0;
    /**
     * 权限不足,403 表示登录有问题,或者非网站管理员
     */
    int NO_AUTHORITY = 403;

    /**
     * 参数校验错误,400 一般表示参数有问题
     */
    int PARAM_ERROR = 400;
    /**
     * 业务异常
     */
    int BIZ_EXCEPTION = 500;

    /**
     * 无法识别的异常
     */
    int UNKNOWN_EXCEPTION = 550;
}
