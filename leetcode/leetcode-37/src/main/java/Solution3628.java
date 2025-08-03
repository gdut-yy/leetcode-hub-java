public class Solution3628 {
    public long numOfSubsequences(String s) {
        long ans = numDistinct(s, "LCT"); // 不操作
        long extra = numDistinct(s, "CT"); // 最前面加 L
        extra = Math.max(extra, numDistinct(s, "LC")); // 最后面加 T
        extra = Math.max(extra, calcInsertC(s.toCharArray())); // 中间加 C
        return ans + extra;
    }

    // 计算插入 C 额外产生的 LCT 子序列个数的最大值
    private long calcInsertC(char[] s) {
        int cntT = 0;
        for (char c : s) {
            if (c == 'T') {
                cntT++;
            }
        }

        long res = 0;
        int cntL = 0;
        for (char c : s) {
            if (c == 'T') {
                cntT--;
            }
            if (c == 'L') {
                cntL++;
            }
            res = Math.max(res, (long) cntL * cntT);
        }
        return res;
    }

    // 115
    private long numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] f = new long[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = 1;
            for (int j = 0; j <= i && j < m; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    f[i + 1][j + 1] = (f[i][j] + f[i][j + 1]);
                } else {
                    f[i + 1][j + 1] = f[i][j + 1];
                }
            }
        }
        return f[n][m];
    }
}
/*
3628. 插入一个字母的最大子序列数
https://leetcode.cn/problems/maximum-number-of-subsequences-after-one-inserting/description/

第 460 场周赛 T2。

给你一个由大写英文字母组成的字符串 s。
你可以在字符串的 任意 位置（包括字符串的开头或结尾）最多插入一个 大写英文字母。
返回在 最多插入一个字母 后，字符串中可以形成的 "LCT" 子序列的 最大 数量。
子序列 是从另一个字符串中删除某些字符（可以不删除）且不改变剩余字符顺序后得到的一个 非空 字符串。
提示：
1 <= s.length <= 10^5
s 仅由大写英文字母组成。

不插入情况 + extra（最前面加 L, 最后面加 T, 中间加 C）三种情况
时间复杂度 O(n)。
 */