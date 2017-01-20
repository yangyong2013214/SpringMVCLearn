package com.ycsoft.test;


import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yong on 2017/1/18 0018.
 */
public class DateTimeExample {
    private static final String FORMATE_DATE = "yyyy-MM-dd";
    private static final String FORMATE_SECONDS = "HH:mm:ss";
    private static final String FORMATE_FULL = FORMATE_DATE.concat(" ").concat(FORMATE_SECONDS);

    public static void main(String[] args) {
        /*
        // 107天之后的日期
        System.out.println(DateTime.now().dayOfYear().addToCopy(107).toString(FORMATE_DATE));

        // 当前周的周一，周日
        System.out.println(String.format("min:%s, max:%s",
                DateTime.now().dayOfWeek().withMinimumValue().toString(FORMATE_DATE),
                DateTime.now().dayOfWeek().withMaximumValue().toString(FORMATE_DATE)));

        // 当前月的第一天，最后一天
        System.out.println(String.format("min:%s, max:%s",
                DateTime.now().dayOfMonth().withMinimumValue().toString(FORMATE_DATE),
                DateTime.now().dayOfMonth().withMaximumValue().toString(FORMATE_DATE)));

        // 当前年的第一天，最后一天
        System.out.println(String.format("min:%s, max:%s",
                DateTime.now().dayOfYear().withMinimumValue().toString(FORMATE_DATE),
                DateTime.now().dayOfYear().withMaximumValue().toString(FORMATE_DATE)));

        DateTime start = new DateTime(2014, 5, 30, 20, 11, 40);
        DateTime now = DateTime.now();

        System.out.println("now: " + now.toString(FORMATE_FULL));
        System.out.println("now format with Locale.CHINESE: " + now.toString(FORMATE_FULL, Locale.CHINESE));

        System.out.println("before now 11 days: " + now.minusDays(11).toString(FORMATE_FULL));
        System.out.println("before now 15 hours: " + now.minusHours(15).toString(FORMATE_FULL));

        System.out.println("after now 30 days: " + now.plusDays(30).toString(FORMATE_FULL));

        Duration duration = new Duration(start, now);
        System.out.println("duration.getStandardDays(): " + start.toString(FORMATE_FULL) +
                now.toString(FORMATE_FULL) + " 相差的天数：" + duration.getStandardDays());

        System.out.println("duration.getStandardHours(): " + start.toString(FORMATE_FULL) +
                now.toString(FORMATE_FULL) + " 相差的小时数：" + duration.getStandardHours());


        Calendar calendar = now.toCalendar(Locale.CHINESE);
        System.out.println("with JDK interact: " + new SimpleDateFormat(FORMATE_FULL).format(calendar.getTime()));

        Calendar calendar2 = Calendar.getInstance();
        System.out.println("Calendar : " + new SimpleDateFormat(FORMATE_FULL).format(calendar2.getTime()));

        DateTime dateTime = new DateTime(new Date());
        System.out.println("格式化：" + dateTime.toString(FORMATE_FULL, Locale.CHINESE));


        DateTime dateTime2 = new DateTime(2014, 1, 1, 0, 0, 0);
        System.out.println("格式化：" + dateTime2.toString(FORMATE_FULL, Locale.CHINESE));

        String timeString = "2006-01-12";
        DateTime dateTime3 = new DateTime(timeString);
        System.out.println("parse: " + dateTime3.toString(FORMATE_FULL, Locale.CHINESE));

        LocalDate localDate = LocalDate.now();
        LocalDate lastDayOfPreviousMonth = localDate.minusMonths(1).dayOfMonth().withMaximumValue();
        System.out.println("计算上一个月的最后一天：" + lastDayOfPreviousMonth.toString(FORMATE_DATE, Locale.CHINESE));

        LocalDate.Property property = localDate.minusWeeks(1).dayOfWeek();
        System.out.println("上周一：" + property.withMinimumValue().toString(FORMATE_DATE, Locale.CHINESE));
        System.out.println("上周日：" + property.withMaximumValue().toString(FORMATE_DATE, Locale.CHINESE));

        System.out.println("dateTime.minusHours(1).dayOfWeek().getAsText(Locale.CHINESE) = " +
                dateTime.minusHours(1).dayOfWeek().getAsText(Locale.CHINESE));
        System.out.println("dateTime.minusYears(1).monthOfYear().getAsText(Locale.CHINESE) = " +
                dateTime.minusYears(1).monthOfYear().getAsText(Locale.CHINESE));
        System.out.println("dateTime.minusYears(1).dayOfMonth().getAsText(Locale.CHINESE) = " +
                dateTime.minusYears(1).dayOfMonth().getAsText(Locale.CHINESE));

        System.out.println("Days.daysBetween(DateTime.parse(\"2014-06-27\"), DateTime.parse(\"2014-07-02\")).getDays() = " +
                Days.daysBetween(DateTime.parse("2014-06-27"), DateTime.parse("2014-07-02")).getDays());

        DateTime one = DateTime.parse("2014-06-27T13:23:01");
        System.out.println("one.toString(FORMATE_FULL) = " + one.toString(FORMATE_FULL));
        System.out.println(one.minuteOfDay().setCopy(11).toString(FORMATE_FULL));

        System.out.println("one.hourOfDay().setCopy(0).toString(FORMATE_FULL) = " + one.hourOfDay().setCopy(0).toString(FORMATE_FULL));
        System.out.println("one.hourOfDay().addToCopy(3).toString(FORMATE_FULL) = " + one.hourOfDay().addToCopy(3).toString(FORMATE_FULL));

        System.out.println("2月是否为闰月 = " + one.minusMonths(4).monthOfYear().isLeap());

        DateTime from = DateTime.parse("2014-06-27");
        DateTime to = DateTime.parse("2014-07-02");
        */
        //初始化时间
        DateTime dateTime=new DateTime(2012, 12, 13, 18, 23,55);

        // 年,月,日,时,分,秒,毫秒
        DateTime dt3 = new DateTime(2011, 2, 13, 10, 30, 50, 333);// 2010年2月13日10点30分50秒333毫秒

        //下面就是按照一点的格式输出时间
        String str2 = dateTime.toString("MM/dd/yyyy hh:mm:ss.SSSa");
        String str3 = dateTime.toString("dd-MM-yyyy HH:mm:ss");
        String str4 = dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa");
        String str5 = dateTime.toString("MM/dd/yyyy HH:mm ZZZZ");
        String str6 = dateTime.toString("MM/dd/yyyy HH:mm Z");

        DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");
        //时间解析
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);

        //时间格式化，输出==> 2012/12/21 23:22:45 Fri
        String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE");
        System.out.println(string_u);

        //格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
        String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE",Locale.CHINESE);
        System.out.println(string_c);

        DateTime dt1 = new DateTime();// 取得当前时间

        // 根据指定格式,将时间字符串转换成DateTime对象,这里的格式和上面的输出格式是一样的
        DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2012-12-26 03:27:39");

        //计算两个日期间隔的天数
        LocalDate start=new LocalDate(2012, 12,14);
        LocalDate end=new LocalDate(2013, 01, 15);
        int days = Days.daysBetween(start, end).getDays();

        //计算两个日期间隔的小时数,分钟数,秒数

        //增加日期
        DateTime dateTime1 = DateTime.parse("2012-12-03");
        dateTime1 = dateTime1.plusDays(30);
        dateTime1 = dateTime1.plusHours(3);
        dateTime1 = dateTime1.plusMinutes(3);
        dateTime1 = dateTime1.plusMonths(2);
        dateTime1 = dateTime1.plusSeconds(4);
        dateTime1 = dateTime1.plusWeeks(5);
        dateTime1 = dateTime1.plusYears(3);

        // Joda-time 各种操作.....
        dateTime = dateTime.plusDays(1) // 增加天
                .plusYears(1)// 增加年
                .plusMonths(1)// 增加月
                .plusWeeks(1)// 增加星期
                .minusMillis(1)// 减分钟
                .minusHours(1)// 减小时
                .minusSeconds(1);// 减秒数

        //判断是否闰月
        DateTime dt4 = new DateTime();
        org.joda.time.DateTime.Property month = dt4.monthOfYear();
        System.out.println("是否闰月:" + month.isLeap());

        //取得 3秒前的时间
        DateTime dt5 = dateTime1.secondOfMinute().addToCopy(-3);
        dateTime1.getSecondOfMinute();// 得到整分钟后，过的秒钟数
        dateTime1.getSecondOfDay();// 得到整天后，过的秒钟数
        dateTime1.secondOfMinute();// 得到分钟对象,例如做闰年判断等使用

        // DateTime与java.util.Date对象,当前系统TimeMillis转换
        DateTime dt6 = new DateTime(new Date());
        Date date = dateTime1.toDate();
        DateTime dt7 = new DateTime(System.currentTimeMillis());
        dateTime1.getMillis();

        Calendar calendar = Calendar.getInstance();
        dateTime = new DateTime(calendar);

    }

}
