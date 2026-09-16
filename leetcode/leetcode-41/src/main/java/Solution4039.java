public class Solution4039 {
    public int sumDecoded(long[] nums) {
        long ans = 0;
        for (long num : nums) {
            int widthi = Math.toIntExact(num % 10);
            long di = num / 10;
            long xi = Long.parseLong(String.valueOf(di).substring(0, widthi));
            long yi = Long.parseLong(String.valueOf(di).substring(widthi));
            ans += quickPow(xi, yi);
        }
        ans %= MOD;
        return (int) ans;
    }

    static final int MOD = (int) (1e9 + 7);

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
4039. 解码值之和
https://leetcode.cn/problems/sum-of-decoded-numbers/description/

第 517 场周赛 T2。

给你一个整数数组 nums。
每个 nums[i] 都是一个 编码后的 整数，表示两个正整数 xi 和 yi。要解码 nums[i]，定义：
- widthi = nums[i] % 10。
- di = floor(nums[i] / 10)。
- xi 为由 di 的十进制表示中前 widthi 位数字组成的整数。
- yi 为由 di 的十进制表示中剩余所有数字组成的整数。
保证 di 的十进制表示包含的数字位数大于 widthi。因此，xi 和 yi 都至少包含一位数字。
nums[i] 的 解码值 为 xi^yi。
返回 nums 中所有元素的解码值之和，并对 10^9 + 7 取模。
floor() 函数返回除法结果的整数部分。
提示：
1 <= nums.length <= 10^5
100 < nums[i] < 10^15
1 <= widthi <= 9
1 <= xi, yi < 10^9
用于构成 xi 和 yi 的数字序列均不包含前导零。
保证 nums 中的每个元素都是有效的编码整数。

模拟。快速幂。
时间复杂度 O(nlogU)。
 */