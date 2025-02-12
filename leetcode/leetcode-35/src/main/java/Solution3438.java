public class Solution3438 {
    public String findValidPair(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int[10];
        for (char c : s) {
            cnt[c - '0']++;
        }
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] == s[i]) continue;
            if (cnt[s[i - 1] - '0'] == s[i - 1] - '0' &&
                    cnt[s[i] - '0'] == s[i] - '0') {
                return S.substring(i - 1, i + 1);
            }
        }
        return "";
    }
}
/*
3438. 找到字符串中合法的相邻数字
https://leetcode.cn/problems/find-valid-pair-of-adjacent-digits-in-string/description/

第 149 场双周赛 T1。

给你一个只包含数字的字符串 s 。如果 s 中两个 相邻 的数字满足以下条件，我们称它们是 合法的 ：
- 前面的数字 不等于 第二个数字。
- 两个数字在 s 中出现的次数 恰好 分别等于这个数字本身。
请你从左到右遍历字符串 s ，并返回最先找到的 合法 相邻数字。如果这样的相邻数字不存在，请你返回一个空字符串。
提示：
2 <= s.length <= 100
s 只包含 '1' 到 '9' 的数字。

中国时间：2025-02-01 22:30
2025春节初四
模拟。
 */