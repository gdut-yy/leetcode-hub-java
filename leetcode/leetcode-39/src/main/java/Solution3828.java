public class Solution3828 {
    public int finalElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(nums[0], nums[n - 1]);
    }
}
/*
3828. 删除子数组后的最终元素
https://leetcode.cn/problems/final-element-after-subarray-deletions/description/

第 487 场周赛 T2。

给你一个整数数组 nums。
有两名玩家，Alice 和 Bob，轮流进行游戏，Alice 先手。
- 在每一轮中，当前玩家可以选择任意一个子数组 nums[l..r]，满足 r - l + 1 < m，其中 m 是 当前数组的长度。
- 被选中的 子数组将被移除，剩余的元素将连接 起来形成新的数组。
- 游戏持续进行，直到 仅剩一个 元素为止。
Alice 的目标是 最大化 最终剩下的元素，而 Bob 的目标则是 最小化 它。假设双方都采取最优策略，返回最终剩下的元素的值。
子数组 是数组中连续的且 非空 的一段元素。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

脑筋急转弯。
https://chat.deepseek.com/a/chat/s/4fe266be-7761-4da5-9906-05ace02b37de
时间复杂度 O(1)。
 */