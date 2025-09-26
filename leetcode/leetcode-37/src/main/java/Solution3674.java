public class Solution3674 {
    public int minOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) return 1;
        }
        return 0;
    }
}
/*
3674. 数组元素相等的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-equalize-array/description/

第 466 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
在一次操作中，可以选择任意子数组 nums[l...r] （0 <= l <= r < n），并将该子数组中的每个元素 替换 为所有元素的 按位与（bitwise AND）结果。
返回使数组 nums 中所有元素相等所需的最小操作次数。
子数组 是数组中连续的、非空的元素序列。
提示：
1 <= n == nums.length <= 100
1 <= nums[i] <= 10^5

脑筋急转弯。
如果 nums 所有元素都相等，无需操作，返回 0。否则返回 1。
时间复杂度 O(n)。
 */