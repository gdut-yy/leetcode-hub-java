public class Solution3931 {
    public boolean isAdjacentDiffAtMostTwo(String S) {
        char[] s = S.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (Math.abs(s[i] - s[i - 1]) > 2) {
                return false;
            }
        }
        return true;
    }
}
/*
3931. 检查相邻数字差
https://leetcode.cn/problems/check-adjacent-digit-differences/description/

第 502 场周赛 T1。

给你一个由数字组成的字符串 s。
如果每一对 相邻 数字之间的 绝对差 都至多为 2，则返回 true；否则返回 false。
a 和 b 之间的绝对差定义为 abs(a - b)。
提示：
2 <= s.length <= 100
s 仅由数字组成。

中国时间 2026-05-17 周日 10:30
深圳。
遍历。
时间复杂度 O(n)。
 */