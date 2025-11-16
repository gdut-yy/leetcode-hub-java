public class Solution3743 {
    public long maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxI = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }
        }

        long ans1 = maximumProfit(nums, maxI, maxI + n, k); // nums[maxI] 是第一个数
        long ans2 = maximumProfit(nums, maxI + 1, maxI + 1 + n, k); // nums[maxI] 是最后一个数
        return Math.max(ans1, ans2);
    }

    // 3573. 买卖股票的最佳时机 V
    private long maximumProfit(int[] prices, int l, int r, int k) {
        int n = prices.length;
        long[][] f = new long[k + 2][3];
        for (int j = 1; j <= k + 1; j++) {
            f[j][1] = Long.MIN_VALUE / 2; // 防止溢出
        }
        f[0][0] = Long.MIN_VALUE / 2;
        for (int i = l; i < r; i++) {
            int p = prices[i % n];
            for (int j = k + 1; j > 0; j--) {
                f[j][0] = Math.max(f[j][0], Math.max(f[j][1] + p, f[j][2] - p));
                f[j][1] = Math.max(f[j][1], f[j - 1][0] - p);
                f[j][2] = Math.max(f[j][2], f[j - 1][0] + p);
            }
        }
        return f[k + 1][0];
    }
}
/*
3743. 循环划分的最大得分
https://leetcode.cn/problems/maximize-cyclic-partition-score/description/

第 475 场周赛 T4。

给你一个 循环 数组 nums 和一个整数 k。
将 nums 划分 为 最多 k 个子数组。由于 nums 是循环数组，这些子数组可以从数组末尾环绕回起点。
子数组的 范围 定义为其 最大值 与 最小值 的差值。划分的 得分 是所有子数组范围的总和。
返回所有循环划分方案中可能获得的 最大得分 。
子数组 是数组中的一个连续非空的元素序列。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= k <= nums.length

找到最佳断环位置，转化成买卖股票问题
https://leetcode.cn/problems/maximize-cyclic-partition-score/solutions/3827101/zhao-dao-zui-jia-duan-huan-wei-zhi-zhuan-k2ip/
rating 3132 (clist.by)
 */