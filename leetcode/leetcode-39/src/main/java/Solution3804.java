import java.util.HashSet;
import java.util.Set;

public class Solution3804 {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int s = 0;
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                s += nums[j];
                if (set.contains(s)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
3804. 中心子数组的数量
https://leetcode.cn/problems/number-of-centered-subarrays/description/

第 484 场周赛 T2。

给你一个整数数组 nums。
如果一个 子数组 的元素之和 等于 该子数组中的 至少一个元素，则该子数组被称为 中心子数组。
返回数组 nums 中 中心子数组 的数量。
子数组 是数组中的一个连续、非空元素序列。
提示：
1 <= nums.length <= 500
-10^5 <= nums[i] <= 10^5

枚举。
时间复杂度 O(n^2)。
 */