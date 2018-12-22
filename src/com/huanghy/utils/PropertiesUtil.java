package com.huanghy.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
///**
// * Created by huanghy on 2018/9/7.
// */
//public class PropertiesUtil {
//
//    public static Properties PROPERTIES;
//    public static final String RESOURCE = "resource/duceap.properties";
//    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
//
//
//    public static String getProperty(String key) {
//        if (PROPERTIES == null) {
//            PROPERTIES = loadPriorityProperties(RESOURCE);
//        }
//        String value = PROPERTIES.getProperty(key);
//        logger.info(key + ":" + value);
//        return value;
//    }
//
//    private static Properties loadPriorityProperties(String var0) {
//        Resource resource = new ClassPathResource(var0);
//        Properties properties = new Properties();
//        InputStream is = null;
//        try {
//            is = resource.getInputStream();
//            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            properties.load(bf);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return properties;
//    }
//}
