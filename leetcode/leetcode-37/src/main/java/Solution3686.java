public class Solution3686 {
    private static final int MOD = (int) (1e9 + 7);

    public int countStableSubsequences(int[] nums) {
        long dp0 = 1;
        long dp10 = 0, dp11 = 0;
        long dp20 = 0, dp21 = 0;

        for (int num : nums) {
            int x = num % 2;
            long old0 = dp0;
            long old10 = dp10, old11 = dp11;
            long old20 = dp20, old21 = dp21;

            if (x == 0) {
                dp10 = (dp10 + old0) % MOD;
                dp20 = (dp20 + old10) % MOD;
                dp10 = (dp10 + old11) % MOD;
                dp10 = (dp10 + old21) % MOD;
            } else {
                dp11 = (dp11 + old0) % MOD;
                dp11 = (dp11 + old10) % MOD;
                dp21 = (dp21 + old11) % MOD;
                dp11 = (dp11 + old20) % MOD;
            }
        }

        long ans = (dp10 + dp11 + dp20 + dp21) % MOD;
        return (int) ans;
    }
}
/*
3686. 稳定子序列的数量
https://leetcode.cn/problems/number-of-stable-subsequences/description/

第 467 场周赛 T4。

给你一个整数数组 nums。
如果一个 子序列 中 不存在连续三个 元素奇偶性相同（仅考虑该子序列内），则称该子序列为稳定子序列 。
请返回所有稳定子序列的数量。
由于结果可能非常大，请将答案对 10^9 + 7 取余数后返回。
子序列 是一个从数组中通过删除某些元素（或不删除任何元素），并保持剩余元素相对顺序不变的 非空 数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

方法思路
1.问题分析：问题要求统计所有非空子序列，其中没有三个连续元素具有相同的奇偶性。关键在于处理每个元素时，动态跟踪以奇数或偶数结尾的子序列数量，并确保不形成三个连续相同奇偶性的序列。
2.动态编程状态：使用以下状态来跟踪子序列：
dp0：空子序列的计数（始终为1）。
dp10和dp11：以单个偶数或奇数结尾的子序列计数。
dp20和dp21：以两个连续偶数或奇数结尾的子序列计数。
3.状态转移：对于数组中的每个元素，根据其奇偶性更新状态：
偶数元素（x=0）：更新状态以反映新增的偶数元素，确保不形成三个连续偶数。
奇数元素（x=1）：类似地更新状态以处理新增的奇数元素，避免三个连续奇数。
4.结果计算：最终结果是所有有效非空子序列的计数之和，即dp10 + dp11 + dp20 + dp21，取模 10^9 + 7
https://chat.deepseek.com/a/chat/s/71b9d0e2-bfff-4da9-86b6-495ff7d20a3b
 */