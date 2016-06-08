package com.facishare.operation.webportal.ssev;

import com.facishare.operation.webportal.BaseParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by fengpj on 2016/6/8.
 * 获取服务号明细参数
 */
public class DetailParam extends BaseParam {

    @Max(value = 1)
    @Min(value = -1)
    private int type = -1; //0 官方， 1 自建

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
