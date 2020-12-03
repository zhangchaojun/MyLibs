package com.cj.baselibrary.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author superFan
 * date: 2019/9/19/019 09:11
 * Copyright (c) 2019 hezhongweiqi.Co.Ltd. All rights reserved.
 * description: 日期操作工具类
 */
public class DateUtil {
    /**
     * 默认地区
     */
    private static Locale mDefLocale = Locale.getDefault();

    private static final SimpleDateFormat sdf_yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", mDefLocale);
    private static final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd", mDefLocale);

    public static Date stringToDate(String dateString) {
        ParsePosition position = new ParsePosition(0);
        Date dateValue = sdf_yyyyMMddHHmmss.parse(dateString, position);
        return dateValue;
    }

    /**
     * 判断两个时间是否相隔一天
     *
     * @param date1 yyyy-MM-dd HH:mm:ss 开始时间
     * @param date2 yyyy-MM-dd HH:mm:ss 结束时间
     * @return
     */
    public static boolean isOverOneDay(String date1, String date2) {
        Date startTime = stringToDate(date1);
        Date endTime = stringToDate(date2);
        long between = endTime.getTime() - startTime.getTime();
        if (between > (24 * 3600000)) {
            return true;
        }
        return false;
    }
    /**
     * 判断两个时间是否相隔3天
     *
     * @param date1 yyyy-MM-dd HH:mm:ss 开始时间
     * @param date2 yyyy-MM-dd HH:mm:ss 结束时间
     * @return
     */
    public static boolean isOverThreeDay(String date1, String date2) {
        Date startTime = stringToDate(date1);
        Date endTime = stringToDate(date2);
        long between = endTime.getTime() - startTime.getTime();
        if (between > (72 * 3600000)) {
            return true;
        }
        return false;
    }
    /**
     * 获取时间 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date 为null时，是获取当前时间
     * @return
     */
    public static String getTime_yMdHms(Date date) {
        date = date == null ? new Date() : date;
        return sdf_yyyyMMddHHmmss.format(date);
    }

    /**
     * 获取某个日期的下一天 yyyy-MM-dd HH:mm:ss
     *
     * @param date 如果为null 就是今天
     * @return
     */
    public static String getNextDay_yMdHms(Date date) {
        date = date == null ? new Date() : date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + 1);
        return sdf_yyyyMMddHHmmss.format(calendar.getTime());
    }

    /**
     * 获取日期 格式为 yyyy-MM-dd
     *
     * @param date 如果为null 就是今天
     * @return
     */
    public static String getDay_yMd(Date date) {
        date = date == null ? new Date() : date;
        return sdf_yyyyMMdd.format(date);
    }
}
