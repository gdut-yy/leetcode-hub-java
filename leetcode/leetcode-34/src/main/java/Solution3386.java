import java.util.Map;
import java.util.TreeMap;

public class Solution3386 {
    public int buttonWithLongestTime(int[][] events) {
        int n = events.length;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        cnt.put(events[0][0], events[0][1]);
        for (int i = 1; i < n; i++) {
            int t = events[i][1] - events[i - 1][1];
            cnt.merge(events[i][0], t, Integer::max); // or Integer::sum
        }
        int mx = cnt.values().stream().max(Integer::compareTo).orElseThrow();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == mx) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
/*
3386. 按下时间最长的按钮
https://leetcode.cn/problems/button-with-longest-push-time/description/

第 428 场周赛 T1。

给你一个二维数组 events，表示孩子在键盘上按下一系列按钮触发的按钮事件。
每个 events[i] = [indexi, timei] 表示在时间 timei 时，按下了下标为 indexi 的按钮。
- 数组按照 time 的递增顺序排序。
- 按下一个按钮所需的时间是连续两次按钮按下的时间差。按下第一个按钮所需的时间就是其时间戳。
返回按下时间 最长 的按钮的 index。如果有多个按钮的按下时间相同，则返回 index 最小的按钮。
提示：
1 <= events.length <= 1000
events[i] == [indexi, timei]
1 <= indexi, timei <= 10^5
输入保证数组 events 按照 timei 的递增顺序排序。

题意不清。单次按下时间最长，并非累计按下时间最长。
 */