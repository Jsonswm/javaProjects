package com.ming.logistics.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {


    public String formatTime(Date  date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newTime = sdf.format(date);
//        String nowTime = sdf.format(new Date());
//        System.out.println(nowTime);
        boolean flag = newTime instanceof String;
        System.out.println(flag);
        return  newTime;
    }

    public static void main(String[] args) {
        TimeFormat timeFormat = new TimeFormat();
        Date date = new Date("Thu Mar 23 2023 18:52:35 GMT+0800 (中国标准时间)");
        timeFormat.formatTime(date);
    }


    /**
     * @description: String类型时间转为date类型
     * @param: strTime
     * @return: java.util.Date
     * @author swm
     * @date: 2023/3/23 16:39
     */
    public  Date stringToDate(String strTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(strTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @description: String类型时间转换为timestamp
     * @param: strTime
     * @return: java.sql.Timestamp
     * @author swm
     * @date: 2023/3/23 16:42
     */
    public  Timestamp stringToTimestamp(String strTime) {
        Date date = stringToDate(strTime);
        return new Timestamp(date.getTime());
    }


}
