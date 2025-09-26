public class Solution3683 {
    public int earliestTime(int[][] tasks) {
        int ans = Integer.MAX_VALUE;
        for (int[] t : tasks) {
            ans = Math.min(ans, t[0] + t[1]);
        }
        return ans;
    }
}
/*
3683. 完成一个任务的最早时间
https://leetcode.cn/problems/earliest-time-to-finish-one-task/description/

第 467 场周赛 T1。

给你一个二维整数数组 tasks，其中 tasks[i] = [si, ti]。
数组中的每个 [si, ti] 表示一个任务，该任务的开始时间为 si，完成该任务需要 ti 个时间单位。
返回至少完成一个任务的最早时间。
提示：
1 <= tasks.length <= 100
tasks[i] = [si, ti]
1 <= si, ti <= 100

遍历。
时间复杂度 O(n)。
 */