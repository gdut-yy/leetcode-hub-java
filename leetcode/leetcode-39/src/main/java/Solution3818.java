public class Solution3818 {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) return i + 1;
        }
        return 0;
    }
}
/*
3818. 移除前缀使数组严格递增
https://leetcode.cn/problems/minimum-prefix-removal-to-make-array-strictly-increasing/description/

第 486 场周赛 T1。

给你一个整数数组 nums。
你需要从 nums 中 恰好 移除一个前缀（可以为空）。
返回一个整数，表示被移除的前缀的 最小 长度，使得剩余的数组 严格递增 。
数组的 前缀 是从数组的起始位置开始，一直延伸到任意位置的子数组。
如果一个数组的每个元素都严格大于它的前一个元素（若存在），则称该数组 严格递增 。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

倒序遍历。
时间复杂度 O(n)。
 */