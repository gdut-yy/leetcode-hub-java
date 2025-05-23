public class Solution132 {
    public int minCut(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        // 预处理
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - 1 <= j || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }
        // f[i] 表示从下标 0 到 i 的子字符串符合条件的最少分割次数，则问题解为 f[n-1]
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (!isPal[0][i]) {
                f[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        f[i] = Math.min(f[i], f[j - 1] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
/*
132. 分割回文串 II
https://leetcode.cn/problems/palindrome-partitioning-ii/

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
返回符合要求的 最少分割次数 。
提示：
1 <= s.length <= 2000
s 仅由小写英文字母组成

动态规划。
用 f(i) 表示从下标 0 到 i 的子字符串符合条件的最少分割次数，则问题解为 f(n-1)
对于 s[0, i], 如果是回文串，则 f(i) = 0
对于 1 <= j <= i, 逐个 j 判断 s[j, i] 是不是回文串，如果是回文串，则 f(i) = f(j-1)+1 以及 f(i) 的最小值
isPal 二维数组预处理，空间换时间。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */
