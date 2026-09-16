import java.util.HashMap;
import java.util.Map;

public class Solution4038 {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int i = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        while (i < n) {
            int st = i;
            for (i++; i < n && nums[i] == nums[i - 1]; i++) {
            }
            cnt.merge(nums[st], 1, Integer::sum);
        }

        int ans = 0;
        for (Integer value : cnt.values()) {
            if (value == 1) ans++;
        }
        return ans;
    }
}
/*
4038. 计算单个区间中出现的整数数量
https://leetcode.cn/problems/count-integers-appearing-in-a-single-block/description/

第 517 场周赛 T1。

给你一个整数数组 nums。
如果整数 x 在 nums 中的所有出现位置都位于同一个 连续 区间内，则称 x 为 特殊整数。
返回 nums 中 不同 特殊整数的数量。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

分组循环。
时间复杂度 O(n)。
 */