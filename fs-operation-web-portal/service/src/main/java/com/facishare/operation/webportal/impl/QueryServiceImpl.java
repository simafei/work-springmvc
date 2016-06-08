package com.facishare.operation.webportal.impl;

import com.facishare.operation.webportal.QueryService;
import com.facishare.operation.webportal.util.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by fengpj on 2016/6/7.
 * 通用的查询服务
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> findFirst(String sql, Object... args) {
        // 或者直接用 find(sql, args).get(0)，需判断size()>0
        Map<String, Object> result;

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, args);
        SqlRowSetMetaData metaData = rowSet.getMetaData(); // 得到元数据，获取数据库列名

        if (rowSet.next()) {
            result = formatRow(rowSet, metaData);
        } else {
            result = new HashMap<>();
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> find(String sql, Object... args) {
        List<Map<String, Object>> results = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, args);

        SqlRowSetMetaData metaData = rowSet.getMetaData(); // 得到元数据，获取数据库列名

        Map<String, Object> row;
        while (rowSet.next()) {
            row = formatRow(rowSet, metaData);
            results.add(row);
        }
        return results;
    }

    @Override
    public List<Map<String, Object>> find(String sql, List<String> keys, Object... args) {
        List<Map<String, Object>> results = new ArrayList<>();

        jdbcTemplate.query(sql, args, rs -> {
            Map<String, Object> row = new HashMap<>();
            for (String column : keys) {
                Object obj = rs.getObject(column);
                row.put(column, formatDate(obj));
            }
            results.add(row);
        });
        return results;
    }

    private Map<String, Object> formatRow(SqlRowSet rowSet, SqlRowSetMetaData metaData) {
        Map<String, Object> row = new HashMap<>();
        for (String column : metaData.getColumnNames()) {
            Object obj = rowSet.getObject(column);
            row.put(column, formatDate(obj));
        }
        return row;
    }

    //如果有日期，则按指定格式格式化为字符串
    private Object formatDate(Object obj) {
        if (obj instanceof Date) {
            return DateUtils.getBaseSimpleDateFormat().format(obj);
        }
        return obj;
    }
}
