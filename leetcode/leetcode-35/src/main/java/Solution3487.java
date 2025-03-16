import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3487 {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int v : nums) {
            if (v > 0) set.add(v);
        }
        if (set.isEmpty()) return Arrays.stream(nums).max().orElseThrow();

        int ans = 0;
        for (Integer v : set) {
            ans += v;
        }
        return ans;
    }
}
/*
3487. 删除后的最大子数组元素和
https://leetcode.cn/problems/maximum-unique-subarray-sum-after-deletion/description/

第 441 场周赛 T1。

给你一个整数数组 nums 。
你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
1.子数组中的所有元素 互不相同 。
2.最大化 子数组的元素和。
返回子数组的 最大元素和 。
子数组 是数组的一个连续、非空 的元素序列。
提示：
1 <= nums.length <= 100
-100 <= nums[i] <= 100

答案为 所有非负数去重后的元素和 或者 max(nums)。
时间复杂度 O(n)。
 */