public class Solution3936 {
    public int minimumSwaps(int[] nums) {
        int non0 = 0; // 非 0 的个数
        for (int x : nums) {
            if (x != 0) non0++;
        }

        int ans = 0;
        for (int i = 0; i < non0; i++) {
            if (nums[i] == 0) ans++;
        }
        return ans;
    }
}
/*
3936. 将 0 移到末尾的最少交换次数
https://leetcode.cn/problems/minimum-swaps-to-move-zeros-to-end/description/

第 183 场双周赛 T1。

给你一个整数数组 nums 。
在一步操作中，你可以选择任意两个 不同 的下标 i 和 j 并交换 nums[i] 和 nums[j] 。
返回将所有 0 移动到数组末尾所需的 最少 操作次数。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

中国时间 2026-05-23 周六 22:30
佛山。
两次遍历。
时间复杂度 O(n)。
 */