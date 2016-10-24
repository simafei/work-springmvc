package com.commence.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by fengpj on 2016/6/8.
 * 查询基础参数
 */
public class BaseParam {

    @NotNull(message = "date不允许为空!")
    @Pattern(regexp = "^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])$", message = "date格式不符合yyyy-MM-dd")
    protected String date;

    @Max(value = 10, message = "最大值不能超过10")
    protected int value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
