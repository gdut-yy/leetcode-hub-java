public class Solution3750 {
    public int minimumFlips(int n) {
        String rev = new StringBuilder(Long.toBinaryString(n)).reverse().toString();
        long b = Long.parseLong(rev, 2);
        b ^= n;
        return Long.bitCount(b);
    }

    public int minimumFlips2(int n) {
        int rev = Integer.reverse(n) >>> Integer.numberOfLeadingZeros(n);
        return Integer.bitCount(n ^ rev);
    }
}
/*
3750. 最少反转次数得到翻转二进制字符串
https://leetcode.cn/problems/minimum-number-of-flips-to-reverse-binary-string/description/

第 170 场双周赛 T1。

给你一个 正 整数 n。
令 s 为 n 的 二进制表示（不含前导零）。
二进制字符串 s 的 反转 是指将 s 中的字符按相反顺序排列得到的字符串。
你可以翻转 s 中的任意一位（将 0 → 1 或 1 → 0）。每次翻转 仅 影响一位。
请返回使 s 等于其原始形式的反转所需的 最少 翻转次数。
提示：
1 <= n <= 10^9

模拟。
时间复杂度 O(logn)。
 */