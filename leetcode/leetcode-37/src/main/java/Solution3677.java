public class Solution3677 {
    public int countBinaryPalindromes(long n) {
        if (n == 0) {
            return 1;
        }
        String binaryStr = Long.toBinaryString(n);
        int totalLen = binaryStr.length();
        long count = 1;

        for (int L = 1; L < totalLen; L++) {
            int halfLen = (L + 1) / 2;
            count += (1L << (halfLen - 1));
        }

        int halfLen = (totalLen + 1) / 2;
        long low = 1L << (halfLen - 1);
        long high = (1L << halfLen) - 1;

        long left = low, right = high;
        long lastValid = low - 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long palin = constructPalindrome(mid, totalLen);
            if (palin <= n) {
                lastValid = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (lastValid >= low) {
            count += (lastValid - low + 1);
        }
        return (int) count;
    }

    private long constructPalindrome(long p, int len) {
        int halfLen = (len + 1) / 2;
        if (len % 2 == 0) {
            long reversed = reverseBits(p, halfLen);
            return (p << halfLen) | reversed;
        } else {
            long reversed = reverseBits(p >> 1, halfLen - 1);
            return (p << (halfLen - 1)) | reversed;
        }
    }

    private long reverseBits(long num, int bits) {
        long rev = 0;
        for (int i = 0; i < bits; i++) {
            rev = (rev << 1) | (num & 1);
            num >>= 1;
        }
        return rev;
    }
}
/*
3677. 统计二进制回文数字的数目
https://leetcode.cn/problems/count-binary-palindromic-numbers/description/

第 466 场周赛 T4。

给你一个 非负 整数 n。
如果一个 非负 整数的二进制表示（不含前导零）正着读和倒着读都一样，则称该数为 二进制回文数。
返回满足 0 <= k <= n 且 k 的二进制表示是回文数的整数 k 的数量。
注意： 数字 0 被认为是二进制回文数，其表示为 "0"。
提示:
0 <= n <= 10^15

方法思路
1.特殊情况处理：如果n为0，直接返回1，因为0是二进制回文数。
2.计算二进制长度：将n转换为二进制字符串，并计算其长度len。
3.统计较短长度的回文数：对于每个长度L从1到len-1，计算该长度的二进制回文数的数量。这些回文数的数量由前半部分的位数决定，即2^(halfLen-1)，其中halfLen是(L+1)/2。
4.统计相同长度的回文数：对于长度为len的二进制回文数，使用二分查找来高效地确定满足条件的回文数数量，而不是逐个生成和检查。
https://chat.deepseek.com/a/chat/s/f16c1854-1de7-4750-b0c3-19b280f76ae2
 */