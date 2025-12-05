public class Solution3752 {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long T0 = (long) n * (n + 1) / 2;
        if (T0 < target || target < -T0 || (T0 - target) % 2 != 0) {
            return new int[0];
        }
        long S = (T0 - target) / 2;
        boolean[] isNegative = new boolean[n + 1];
        for (int i = n; i >= 1; i--) {
            if (S >= i) {
                isNegative[i] = true;
                S -= i;
            }
        }
        if (S != 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int idx = 0;
        for (int i = n; i >= 1; i--) {
            if (isNegative[i]) {
                ans[idx++] = -i;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!isNegative[i]) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}
/*
3752. 字典序最小和为目标值且绝对值是排列的数组
https://leetcode.cn/problems/lexicographically-smallest-negated-permutation-that-sums-to-target/description/

第 170 场双周赛 T3。

给你一个正整数 n 和一个整数 target。
请返回一个大小为 n 的 字典序最小 的整数数组，并满足：
- 其元素 和 等于 target。
- 其元素的 绝对值 组成一个大小为 n 的 排列。
如果不存在这样的数组，则返回一个空数组。
如果数组 a 和 b 在第一个不同的位置上，数组 a 的元素小于 b 的对应元素，则认为数组 a 字典序小于 数组 b。
大小为 n 的 排列 是对整数 1, 2, ..., n 的重新排列。
提示：
1 <= n <= 10^5
-10^10 <= target <= 10^10

字典序贪心。
时间复杂度 O(n)。
 */