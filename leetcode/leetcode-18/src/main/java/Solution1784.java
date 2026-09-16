public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int cnt = 0;
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s.charAt(i) == s.charAt(i - 1); i++) {
            }
            if (s.charAt(st) == '1') cnt++;
        }
        return cnt <= 1;
    }
}
/*
1784. 检查二进制字符串字段
https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

给你一个二进制字符串 s ，该字符串 不含前导零 。
如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
提示：
1 <= s.length <= 100
s[i] 为 '0' 或 '1'
s[0] 为 '1'

分组循环。
时间复杂度 O(n)。
 */