package com.facishare.operation.webportal;

import com.facishare.operation.webportal.model.Pair;

import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/6/7.
 * 服务号查询服务
 */
public interface SessionService extends CommonService {

    /**
     * 查询服务号的每项数据的详细情况，对于每一列都是排好序的
     * @param columns 需要查询的列
     * @param date 统计日期
     * @param period 统计的时间间隔，目前只有7，30，-1(总览)
     * @param type 官方还是自建(0:官方，1:自建)
     * @param fsExclude
     * @return
     */
    public Map<String, List<Pair>> getDetailSortListMap(List<String> columns, String date, int period, int type, boolean fsExclude);

}
