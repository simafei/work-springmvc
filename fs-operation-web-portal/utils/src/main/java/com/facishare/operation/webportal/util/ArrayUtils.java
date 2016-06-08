package com.facishare.operation.webportal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fengpj on 2016/6/7.
 * 数组操作工具类
 */
public class ArrayUtils {

    public static List<String> filterIllegalColumn(List<String> columns) {
        List<String> filterColumns = columns.stream().filter(column -> !column.matches(".*[\\(|\\)].*")).map(String::trim).collect(Collectors.toList());
        return filterColumns;
    }
}
