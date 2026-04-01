import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3852 {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) cnt.merge(v, 1, Integer::sum);

        int mn = Arrays.stream(nums).min().orElseThrow();
        int cntMin = cnt.get(mn);
        int minY = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() != cntMin) {
                minY = Math.min(minY, e.getKey());
            }
        }
        return minY == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{mn, minY};
    }
}
/*
3852. 不同频率的最小数对
https://leetcode.cn/problems/smallest-pair-with-different-frequencies/description/

第 177 场双周赛 T1。

给你一个整数数组 nums。
从 nums 中找出两个 互不相同 的值 x 和 y，使得：
- x < y
- x 和 y 在 nums 中的频率不同。
在所有满足条件的数对中：
- 选择 x 的值尽可能小的数对。
- 如果存在多个 x 相同的数对，选择 y 的值尽可能小的那个。
返回一个整数数组 [x, y]。如果不存在有效的数对，返回 [-1, -1]。
一个值 x 的 频率 是指它在数组中出现的次数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2026-02-28 周六 22:30
深圳。工作日，太累不想打。
哈希表计数。
时间复杂度 O(n)。
 */