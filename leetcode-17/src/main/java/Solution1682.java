import java.util.Arrays;

public class Solution1682 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][][] memo = new int[len][len][26];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int max = -1;
        for (int c = 0; c < 26; c++) {
            max = Math.max(max, f(0, len - 1, c, memo, s));
        }
        return max;
    }

    private int f(int i, int j, int c, int[][][] memo, String s) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j][c] != -1) {
            return memo[i][j][c];
        }

        if (s.charAt(i) != (char) ('a' + c)) {
            memo[i][j][c] = f(i + 1, j, c, memo, s);
            return memo[i][j][c];
        }
        if (s.charAt(j) != (char) ('a' + c)) {
            memo[i][j][c] = f(i, j - 1, c, memo, s);
            return memo[i][j][c];
        }

        int res = -1;
        for (int delta = 0; delta < 26; delta++) {
            if (c != delta) {
                res = Math.max(res, 2 + f(i + 1, j - 1, delta, memo, s));
            }
        }
        memo[i][j][c] = res;
        return res;
    }
}
/*
$1682. 最长回文子序列 II
https://leetcode.cn/problems/longest-palindromic-subsequence-ii/

字符串 s 的某个子序列符合下列条件时，称为“好的回文子序列”：
- 它是 s 的子序列。
- 它是回文序列（反转后与原序列相等）。
- 长度为偶数。
- 除中间的两个字符外，其余任意两个连续字符不相等。
例如，若 s = "abcabcabb"，则 "abba" 可称为“好的回文子序列”，而 "bcb" （长度不是偶数）和 "bbbb" （含有相等的连续字符）不能称为“好的回文子序列”。
给定一个字符串 s， 返回 s 的最长“好的回文子序列”的长度。
提示:
1 <= s.length <= 250
s 包含小写英文字母。

记忆化搜索
时间复杂度 O(n^2)
 */