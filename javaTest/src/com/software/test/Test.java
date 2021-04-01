package com.software.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
//        System.out.println(getEventDate("18/03 00:00:00 "));
        System.out.println(formatStringDate("2020-12-04 02:00:00","yyyy-MM-dd HH:mm:ss","M.d"));
        System.out.println(formatStringDate("2020-03-30 02:00:00","yyyy-MM-dd HH:mm:ss","HH"));
        System.out.println(getDistanceTimemin("2020-07-25 19:32:00"));


    }


    public static String getDistanceTimemin(String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one=null;
        Date two = null;
        long day = 0;//天数差
        long hour = 0;//小时数差
        long min = 0;//分钟数差
        long second=0;//秒数差
        try {
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            one = c.getTime();
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            diff = time2 - time1;

            day = diff / (24 * 60 * 60 * 1000);
            //            Log.i("lgq","diff--==="+diff+"...one="+time1+"..-----.two==="+time2);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            second = diff/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(day==0){
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            String str=df2.format(two);
            return String.format("今天：%s",str);
        }
        if(day==1){
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            String str=df2.format(two);
            return String.format("明天：%s",str);
        }
        if(day==2){
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            String str=df2.format(two);
            return String.format("后天：%s",str);
        }
        return String.format("%s天%s小时",day,hour);
    }


    public static  String getEventDate(String eventdate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date date = null;
        try {
            date = formatter.parse(eventdate);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
            String sDate = sdf.format(date);
            return sDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String formatStringDate(String strDate, String format,String after) {
        String afterstr;
        try {
            Date date = getDateByFormat(strDate,format);
            afterstr = new SimpleDateFormat(after, Locale.getDefault()).format(date);
        } catch (Exception e) {
            return strDate;
        }
        return afterstr;
    }

    public static Date getDateByFormat(String strDate, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
