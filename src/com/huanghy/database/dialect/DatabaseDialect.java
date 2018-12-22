package com.huanghy.database.dialect;


import java.io.Serializable;
import java.util.UUID;

/**
 * <pre>
 *     xxx类的简述.
 *     xxx类的详细说明第一行(可根据情况省略)
 *     xxx类的详细说明第二行(可根据情况省略)
 * </pre>
 * @author huanghy <br>create on 2018/10/10
 * @version 1.0                              (可根据情况省略)
 * @see "某个类、方法、属性(参考某个类的意思)"     (可根据情况省略)
 */
public abstract class DatabaseDialect {

    public DatabaseDialect() {
    }

    /**
     * generateId方法的简述.<br>
     * generateId方法的详细说明第一行<br>
     * generateId 方法的详细说明第二行
     * @return 返回UUID
     * @throws Exception 执行报错，则抛出Exception异常
     * <br>
     */
    public Serializable generateId() throws Exception {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * <pre>
     *     getNowString方法的简述.
     *     getNowString方法的详细说明第一行
     *     getNowString方法的详细说明第二行
     * </pre>
     *
     * @return
     */
    public abstract String getNowString();

    public abstract String getDriver();

    public abstract String to_char();

//    public abstract String to_date();


    public abstract String nvl();

}
