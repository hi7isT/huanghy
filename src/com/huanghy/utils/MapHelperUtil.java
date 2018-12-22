package com.huanghy.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huanghy on 2018/10/10.
 */
public class MapHelperUtil {

    private static final String SERIAL_VERSION_UID = "serialVersionUID";
    private static final String ALIAS = "ALIAS";

    /**
     * 将Map<String, Object>转成List<Map<String, String>>
     * @param maps  map集合
     * @return  List集合
     */
    public static List<Map<String, String>> MapTypeChange(Map<String, Object> maps) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for(Map.Entry<String, Object> mapOfObj:maps.entrySet()){
            Map<String, String> map = new HashMap<String, String>();
            map.put(mapOfObj.getKey(), (mapOfObj.getValue() != null) ? String.valueOf(mapOfObj.getValue()) : "");
            result.add(map);
        }
        return result;
    }

    /**
     * 利用反射将对象转换成Map
     * @param obj   要转换的对象
     * @param <T>   泛型，T这里是对象具体传入的类型
     * @return  Map<String, String>
     */
    public static <T> Map<String, String> beanToMap(T obj) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                if (!SERIAL_VERSION_UID.equals(fieldName) && !fieldName.startsWith(ALIAS) && !fieldName.endsWith(ALIAS))
                    map.put(fieldName, (value != null) ? String.valueOf(value) : "");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }
}
