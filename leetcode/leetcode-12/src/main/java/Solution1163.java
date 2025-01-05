public class Solution1163 {
    public String lastSubstring(String s) {
        return s.substring(minimalString(s.toCharArray(), false));
    }

    // 最小表示法
    private int minimalString(char[] s, boolean isMin) {
        int n = s.length;
        int k = 0, i = 0, j = 1;
        while (k < n && i < n && j < n) {
            int d = chr(s, i + k, isMin) - chr(s, j + k, isMin);
            if (d == 0) {
                k++;
            } else {
                if (d > 0 == isMin) i = i + k + 1;
                else j = j + k + 1;
                if (i == j) i++;
                k = 0;
            }
        }
        i = Math.min(i, j);
        return i;
    }

    private int chr(char[] s, int i, boolean isMin) {
        int n = s.length;
        if (i >= n) return isMin ? s[i % n] : 0;
        return s[i];
    }
}
/*
1163. 按字典序排在最后的子串
https://leetcode.cn/problems/last-substring-in-lexicographical-order/description/

给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
提示：
1 <= s.length <= 4 * 10^5
s 仅含有小写英文字符。

最小表示法。
相似题目: 3403. 从盒子中找出字典序最大的字符串 I
https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/
 */