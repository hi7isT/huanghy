package com.huanghy.database.dialect;

public class MySQLDialect extends DatabaseDialect {


    private static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_TYPE = "mysql";

    public MySQLDialect() {
    }

    public String getDriver() {
        return DRIVER;
    }

    public String getNowString() {
        return "now()";
    }

    @Override
    public String to_char() {
        return "str_to_char(current_date,'%Y-%m-%d')";
    }

    @Override
    public String nvl() {
        return "ifnull";
    }

//    @Override
//    public String to_date() {
//        return "date_format(current_date,'')";
//    }

}
