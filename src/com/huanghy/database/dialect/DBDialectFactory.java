package com.huanghy.database.dialect;


import com.huanghy.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库工厂DBDialectFactory<br>
 * </>当一个项目需要用到多种数据库时候，可以通过DBDialectFactory来实现。
 */
public class DBDialectFactory {

    /**
     * 属性
     */
    public static final DatabaseDialect ORACLE = new OracleDialect();
    public static final DatabaseDialect MYSQL = new MySQLDialect();
    private static Map<String, Object> dialects = new HashMap();

    public static DatabaseDialect getDialect(String dbType) {
        return (DatabaseDialect)dialects.get(dbType);
    }

    public static DatabaseDialect getDialect() {
        //TODO 获取properties中的具体是哪个数据库
        String dialectString = "";
        /*String dialectString = SystemGlobalConfig.databaseType;*/
        if (StringUtils.isBlank(dialectString)) {
            throw new UnsupportedOperationException("未配置[databaseType]参数，请检查duceap.properties配置文件");
        } else {
            DatabaseDialect dialect = getDialect(dialectString.toUpperCase());
            if (dialect == null) {
                throw new UnsupportedOperationException("不支持的数据库类型[" + dialectString + "]");
            } else {
                return dialect;
            }
        }
    }

    public static String getDialectName() {
        //TODO 获取properties中的具体是哪个数据库
        return "";
        /*return SystemGlobalConfig.databaseType.toLowerCase();*/
    }

    static {
        dialects.put("ORACLE", ORACLE);
        dialects.put("MYSQL", MYSQL);
    }

}
