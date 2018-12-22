package com.huanghy.database.dialect;

public class OracleDialect extends DatabaseDialect {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DATABASE_TYPE = "oracle";

    public OracleDialect() {
    }

    public String getDriver() {
        return DRIVER;
    }

    public String getNowString() {
        return "SYSDATE";
    }

    @Override
    public String to_char() {
        return "to_char(SYSDATE,'YYYY-MM-DD')";
    }

    @Override
    public String nvl() {
        return "nvl";
    }

//    @Override
//    public String to_date() {
//        return "to_date(SYSDATE,'"+dateFormat+"')";
//    }


}
