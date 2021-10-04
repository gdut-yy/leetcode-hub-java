import java.util.Arrays;

public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
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
        return max;
    }
}
/*
$253. 会议室 II
https://leetcode-cn.com/problems/meeting-rooms-ii/

给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

输入：intervals = [[0,30],[5,10],[15,20]]
输出：2

扫描线技巧。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */