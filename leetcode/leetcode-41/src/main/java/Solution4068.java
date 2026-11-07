import java.util.Arrays;
import java.util.Comparator;

public class Solution4068 {
    public long maxEarnings(int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));
        long[] ends = new long[n];
        long[] prefixMax = new long[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            long rev = meetings[i][2];
            int lo = 0, hi = i - 1, p = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (ends[mid] <= start) {
                    p = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            long add = 0;
            if (p >= 0) {
                add = start + prefixMax[p];
                if (add < 0) {
                    add = 0;
                }
            }

            long dp = rev + add;
            long val = dp - end;
            ends[i] = end;
            prefixMax[i] = (i == 0) ? val : Math.max(prefixMax[i - 1], val);
            if (dp > ans) {
                ans = dp;
            }
        }
        return ans;
    }
}
/*
4068. 考虑空闲时间的会议最大收益
https://leetcode.cn/problems/maximize-meeting-earnings-with-idle-gaps/description/

第 521 场周赛 T4。

给你一个二维整数数组 meetings，其中 meetings[i] = [starti, endi, revenuei] 表示一场会议从时间 starti 开始，在时间 endi 结束，并可获得 revenuei 的收益。
所有会议均采用 左闭右开区间 [start, end) 表示，因此仅在端点处相接的会议 不视为 重叠。
你可以选择任意一个会议 非空子集 ，所选会议两两不重叠。每选择一场会议，你都可以获得该会议对应的收益。
将所选会议按照 开始时间递增 的顺序排列。对于该顺序中每一对相邻会议，你还可以根据它们之间的空闲时间获得额外收益，每单位空闲时间获得 1 单位收益。空闲时间等于后一场会议的开始时间减去前一场会议的结束时间。
最早一场所选会议开始之前，以及最晚一场所选会议结束之后的空闲时间不会产生收益。如果只选择一场会议，则不会获得任何空闲时间收益。
返回可以获得的 最大总收益 。
数组的 子集 是从数组中选择若干元素得到的集合。
示例 1：
输入： meetings = [[2,5,4],[6,8,3]]
输出： 8
示例 2：
输入： meetings = [[3,5,4],[4,7,8],[8,10,3]]
输出： 12
示例 3：
输入： meetings = [[1,2,2],[4,5,2],[7,9,3]]
输出： 11
提示
1 <= meetings.length <= 10^5
meetings[i] = [starti, endi, revenuei]
0 <= starti < endi <= 10^9
1 <= revenuei <= 10^9

动态规划。
时间复杂度 O(nlogn)。
相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
 */