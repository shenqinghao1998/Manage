package com.ruoyi.common.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanglin
 * @version 1.0
 * @date 2022-02-21 周一
 */
public class CalculateDateUtil {
    public static final Integer ONE = 1;
    public static final Integer THREE = 3;
    public static final Integer SIX = 6;

    /**
     * 加/减——秒
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 加/减——分钟
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 加/减——小时
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 加/减——天
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 加/减——周
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 加/减——月
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 加/减——年
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("df.format(now) = " + df.format(now));
        System.out.println("df.format(addDateSeconds(now,-1)) = " + df.format(addDateSeconds(now, -1)));
        System.out.println("df.format(addDateMinutes(now,-1)) = " + df.format(addDateMinutes(now, -1)));
        System.out.println("df.format(addDateHours(now,-1)) = " + df.format(addDateHours(now, -1)));
        System.out.println("df.format(addDateDays(now,-1)) = " + df.format(addDateDays(now, 1)));
        System.out.println("df.format(addDateWeeks(now,-1)) = " + df.format(addDateWeeks(now, 1)));
        System.out.println("df.format(addDateMonths(now,-1)) = " + df.format(addDateMonths(now, 1)));
        System.out.println("df.format(addDateYears(now,-1)) = " + df.format(addDateYears(now, 1)));
    }
}