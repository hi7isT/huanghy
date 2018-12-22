package com.huanghy.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by huanghy on 2018/10/16.
 */
public class DateUtils {

    /**
     * 计算两个日期差多少天 忽略小时等
     *
     * @param nowdate 当前日期2018-10-16 09:12:12
     * @param date    2016-10-12 16:12:12
     * @return result:4
     */
    public static int calculationToDays(Date nowdate, Date date) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(date);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(nowdate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }
}
