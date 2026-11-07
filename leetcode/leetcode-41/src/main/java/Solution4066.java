import java.util.HashMap;
import java.util.Map;

public class Solution4066 {
    static final long MX = (long) (1e9 + 1);

    public int maxEqualAdjacentPairs(int[] nums) {
        int base = 0;
        int best = 0;
        Map<Long, Integer> pairs = new HashMap<>();
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                base++;
            } else {
                long lo = Math.min(nums[i], nums[i + 1]);
                long hi = Math.max(nums[i], nums[i + 1]);
                long key = lo * MX + hi;
                int cnt = pairs.merge(key, 1, Integer::sum);
                if (cnt > best) {
                    best = cnt;
                }
            }
        }
        return base + best;
    }
}
/*
4066. 至多一次替换后的最大相邻相等元素对数
https://leetcode.cn/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/description/

第 521 场周赛 T2。

给你一个 下标从 1 开始 的整数数组 nums。
你可以选择两个 不同 的值 x 和 y，并 最多 执行一次以下操作：
- 将 nums 中所有值为 x 的元素替换为 y。
返回执行操作后，相邻且相等的元素对数量的 最大值 。
示例 1：
输入： nums = [1,2,3,2]
输出： 2
示例 2：
输入： nums = [1,2,1,2,1]
输出： 4
示例 3：
输入： nums = [1,1,1]
输出： 2
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

统计相邻不等的数对个数。
时间复杂度 O(n)。
 */