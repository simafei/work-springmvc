package com.commence.controller.ajax;

import com.commence.controller.ajax.AjaxCode;

/**
 * 用于ajax返回
 * 
 * @author huanghp
 * @date 2016年02月25日
 */
public class AjaxResult {
    private Integer errCode = AjaxCode.OK;
    private String errMsg = "OK";
    private Object data;
    private int dataCount;

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public AjaxResult(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public AjaxResult(Object data) {
        this(AjaxCode.OK, "OK");
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "AjaxResult [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + "]";
    }
    
}
