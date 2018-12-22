package com.huanghy.utils;

import java.util.List;

/**
 * Created by huanghy on 2018/10/12.<br>
 * 数据库操作工具类
 * <p>数据库操作辅助工具，可以实现多参数转成带单引号</p>
 */
public class DataBaseHelperUtils {

    /**
     * 将List<String>转成String    格式: "'123','456'"
     * @param listIds
     * @return  字符串
     */
    public static String toSearchParams(List<String> listIds) {
        String searchParams = "";
        for (String s : listIds) {
            if (s != null)
                searchParams += "'" + s + "',";
        }
        if (StringUtils.isNotEmpty(searchParams)) {
            searchParams = searchParams.substring(0, searchParams.length() - 1);
        }
        return searchParams;
    }
}
