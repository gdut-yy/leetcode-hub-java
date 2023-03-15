import java.util.Arrays;
import java.util.Comparator;

public class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return true;
        }
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int cnt = 0;
        int max = 0;
        // 双指针
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < n) {
            if (begin[p1] < end[p2]) {
                cnt++;
                p1++;
            } else {
                cnt--;
                p2++;
            }
            max = Math.max(max, cnt);
        }
        return max == 1;
    }

    public boolean canAttendMeetings2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
/*
$252. 会议室
https://leetcode.cn/problems/meeting-rooms/

给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
请你判断一个人是否能够参加这里面的全部会议。
提示：
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti < endi <= 10^6

扫描线？
时间复杂度 O(nlogn)
 */