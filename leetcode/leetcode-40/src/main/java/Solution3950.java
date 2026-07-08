public class Solution3950 {
    static class V1 {
        public boolean consecutiveSetBits(int n) {
            char[] s = Integer.toBinaryString(n).toCharArray();
            int i = 0;
            int cnt = 0;
            while (i < s.length) {
                int st = i;
                for (i++; i < s.length && s[i] == s[st]; i++) {
                }
                if (s[st] == '0') continue;
                int len = i - st;
                if (len > 2) return false;
                else if (len == 2) {
                    cnt++;
                }
            }
            return cnt == 1;
        }
    }

    static class V2 {
        public boolean consecutiveSetBits(int n) {
            int m = n & (n >> 1); // 所有相邻比特位的 &
            return m > 0 && (m & (m - 1)) == 0; // m 是否恰好有一个 1
        }
    }
}
/*
3950. 恰好一对连续置位
https://leetcode.cn/problems/exactly-one-consecutive-set-bits-pair/description/

第 184 场双周赛 T1。

给你一个整数 n 。
如果其二进制表示中 恰好 仅包含 一对 相邻的置位 ，则返回 true ，否则返回 false 。
整数中的 置位 是指其 二进制 表示中的 1 。
提示：
0 <= n <= 10^5

位运算技巧。
时间复杂度 O(1)。
 */