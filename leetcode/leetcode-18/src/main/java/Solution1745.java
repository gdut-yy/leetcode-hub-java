public class Solution1745 {
    public boolean checkPartitioning(String s) {
        return palindromePartition(s, 3) == 0;
    }

    // 1278. 分割回文串 III
    private int palindromePartition(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] minChange = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                minChange[i][j] = minChange[i + 1][j - 1] + (s[i] != s[j] ? 1 : 0);
            }
        }

        int[] f = minChange[0];
        for (int i = 1; i < k; i++) {
            for (int r = n - k + i; r >= i; r--) {
                f[r] = Integer.MAX_VALUE;
                for (int l = i; l <= r; l++) {
                    f[r] = Math.min(f[r], f[l - 1] + minChange[l][r]);
                }
            }
        }
        return f[n - 1];
    }
}
/*
1745. 分割回文串 IV
https://leetcode.cn/problems/palindrome-partitioning-iv/description/

给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
提示：
3 <= s.length <= 2000
s 只包含小写英文字母。

相似题目: 1278. 分割回文串 III
https://leetcode.cn/problems/palindrome-partitioning-iii/
 */