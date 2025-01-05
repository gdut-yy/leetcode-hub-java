import java.util.Arrays;

public class Solution3397 {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int preR = Integer.MIN_VALUE;
        int ans = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && nums[i] == nums[st]; i++) {
            }
            int span = i - st;
            int L = nums[st] - k;
            int R = nums[st] + k;
            // [max(L, preR+1), R]
            int maxL = Math.max(L, preR);
            int add = Math.min(R - maxL + 1, span);
            ans += add;
            preR = maxL + add;
        }
        return ans;
    }
}
/*
3397. 执行操作后不同元素的最大数量
https://leetcode.cn/problems/maximum-number-of-distinct-elements-after-operations/description/

第 429 场周赛 T2。

给你一个整数数组 nums 和一个整数 k。
你可以对数组中的每个元素 最多 执行 一次 以下操作：
- 将一个在范围 [-k, k] 内的整数加到该元素上。
返回执行这些操作后，nums 中可能拥有的不同元素的 最大 数量。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= k <= 10^9

贪心 + 排序 + 分组循环。
 */