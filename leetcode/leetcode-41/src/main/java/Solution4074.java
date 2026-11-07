import java.util.HashMap;
import java.util.Map;

public class Solution4074 {
    public int[] maxProductPair(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        int bestI = -1;
        int bestJ = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x * 2 == target) { // x = target-x
                continue;
            }
            Integer j = pos.get(target - x);
            if (j != null && (bestI < 0 || x * (target - x) > nums[bestI] * (target - nums[bestI]))) { // 也可以比谁离 target/2 更近
                bestI = i;
                bestJ = j;
            }
            pos.put(x, i);
        }

        if (bestI >= 0 && nums[bestI] < nums[bestJ]) {
            // 保证 nums[bestI] > nums[bestJ]
            int tmp = bestI;
            bestI = bestJ;
            bestJ = tmp;
        }
        return new int[]{bestI, bestJ};
    }
}
/*
4074. 和为目标值的最大乘积对
https://leetcode.cn/problems/maximum-product-pair-with-target-sum/description/

第 193 场双周赛 T1。

给你一个整数数组 nums 和一个整数 target。
当一个由 不同 下标组成的二元组 (i, j) 满足以下条件，称它是 有效的 ：
- nums[i] + nums[j] == target
- nums[i] > nums[j]
返回一个 有效的 二元组 [i, j]，使其 乘积 nums[i] * nums[j] 在所有有效二元组中是 最大 的。如果不存在有效的二元组，返回 [-1, -1]。
如果有多个有效二元组都能达到 最大 乘积，你可以返回其中的 任意一个 。
示例 1：
输入： nums = [1,2,3,4], target = 5
输出： [2,1]
示例 2：
输入： nums = [-3,-1,4,2], target = 1
输出： [3,1]
示例 3：
输入： nums = [3,3,5], target = 6
输出： [-1,-1]
提示：
2 <= nums.length <= 100
-100 <= nums[i], target <= 100

中国时间 2026-10-10 周六 22:30
深圳。小刘理发。
枚举右维护左。
时间复杂度 O(n)。
 */