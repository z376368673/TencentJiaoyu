package com.library.common.utils;

import android.text.TextUtils;

import java.text.SimpleDateFormat;

/**
 * Created by Orz on 2020/1/2.
 * Describe:
 */
public class TimeUtil {

    public static final String DATE_FORMAT_DEFAULT = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";


    /**
     * 返回当前时间的格式为 yyyyMMddHHmmss
     *
     * @return
     */

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT);
        return sdf.format(System.currentTimeMillis());
    }


    public static String millisToDateString(long timeMillis)
    {
        return millisToDateString(timeMillis , DATE_FORMAT_DEFAULT);
    }


    public static String millisToDateString(long timeMillis , String dateFormat)
    {
        if(TextUtils.isEmpty(dateFormat))
        {
           return millisToDateString(timeMillis);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(timeMillis);
    }



    //毫秒转秒
    public static String long2String(long time) {
        //毫秒转秒
        int sec = (int) time / 1000;
        int min = sec / 60;    //分钟
        sec = sec % 60;        //秒
        if (min < 10) {    //分钟补0
            if (sec < 10) {    //秒补0
                return "0" + min + ":0" + sec;
            } else {
                return "0" + min + ":" + sec;
            }
        } else {
            if (sec < 10) {    //秒补0
                return min + ":0" + sec;
            } else {
                return min + ":" + sec;
            }
        }

    }



    /**
     * 毫秒转化时分秒毫秒
     *
     * @param ms
     * @return
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "d");
        }
        if (hour > 0) {
            sb.append(hour + "h");
        }
        if (minute > 0) {
            sb.append(minute + "′");
        }
        if (second > 0) {
            sb.append(second + "″");
        }
        return sb.toString();
    }
}
