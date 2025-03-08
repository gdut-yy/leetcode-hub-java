public class Solution3452 {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && nums[i] <= nums[i - k] ||
                    i + k < n && nums[i] <= nums[i + k]) {
                continue;
            }
            ans += nums[i];
        }
        return ans;
    }
}
/*
3452. 好数字之和
https://leetcode.cn/problems/sum-of-good-numbers/description/

第 150 场双周赛 T1。

给定一个整数数组 nums 和一个整数 k，如果元素 nums[i] 严格 大于下标 i - k 和 i + k 处的元素（如果这些元素存在），则该元素 nums[i] 被认为是 好 的。如果这两个下标都不存在，那么 nums[i] 仍然被认为是 好 的。
返回数组中所有 好 元素的 和。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= floor(nums.length / 2)

遍历。
时间复杂度 O(n)。
 */