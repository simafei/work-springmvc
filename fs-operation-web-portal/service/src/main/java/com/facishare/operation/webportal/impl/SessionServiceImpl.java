package com.facishare.operation.webportal.impl;

import com.facishare.operation.webportal.SessionService;
import com.facishare.operation.webportal.model.Pair;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengpj on 2016/6/7.
 * 服务号统计相关的查询服务
 */
@Service("sessionService")
public class SessionServiceImpl extends CommonServiceImpl implements SessionService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, List<Pair>> getDetailSortListMap(List<String> columns, String date, int scope, int type, boolean fsExclude) {
        Map<String, List<Pair>> listMap = new HashMap<>();

        for (String column : columns) {
            column = column.trim();
            listMap.put(column, getColumnPairs(column, date, scope, type, fsExclude));
        }

        return listMap;
    }

    private List<Pair> getColumnPairs(String column, String date, int scope, int type, boolean fsExclude) {
        List<Pair> pairs = new ArrayList<>();

        String tableName = "session_service_detail_data";
        String sql = "SELECT name, sum(%s) as %s FROM %s where scope=? and fs_exclude=? and stat_date=? %s group by ssid, name order by %s desc";

        String asColumn = column + "_total";

        String typeQuery = "";
        if (type >= 0) {  // -1 代表企业和自建要一起统计，大于0则单独统计
            typeQuery += " and type=" + type;
        }
        String finalSql = String.format(sql, column, asColumn, tableName, typeQuery, asColumn);

        jdbcTemplate.query(finalSql, new Object[]{scope, fsExclude, date}, rs -> {
            Pair pair = new Pair();
            pair.setKey(rs.getString("name"));
            pair.setValue(rs.getObject(asColumn));
            pairs.add(pair);
        });
        return pairs;
    }
}
