import java.util.Arrays;

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
}
/*
$252. 会议室
https://leetcode-cn.com/problems/meeting-rooms/

给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
请你判断一个人是否能够参加这里面的全部会议。

输入：intervals = [[0,30],[5,10],[15,20]]
输出：false
 */