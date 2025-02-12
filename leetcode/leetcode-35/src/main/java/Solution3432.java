public class Solution3432 {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int L = ps[i + 1];
            int R = ps[n] - L;
            if (Math.floorMod(L - R, 2) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3432. 统计元素和差值为偶数的分区方案
https://leetcode.cn/problems/count-partitions-with-even-sum-difference/description/

第 434 场周赛 T1。

给你一个长度为 n 的整数数组 nums 。
分区 是指将数组按照下标 i （0 <= i < n - 1）划分成两个 非空 子数组，其中：
- 左子数组包含区间 [0, i] 内的所有下标。
- 右子数组包含区间 [i + 1, n - 1] 内的所有下标。
对左子数组和右子数组先求元素 和 再做 差 ，统计并返回差值为 偶数 的 分区 方案数。
提示：
2 <= n == nums.length <= 100
1 <= nums[i] <= 100

前缀和模拟。
 */