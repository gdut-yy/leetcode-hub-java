import java.util.Arrays;

public class Solution3826 {
    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        long[] f = new long[n + 1];
        Arrays.fill(f, Long.MAX_VALUE / 2);
        f[0] = 0;
        for (int j = 1; j <= k; j++) {
            long[] nf = new long[n + 1];
            Arrays.fill(nf, Long.MAX_VALUE / 2);
            compute(j, n, j - 1, n - 1, f, nf, ps);
            f = nf;
        }
        return f[n];
    }

    private void compute(int l, int r, int optL, int optR, long[] prevDP, long[] curDP, long[] ps) {
        if (l > r) return;
        int mid = (l + r) / 2;
        int best = -1;
        long bestVal = Long.MAX_VALUE;
        for (int t = optL; t <= Math.min(optR, mid - 1); t++) {
            if (prevDP[t] >= Long.MAX_VALUE / 2) continue;
            long sum = ps[mid] - ps[t];
            long cost = sum * (sum + 1) / 2;
            long val = prevDP[t] + cost;
            if (val < bestVal) {
                bestVal = val;
                best = t;
            }
        }
        curDP[mid] = bestVal;
        compute(l, mid - 1, optL, best, prevDP, curDP, ps);
        compute(mid + 1, r, best, optR, prevDP, curDP, ps);
    }
}
/*
3826. 最小分割分数
https://leetcode.cn/problems/minimum-partition-score/description/

第 175 场双周赛 T4。

给你一个整数数组 nums 和一个整数 k。
你的任务是将 nums 分割成 恰好 k 个子数组，并返回所有有效分割方案中 最小可能的分数。
一个分割方案的 分数 是其所有子数组 值 的 总和。
子数组的 值 定义为 sumArr * (sumArr + 1) / 2，其中 sumArr 是该子数组元素的总和。
子数组 是数组中连续的非空元素序列。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^4
1 <= k <= nums.length

分治优化。
https://chat.deepseek.com/a/chat/s/365c99bc-4fe6-4a34-bf65-f6462cc8a924
rating 2373 (clist.by)
 */