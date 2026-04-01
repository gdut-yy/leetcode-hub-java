import java.util.HashMap;
import java.util.Map;

public class Solution3859 {
    private int[] nums;
    private int k, m;

    public long countSubarrays(int[] nums, int k, int m) {
        this.nums = nums;
        this.k = k;
        this.m = m;
        return calc(k) - calc(k + 1);
    }

    // 子数组至少包含 distinctLimit 个不同整数，且至少有 k 个不同整数都至少出现 m 次
    private long calc(int distinctLimit) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int geM = 0; // 窗口中的出现次数 >= m 的元素个数
        int left = 0;
        long ans = 0;
        for (int x : nums) {
            // 1. 入
            if (cnt.merge(x, 1, Integer::sum) == m) geM++;
            // 2. 出
            while (cnt.size() >= distinctLimit && geM >= k) {
                int out = nums[left];
                if (cnt.get(out) == m) geM--;
                if (cnt.merge(out, -1, Integer::sum) == 0) cnt.remove(out);
                left++;
            }
            // 3. 更新答案
            ans += left;
        }
        return ans;
    }
}
/*
3859. 统计包含 K 个不同整数的子数组
https://leetcode.cn/problems/count-subarrays-with-k-distinct-integers/description/

第 491 场周赛 T4。

给你一个整数数组 nums 和两个整数 k 和 m。
返回一个整数，表示满足以下条件的 子数组 的数量：
- 子数组 恰好 包含 K 个不同的 整数。
- 在子数组中，每个 不同的 整数 至少 出现 m 次。
子数组 是数组中一个连续的、非空 元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k, m <= nums.length

恰好型滑动窗口
https://leetcode.cn/problems/count-subarrays-with-k-distinct-integers/solutions/3910806/qia-hao-xing-hua-dong-chuang-kou-pythonj-5mll/
时间复杂度 O(n)。
 */