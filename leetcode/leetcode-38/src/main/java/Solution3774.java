import java.util.Arrays;

public class Solution3774 {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        int d = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            d += nums[n - 1 - i] - nums[i];
        }
        return Math.abs(d);
    }
}
/*
3774. 最大和最小 K 个元素的绝对差
https://leetcode.cn/problems/absolute-difference-between-maximum-and-minimum-k-elements/description/

第 480 场周赛 T1。

给你一个整数数组 nums 和一个整数 k。
请计算以下两者的绝对差值：
- 数组中 k 个 最大 元素的总和；
- 数组中 k 个 最小 元素的总和。
返回表示此差值的整数。
提示：
1 <= n == nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= n

中国时间 2025-12-14 周日 10:30
上海。
排序。
时间复杂度 O(nlogn)。
 */