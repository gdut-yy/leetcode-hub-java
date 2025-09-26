import java.util.Arrays;

public class Solution3689 {
    public long maxTotalValue(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        int mn = Arrays.stream(nums).min().orElseThrow();
        return (long) (mx - mn) * k;
    }
}
/*
3689. 最大子数组总值 I
https://leetcode.cn/problems/maximum-total-subarray-value-i/description/

第 468 场周赛 T2。

给定一个长度为 n 的整数数组 nums 和一个整数 k。
你必须从 nums 中选择 恰好 k 个非空子数组 nums[l..r]。子数组可以重叠，同一个子数组（相同的 l 和 r）可以 被选择超过一次。
子数组 nums[l..r] 的 值 定义为：max(nums[l..r]) - min(nums[l..r])。
总值 是所有被选子数组的 值 之和。
返回你能实现的 最大 可能总值。
子数组 是数组中连续的 非空 元素序列。
提示:
1 <= n == nums.length <= 5 * 10^4
0 <= nums[i] <= 10^9
1 <= k <= 10^5

脑筋急转弯。最大值 - 最小值 的值乘以 k 即可。
 */