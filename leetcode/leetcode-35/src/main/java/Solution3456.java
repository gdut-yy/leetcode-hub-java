public class Solution3456 {
    public boolean hasSpecialSubstring(String S, int k) {
        int n = S.length();
        char[] s = S.toCharArray();
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[st]; i++) {
            }
            if (i - st == k) return true;
        }
        return false;
    }
}
/*
3456. 找出长度为 K 的特殊子字符串
https://leetcode.cn/problems/find-special-substring-of-length-k/description/

第 437 场周赛 T1。

给你一个字符串 s 和一个整数 k。
判断是否存在一个长度 恰好 为 k 的子字符串，该子字符串需要满足以下条件：
1.该子字符串 只包含一个唯一字符（例如，"aaa" 或 "bbb"）。
2.如果该子字符串的 前面 有字符，则该字符必须与子字符串中的字符不同。
3.如果该子字符串的 后面 有字符，则该字符也必须与子字符串中的字符不同。
如果存在这样的子串，返回 true；否则，返回 false。
子字符串 是字符串中的连续、非空字符序列。
提示：
1 <= k <= s.length <= 100
s 仅由小写英文字母组成。

分组循环。
时间复杂度 O(n)。
 */