import java.util.Arrays;

public class Solution3745 {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - 1] + nums[n - 2] - nums[0];
    }
}
/*
3745. 三元素表达式的最大值
https://leetcode.cn/problems/maximize-expression-of-three-elements/description/

第 476 场周赛 T1。

给你一个整数数组 nums。
从 nums 中选择三个元素 a、b 和 c，它们的下标需 互不相同 ，使表达式 a + b - c 的值最大化。
返回该表达式可能的 最大值 。
提示：
3 <= nums.length <= 100
-100 <= nums[i] <= 100

贪心。排序。
时间复杂度 O(nlogn)。
 */