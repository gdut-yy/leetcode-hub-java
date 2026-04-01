public class Solution3880 {
    static class V1 {
        public int minAbsoluteDifference(int[] nums) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (nums[j] == 2) {
                            int d = Math.abs(i - j);
                            if (d < ans) ans = d;
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    static class V2 {
        public int minAbsoluteDifference(int[] nums) {
            int n = nums.length;
            int ans = n;
            // last[x] 表示 x+1 上一次出现的位置
            int[] last = {-n, -n}; // i - (-n) >= n，不会让 ans 变小

            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (x > 0) {
                    // 如果 x 是 1，那么找上一个 2 的位置
                    // 如果 x 是 2，那么找上一个 1 的位置
                    x--;
                    ans = Math.min(ans, i - last[x ^ 1]);
                    last[x] = i;
                }
            }
            return ans == n ? -1 : ans;
        }
    }
}
/*
3880. 两个值之间的最小绝对差值
https://leetcode.cn/problems/minimum-absolute-difference-between-two-values/description/

第 179 场双周赛 T1。

给你一个只包含 0、1 和 2 的整数数组 nums。
如果 nums[i] == 1 且 nums[j] == 2，则称下标对 (i, j) 为 有效 的。
请返回所有有效下标对中 i 和 j 之间的 最小 绝对差。如果不存在有效下标对，则返回 -1。
下标 i 和 j 之间的绝对差定义为 abs(i - j)。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 2

枚举右，维护左。
时间复杂度 O(n)。
 */