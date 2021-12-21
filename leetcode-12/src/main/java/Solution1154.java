import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Solution1154 {
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public int dayOfYear2(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FORMAT.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
}
/*
1154. 一年中的第几天
https://leetcode-cn.com/problems/day-of-the-year/

给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

Java 8 Date/Time API
相似题目: 1118. 一月有多少天
https://leetcode-cn.com/problems/number-of-days-in-a-month/
 */