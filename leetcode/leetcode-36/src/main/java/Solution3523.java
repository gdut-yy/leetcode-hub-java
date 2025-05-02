public class Solution3523 {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0;
        int mx = 0;
        for (int v : nums) {
            if (v >= mx) {
                mx = v;
                ans++;
            }
        }
        return ans;
    }
}
/*
3523. 非递减数组的最大长度
https://leetcode.cn/problems/make-array-non-decreasing/description/

第 446 场周赛 T2。

给你一个整数数组 nums。在一次操作中，你可以选择一个子数组，并将其替换为一个等于该子数组 最大值 的单个元素。
返回经过零次或多次操作后，数组仍为 非递减 的情况下，数组 可能的最大长度。
子数组 是数组中一个连续、非空 的元素序列。
提示：
1 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 2 * 10^5

贪心。
如果在元素 x=nums[i] 的左边，有比 x 大的数 y，那么 x 必须去掉。
时间复杂度 O(n)。
 */