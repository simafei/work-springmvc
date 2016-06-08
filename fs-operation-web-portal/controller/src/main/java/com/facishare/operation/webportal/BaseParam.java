package com.facishare.operation.webportal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by fengpj on 2016/6/8.
 * 查询基础参数
 */
public class BaseParam {

    @NotNull(message = "startDate不允许为空!")
    @Pattern(regexp = "^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])$", message = "startDate格式不符合yyyy-MM-dd")
    protected String startDate;

    @NotNull(message = "endDate不允许为空!")
    @Pattern(regexp = "^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])$", message = "endDate格式不符合yyyy-MM-dd")
    protected String endDate;

    protected boolean fxExclude;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setFxExclude(boolean fxExclude) {
        this.fxExclude = fxExclude;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean isFxExclude() {
        return fxExclude;
    }
}
