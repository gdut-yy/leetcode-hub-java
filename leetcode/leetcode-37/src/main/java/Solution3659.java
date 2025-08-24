import java.util.HashMap;
import java.util.Map;

public class Solution3659 {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        Map<Integer, Integer> mp = new HashMap<>();
        int max_cnt = 0;
        for (int v : nums) {
            max_cnt = Math.max(max_cnt, mp.merge(v, 1, Integer::sum));
        }
        return max_cnt <= n / k;
    }
}
/*
3659. 数组元素分组
https://leetcode.cn/problems/partition-array-into-k-distinct-groups/description/

第 464 场周赛 T2。

给你一个整数数组 nums 和一个整数 k。
请你判断是否可以将 nums 中的所有元素分成一个或多个组，使得：
- 每个组 恰好 包含 k 个 不同的 元素。
- nums 中的每个元素 必须 被分配到 恰好一个 组中。
如果可以完成这样的分组，返回 true；否则，返回 false。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= nums.length

构造。n 必须能整除 k，且频次最高元素不能超过 k。
时间复杂度 O(n)。
 */