import java.util.Arrays;

public class Solution3472 {
    private char[] s;
    private int[][][] memo;

    public int longestPalindromicSubsequence(String S, int k) {
        this.s = S.toCharArray();
        int n = s.length;
        memo = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, n - 1, k);
    }

    private int dfs(int i, int j, int k) {
        if (i >= j) return j - i + 1; // i=j+1 时返回 0，i=j 时返回 1
        if (memo[i][j][k] != -1) return memo[i][j][k];
        int res = Math.max(dfs(i + 1, j, k), dfs(i, j - 1, k)); // 枚举哪个不选
        int d = Math.abs(s[i] - s[j]);
        int cost = Math.min(d, 26 - d);
        if (k - cost >= 0) {
            res = Math.max(res, dfs(i + 1, j - 1, k - cost) + 2);
        }
        return memo[i][j][k] = res;
    }
}
/*
3472. 至多 K 次操作后的最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence-after-at-most-k-operations/description/

第 439 场周赛 T2。

给你一个字符串 s 和一个整数 k。
在一次操作中，你可以将任意位置的字符替换为字母表中相邻的字符（字母表是循环的，因此 'z' 的下一个字母是 'a'）。例如，将 'a' 替换为下一个字母结果是 'b'，将 'a' 替换为上一个字母结果是 'z'；同样，将 'z' 替换为下一个字母结果是 'a'，替换为上一个字母结果是 'y'。
返回在进行 最多 k 次操作后，s 的 最长回文子序列 的长度。
子序列 是一个 非空 字符串，可以通过删除原字符串中的某些字符（或不删除任何字符）并保持剩余字符的相对顺序得到。
回文 是正着读和反着读都相同的字符串。
提示:
1 <= s.length <= 200
1 <= k <= 200
s 仅由小写英文字母组成。

区间 DP。
时间复杂度 O(n^2 * k)。
相似题目: 516. 最长回文子序列
https://leetcode.cn/problems/longest-palindromic-subsequence/
 */