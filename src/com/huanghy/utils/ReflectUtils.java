package com.huanghy.utils;


import com.huanghy.sys.SysConstants;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre><b>&nbsp;--描述说明--</b></pre>
 * <pre>
 *     反射工具类.
 *     用于处理java对象加密事宜，比如加密UserInfo的部分信息
 *</pre>
 */

public class ReflectUtils {

    /**  
    * 名单加密.<br>
    * @param   t    加密对象
    * @param   nohandleFields   不处理字段
    * @param   noHideFields   不加密字段
    * @return obj   加密后对象
    * @throws Exception 反射使用异常
    */
    public static <T> Object hideInfoWithoutSomething(T t,String nohandleFields,String noHideFields) throws Exception {
        Class<?> clazz = t.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (nohandleFields.contains(fieldName) || "serialVersionUID".equals(fieldName) ||
                    fieldName.startsWith("ALIAS") || fieldName.endsWith("ALIAS")) {
                continue;
            }
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            if(pd == null)continue;
            Method writeMethod = pd.getWriteMethod();
            if (noHideFields.contains(fieldName)) {
                writeMethod.invoke(t, field.get(t));
                continue;
            }

            if (field.getType().equals(String.class)) {
                writeMethod.invoke(t, field.get(t) != null ? SysConstants.JMGZ : null);
            } else if (field.getType().equals(BigDecimal.class)) {
                writeMethod.invoke(t, field.get(t) != null ? SysConstants.JMGZ_BIGDECIMAL : null);
            } else if (field.getType().equals(Date.class)) {
                writeMethod.invoke(t, field.get(t) != null ? SysConstants.JMGZ_DATE : null);
            }
        }
        return t;
    }
}
