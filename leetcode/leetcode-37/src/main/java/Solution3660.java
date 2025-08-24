public class Solution3660 {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int sufMin = Integer.MAX_VALUE;
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (preMax[i] <= sufMin) {
                mx = preMax[i]; // 无法跳到 [i+1,n-1] 中，只能跳到 [0,i] 中的最大值
            }
            sufMin = Math.min(sufMin, nums[i]);
            nums[i] = mx;
        }
        return nums;
    }
}
/*
3660. 跳跃游戏 9
https://leetcode.cn/problems/jump-game-ix/description/

第 464 场周赛 T3。

给你一个整数数组 nums。
从任意下标 i 出发，你可以根据以下规则跳跃到另一个下标 j：
- 仅当 nums[j] < nums[i] 时，才允许跳跃到下标 j，其中 j > i。
- 仅当 nums[j] > nums[i] 时，才允许跳跃到下标 j，其中 j < i。
对于每个下标 i，找出从 i 出发且可以跳跃 任意 次，能够到达 nums 中的 最大值 是多少。
返回一个数组 ans，其中 ans[i] 是从下标 i 出发可以到达的最大值。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

结论 + 动态规划。
题目很绕。翻译一下就是 如果左边比右边大，可以从右跳到左，也可以从左跳到右；
设 f(i) 表示前 i 个元素的最大值，g(i) 表示第 i 到第 n 个元素的最小值。
每个 f(i) <= g(i+1) 的位置就把整个序列分成了很多段，每一段的答案就是当前段的最大值。
时间复杂度 O(n)。
rating 2173 (clist.by)
 */