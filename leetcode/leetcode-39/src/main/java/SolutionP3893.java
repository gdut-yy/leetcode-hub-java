import java.util.Arrays;

public class SolutionP3893 {
    public int maximumTeamSize(int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) {
            intervals[i] = new int[]{startTime[i], endTime[i]};
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int mx = 0;
        for (int[] p : intervals) {
            int start = p[0], end = p[1];
            int countStart = upperBound(startTime, end) + 1;
            int countEnd = upperBound(endTime, start - 1) + 1;
            mx = Math.max(mx, countStart - countEnd);
        }
        return mx;
    }

    private int upperBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
$3893. 最大重叠区间团队规模
https://leetcode.cn/problems/maximum-team-size-with-overlapping-intervals/description/

给定两个整数数组 startTime 和 endTime，长度为 n。
- startTime[i] 表示第 i 个员工的开始时间。
- endTime[i] 表示第 i 个员工的结束时间。
如果两个员工 i 和 j 的时间区间 有重叠，则他们可以进行互动。两个区间只要 至少有一个 公共时间点，就认为是重叠的。
如果一个团队中 至少存在一个 员工，可以与团队中的所有其他成员互动，则该团队是 有效的。
返回一个整数，表示这样的团队的 最大可能规模。
示例 1：
输入：startTime = [1,2,3], endTime = [4,5,6]
输出：3
示例 2：
输入：startTime = [2,5,8], endTime = [3,7,9]
输出：1
示例 3：
输入：startTime = [3,4,6], endTime = [8,5,7]
输出：3
提示：
1 <= n == startTime.length == endTime.length <= 10^5
0 <= startTime[i] <= endTime[i] <= 10^9
 */