import java.util.Arrays;

public class Solution3409 {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().orElseThrow();
        int maxD = mx - Arrays.stream(nums).min().orElseThrow();
        // f[i][j] 表示以 nums[i] 结尾的、最后两个数之差至少为 j 的子序列的最长长度
        int[][] f = new int[n][maxD + 2];
        // last[x] 表示 x 上一次出现的下标
        int[] last = new int[mx + 1];
        Arrays.fill(last, -1);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = maxD; j >= 0; j--) {
                f[i][j] = Math.max(f[i][j + 1], 1);
                if (x - j >= 0 && last[x - j] >= 0) {
                    f[i][j] = Math.max(f[i][j], f[last[x - j]][j] + 1);
                }
                if (x + j <= mx && last[x + j] >= 0) {
                    f[i][j] = Math.max(f[i][j], f[last[x + j]][j] + 1);
                }
                ans = Math.max(ans, f[i][j]);
            }
            last[x] = i;
        }
        return ans;
    }
}
/*
3409. 最长相邻绝对差递减子序列
https://leetcode.cn/problems/longest-subsequence-with-decreasing-adjacent-difference/description/

第 147 场双周赛 T3。

给你一个整数数组 nums 。
你的任务是找到 nums 中的 最长子序列 seq ，这个子序列中相邻元素的 绝对差 构成一个 非递增 整数序列。换句话说，nums 中的序列 seq0, seq1, seq2, ..., seqm 满足 |seq1 - seq0| >= |seq2 - seq1| >= ... >= |seqm - seqm - 1| 。
请你返回这个子序列的长度。
一个 子序列 指的是从一个数组中删除零个或多个元素后，剩下元素不改变顺序得到的 非空 数组。
提示：
2 <= nums.length <= 10^4
1 <= nums[i] <= 300

朴素的记忆化搜索是 O(nD^2)。需要优化成 O(nD)。
rating ? (clist.by)
 */