public class Solution3821 {
    public long nthSmallest(long n, int k) {
        long[][] C = new long[51][51];
        for (int i = 0; i <= 50; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        int len = k;
        while (true) {
            long count = C[len - 1][k - 1];
            if (n > count) {
                n -= count;
                len++;
            } else {
                break;
            }
        }

        long res = 1L << (len - 1);
        int need = k - 1;
        for (int pos = len - 2; pos >= 0; pos--) {
            long c = C[pos][need];
            if (c < n) {
                res |= (1L << pos);
                n -= c;
                need--;
            }
        }
        return res;
    }
}
/*
3821. 二进制中恰好K个1的第N小整数
https://leetcode.cn/problems/find-nth-smallest-integer-with-k-one-bits/description/

第 486 场周赛 T4。

给你两个正整数 n 和 k。
返回一个整数，表示其二进制表示中 恰好 包含 k 个 1 的第 n 小的正整数。题目保证答案 严格小于 2^50。
提示：
1 <= n <= 2^50
1 <= k <= 50
答案严格小于 2^50。

试填法 + 组合数学
https://chat.deepseek.com/a/chat/s/e3e10b08-fcf3-48ce-a032-0bdcc24f980d
时间复杂度 O(logn)。
 */