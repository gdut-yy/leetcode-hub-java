import java.util.Arrays;

public class Solution891 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // 预处理 2 的幂次
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow2[i] - pow2[n - 1 - i]) * nums[i]) % MOD;
        }
        return (int) ans;
    }
}
/*
891. 子序列宽度之和
https://leetcode.cn/problems/sum-of-subsequence-widths/description/

一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 10^9 + 7 取余 后的结果。
子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

计算每个元素对答案的贡献 https://leetcode.cn/problems/sum-of-subsequence-widths/solutions/1977682/by-endlesscheng-upd1/
时间复杂度 O(nlogn)。
 */