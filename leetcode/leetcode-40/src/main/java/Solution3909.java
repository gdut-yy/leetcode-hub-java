public class Solution3909 {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int mx = 0;
        int mxI = 0;
        for (int i = 0; i < n; i++) {
            if (mx < nums[i]) {
                mx = nums[i];
                mxI = i;
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < mxI) {
                sum += nums[i];
            } else if (i > mxI) {
                sum -= nums[i];
            }
        }
        if (sum == 0) return -1;
        return sum > 0 ? 0 : 1;
    }
}
/*
3909. 比较双调部分的和
https://leetcode.cn/problems/compare-sums-of-bitonic-parts/description/

第 181 场双周赛 T2。

给你一个长度为 n 的 双调 数组 nums。
将数组分为 两 部分：
- 递增部分：从下标 0 到峰值元素（包含）。
- 递减部分：从峰值元素到下标 n - 1（包含）。
峰值元素同时属于这两部分。
返回：
- 如果 递增 部分的和更大，返回 0。
- 如果 递减 部分的和更大，返回 1。
- 如果两部分的和 相等，返回 -1。
注意：
- 双调 数组是指在达到 单个峰值 元素之前 严格递增，然后 严格递减 的数组。
- 如果一个数组的每个元素都 严格大于 它的 前一个 元素（如果存在），则称该数组是 严格递增 的。
- 如果一个数组的每个元素都 严格小于 它的 前一个 元素（如果存在），则称该数组是 严格递减 的。
提示：
3 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 是一个双调数组。

模拟。
时间复杂度 O(n)。
 */