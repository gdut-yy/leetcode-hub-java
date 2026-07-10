import java.util.Arrays;

public class Solution3974 {
    public long maxSum(int[] nums, int k, int mul) {
        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        long a = mul;
        int multi = Math.min(k, mul);
        for (int i = 0; i < multi; i++) {
            int x = nums[n - 1 - i];
            sum += x * a--;
        }
        for (int i = 0; i < k - mul; i++) {
            int x = nums[n - 1 - i - mul];
            sum += x;
        }
        return sum;
    }
}
/*
3974. K 个元素的最大总和
https://leetcode.cn/problems/maximum-total-sum-of-k-selected-elements/description/

第 508 场周赛 T1。

给你一个整数数组 nums，以及两个整数 k 和 mul。
从 nums 中选出 恰好 k 个元素。你可以按照任意顺序逐个处理这些元素。
对于每个被选择的元素，都可以 独立地 选择以下两种操作之一：
- 将该元素的值 加 到总和中；或
- 将该元素乘以 mul 的 当前 值，并将结果 加 到总和中。
每处理一个被选择的元素后，无论选择哪种操作，mul 都会 减少 1。mul 的当前值可能变为 0 或负数。
返回一个整数，表示可能得到的 最大 总和。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= nums.length
1 <= mul <= 10^5

贪心。
排序，从最大数开始操作。
时间复杂度 O(nlogn)。
 */