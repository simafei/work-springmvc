package com.facishare.operation.webportal;

import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/6/7.
 */
public interface QueryService {

    /**
     * 根据sql查询出一条记录
     * @param sql 查询语句
     * @param args 查询参数
     * @return 返回键值对应的map
     */
    Map<String, Object> findFirst(String sql, Object... args);

    /**
     * 根据sql查询记录
     * @param sql 查询语句
     * @param args 查询参数
     * @return 返回键值对应的map的List
     */
    List<Map<String, Object>> find(String sql, Object... args);

    /**
     * 根据sql查询记录
     * @param sql 查询语句
     * @param keys 只获取给定的键值
     * @param args 查询参数
     * @return 返回键值对应的map的List
     */
    List<Map<String, Object>> find(String sql, List<String> keys, Object... args);
}
