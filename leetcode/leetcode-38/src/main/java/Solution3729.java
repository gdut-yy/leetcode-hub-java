import java.util.HashMap;
import java.util.Map;

public class Solution3729 {
    public long numGoodSubarrays(int[] nums, int k) {
        long A = 0;
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);
        long prefix = 0;
        for (int v : nums) {
            prefix = (prefix + v) % k;
            if (prefix < 0) prefix += k;
            int mod = (int) prefix;
            A += modMap.getOrDefault(mod, 0);
            modMap.merge(mod, 1, Integer::sum);
        }

        long C = 0, B = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            int segLen = j - i;
            long v = nums[i];
            for (int L = 1; L <= segLen; L++) {
                long product = L * v;
                if (product % k == 0) {
                    C += (segLen - L + 1);
                    B++;
                }
            }
            i = j;
        }

        return A - C + B;
    }
}
/*
3729. 统计有序数组中可被 K 整除的子数组数量
https://leetcode.cn/problems/count-distinct-subarrays-divisible-by-k-in-sorted-array/description/

第 473 场周赛 T4。

给你一个按 非降序 排列的整数数组 nums 和一个正整数 k。
如果 nums 的某个 子数组 的元素和可以被 k 整除，则称其为 良好 子数组。
返回一个整数，表示 nums 中 不同 的 良好 子数组的数量。
子数组 是数组中连续且 非空 的一段元素序列。
当两个子数组的数值序列不同，它们就被视为 不同 的子数组。例如，在 [1, 1, 1] 中，有 3 个 不同 的子数组，分别是 [1]、[1, 1] 和 [1, 1, 1]。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 为非降序排列。
1 <= k <= 10^9

前缀和 + 哈希表。
https://chat.deepseek.com/a/chat/s/6f2b6e68-c9ce-4212-a7b1-2b88b4c282cf
时间复杂度 O(n)。
rating 2289 (clist.by)
 */