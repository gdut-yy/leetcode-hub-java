import java.util.HashMap;
import java.util.Map;

public class Solution3850 {
    private int[] nums;
    private long k;
    private Map<Args, Integer> memo;

    private record Args(int i, long p, long q) {
    }

    public int countSequences(int[] nums, long k) {
        this.nums = nums;
        this.k = k;
        memo = new HashMap<>();
        return dfs(nums.length - 1, 1, 1); // 从 1/1 开始，目标是变成 k/1
    }

    private int dfs(int i, long p, long q) {
        if (i < 0) {
            // 不能直接写 p == q * k，乘法会溢出
            return p % q == 0 && p / q == k ? 1 : 0;
        }
        Args t = new Args(i, p, q);
        Integer cachedRes = memo.get(t);
        if (cachedRes != null) return cachedRes;

        int res1 = dfs(i - 1, p * nums[i], q); // 乘以 nums[i]
        int res2 = dfs(i - 1, p, q * nums[i]); // 除以 nums[i]
        int res3 = dfs(i - 1, p, q); // 不变
        int res = res1 + res2 + res3;

        memo.put(t, res);
        return res;
    }
}
/*
3850. 统计结果等于 K 的序列数目
https://leetcode.cn/problems/count-sequences-to-k/description/

第 490 场周赛 T4。

给你一个整数数组 nums 和一个整数 k。
从初始值 val = 1 开始，从左到右处理 nums。在每个下标 i 处，你必须 恰好选择 以下操作之一：
- 将 val 乘以 nums[i]。
- 将 val 除以 nums[i]。
- 保持 val 不变。
在处理完所有元素后，当且仅当 val 的最终有理数值 恰好 等于 k 时，才认为 val 等于 k。
返回生成 val == k 的 不同 选择序列的数量。
注意：除法是有理数除法（精确除法），而不是整数除法。例如，2 / 4 = 1 / 2。
提示:
1 <= nums.length <= 19
1 <= nums[i] <= 6
1 <= k <= 10^15

记忆化搜索。
时间复杂度 O(n^7)。
 */