import java.util.HashMap;
import java.util.Map;

public class Solution3404 {
    // 1512
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Double, Integer> cnt = new HashMap<>();
        // 枚举 b 和 c
        for (int i = 4; i < n - 2; i++) {
            // 增量式更新，本轮循环只需枚举 b=nums[i-2] 这一个数
            // 至于更前面的 b，已经在前面的循环中添加到 cnt 中了，不能重复添加
            double b = nums[i - 2];
            // 枚举 a
            for (int j = 0; j < i - 3; j++) {
                cnt.merge(nums[j] / b, 1, Integer::sum);
            }

            double c = nums[i];
            // 枚举 d
            for (int j = i + 2; j < n; j++) {
                ans += cnt.getOrDefault(nums[j] / c, 0);
            }
        }
        return ans;
    }
}
/*
3404. 统计特殊子序列的数目
https://leetcode.cn/problems/count-special-subsequences/description/

第 430 场周赛 T3。

给你一个只包含正整数的数组 nums 。
特殊子序列 是一个长度为 4 的子序列，用下标 (p, q, r, s) 表示，它们满足 p < q < r < s ，且这个子序列 必须 满足以下条件：
- nums[p] * nums[r] == nums[q] * nums[s]
- 相邻坐标之间至少间隔 一个 数字。换句话说，q - p > 1 ，r - q > 1 且 s - r > 1 。
子序列指的是从原数组中删除零个或者更多元素后，剩下元素不改变顺序组成的数字序列。
请你返回 nums 中不同 特殊子序列 的数目。
提示：
7 <= nums.length <= 1000
1 <= nums[i] <= 1000

枚举右维护左。
时间复杂度 O(n^2)。
相似题目: 1512. 好数对的数目
https://leetcode.cn/problems/number-of-good-pairs/description/
rating 2448 (clist.by)
 */