public class Solution3599 {
    static class V1 {
        private int n, k;
        private int[] pre_xor;

        public int minXor(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            pre_xor = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre_xor[i] = pre_xor[i - 1] ^ nums[i - 1];
            }

            int left = 0;
            int right = 1 << 30;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (check(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int mid) {
            boolean[][] dp = new boolean[n + 1][k + 1];
            dp[0][0] = true;

            for (int j = 1; j <= k; j++) {
                for (int i = j; i <= n; i++) {
                    for (int p = j - 1; p < i; p++) {
                        if (dp[p][j - 1]) {
                            int xor_val = pre_xor[i] ^ pre_xor[p];
                            if (xor_val <= mid) {
                                dp[i][j] = true;
                                break; // 找到一种分割方式即可，跳出内层循环
                            }
                        }
                    }
                }
            }
            return dp[n][k];
        }
    }
}
/*
3599. 划分数组得到最小 XOR
https://leetcode.cn/problems/partition-array-to-minimize-xor/description/

第 456 场周赛 T3。

给你一个整数数组 nums 和一个整数 k。
你的任务是将 nums 分成 k 个非空的 子数组 。对每个子数组，计算其所有元素的按位 XOR 值。
返回这 k 个子数组中 最大 XOR 的 最小值 。
子数组 是数组中连续的 非空 元素序列。
提示：
1 <= nums.length <= 250
1 <= nums[i] <= 10^9
1 <= k <= n

二分答案 + 划分型 DP。
或者直接划分型 DP。
时间复杂度 O(logU * n^3)。上界大概是 O(30 * 250^3) = O(468,750,000)
 */