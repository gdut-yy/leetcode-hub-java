public class Solution3844 {
    public int almostPalindromic(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;

        for (int i = 0; i < 2 * n - 1 && ans < n; i++) {
            int l = i / 2;
            int r = (i + 1) / 2;
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
            }
            ans = Math.max(ans, expand(s, l - 1, r)); // 删除 s[l]，继续扩展
            ans = Math.max(ans, expand(s, l, r + 1)); // 删除 s[r]，继续扩展
        }

        return Math.min(ans, n);
    }

    private int expand(char[] s, int l, int r) {
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
        }
        return r - l - 1; // [l+1, r-1] 是回文串
    }
}
/*
3844. 最长的准回文子字符串
https://leetcode.cn/problems/longest-almost-palindromic-substring/description/

第 489 场周赛 T3。

给你一个由小写英文字母组成的字符串 s。
如果一个子字符串在删除 恰好 一个字符后变成回文字符串，那么这个子字符串就是 准回文串（almost-palindromic）。
返回一个整数，表示字符串 s 中最长的 准回文串 的长度。
子字符串是字符串中任意连续的、非空 字符序列。
回文串是一个 非空 字符串，正着读和反着读都相同。
提示：
2 <= s.length <= 2500
s 仅由小写英文字母组成。

中心扩展法 / Manacher 算法 + 后缀数组
https://leetcode.cn/problems/longest-almost-palindromic-substring/solutions/3903063/zhong-xin-kuo-zhan-fa-pythonjavacgo-by-e-kmfw/
时间复杂度 O(n^2)。
或者 O(n)。
 */