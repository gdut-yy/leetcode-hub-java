public class Solution4012 {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + tasks[i];
        }
        int[] ans = new int[m];
        int idx = 0;
        long spent = 0;
        for (int j = 0; j < m; j++) {
            long T = ps[idx] + spent + shifts[j];
            int lo = 0, hi = n;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (ps[mid] <= T) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            int newIdx = lo - 1;
            if (newIdx == n) {
                ans[j] = 0;
                idx = 0;
                spent = 0;
            } else {
                ans[j] = n - newIdx;
                idx = newIdx;
                spent = T - ps[newIdx];
            }
        }
        return ans;
    }
}
/*
4012. 统计每个班次结束后的未完成任务数
https://leetcode.cn/problems/count-of-unfinished-tasks-after-each-shift/description/

第 513 场周赛 T3。

给你两个整数数组 tasks 和 shifts。
- tasks[i] 表示完成第 ith 个任务所需的时间。
- shifts[j] 表示第 jth 个班次可用的时间。
任务 必须 按照从左到右的顺序处理。
- 延续处理：如果一个任务在当前班次内没有完成，则下一班次会从该任务的 相同进度位置 继续处理。
- 重新开始：如果一个班次内完成了所有任务，则该班次会结束 。该班次剩余的时间会被 丢弃，下一班次会重新从第 0 个任务开始。
如果一个任务尚未被完全完成，则认为该任务是 未完成 的。这包括当前正在执行中的任务。
返回一个整数数组 ans，其中 ans[j] 表示第 jth 个班次结束后剩余的 未完成 任务数量。
提示：
1 <= tasks.length <= 10^5
1 <= shifts.length <= 10^5
1 <= tasks[i] <= 10^9
1 <= shifts[i] <= 10^9

前缀和 + 二分查找。
时间复杂度 O(n + mlogn)。
 */