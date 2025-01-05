import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] events = new int[n][3];
        for (int i = 0; i < n; i++) {
            events[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));

        // solution 1751
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];

//            int last = 0;
//            for (int j = i - 1; j - 1 >= 0; j--) {
//                int[] ej = events[j - 1];
//
//                if (ej[1] <= ei[0]) {
//                    last = j;
//                    break;
//                }
//            }
            // 二分优化
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] > event[0]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int last = left;

            // 选 or 不选
            f[i] = Math.max(f[i - 1], f[last] + event[2]);
        }
        return f[n];
    }

    static class V2 {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[][] zip = new int[n][3];
            for (int i = 0; i < n; i++) {
                zip[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            Arrays.sort(zip, Comparator.comparingInt(o -> o[1])); // 按照结束时间排序

            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int st = zip[i][0], p = zip[i][2];
                int j = sortSearch(i, (j0) -> zip[j0][1] > st);
                // 状态转移中，为什么是 j 不是 j+1：上面算的是 > start，-1 后得到 <= start，但由于还要 +1，抵消了
                f[i + 1] = Math.max(f[i], f[j] + p);
            }
            return f[n];
        }

        // func Search(n int, f func(int) bool) int { ... }
        private int sortSearch(int n, Function<Integer, Boolean> f) {
            int l = 0, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (f.apply(mid)) r = mid;
                else l = mid + 1;
            }
            return l;
        }
    }
}
/*
1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/

你打算利用空闲时间来做兼职工作赚些零花钱。
这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
注意，时间上出现重叠的 2 份工作不能同时进行。
如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
提示：
1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4

动态规划。
时间复杂度 O(nlogn) 其中找 last 的部分可用二分优化到 O(logn)。
相似题目: 1751. 最多可以参加的会议数目 II
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
2008. 出租车的最大盈利
https://leetcode.cn/problems/maximum-earnings-from-taxi/
3414. 不重叠区间的最大得分
https://leetcode.cn/problems/maximum-score-of-non-overlapping-intervals/description/
 */