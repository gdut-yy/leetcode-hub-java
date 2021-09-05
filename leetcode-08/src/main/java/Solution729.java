import java.util.Map;
import java.util.TreeMap;

public class Solution729 {
    static class MyCalendar {
        private final TreeMap<Integer, Integer> events;

        public MyCalendar() {
            events = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if (event != null && event.getValue() > start) {
                return false;
            }
            event = events.ceilingEntry(start);
            if (event != null && event.getKey() < end) {
                return false;
            }
            events.put(start, end);
            return true;
        }
    }
}
/*
729. 我的日程安排表 I
https://leetcode-cn.com/problems/my-calendar-i/

TreeMap 的应用
ceilingEntry/ceilingKey 返回键大于或等于给定值的最小映射/键；如果没有则返回 null
floorEntry/floorKey 返回键小于或等于给定值的最小映射/键；如果没有则返回 null
 */