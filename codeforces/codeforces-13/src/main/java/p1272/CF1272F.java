package p1272;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1272F {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;
    static int n, m;
    static int[][][] memo;
    static StringBuilder ans;

    private static String solve() {
        n = s.length();
        m = t.length();
        s += "$";
        t += "$";

        memo = new int[n + 1][m + 1][n + m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        ans = new StringBuilder();
        maskAns(0, 0, 0);
        return ans.toString();
    }

    static void maskAns(int i, int j, int k) {
        if (i == n && j == m && k == 0) {
            return;
        }

        int i1 = s.charAt(i) == '(' ? 1 : 0, j1 = t.charAt(j) == '(' ? 1 : 0;
        int i2 = s.charAt(i) == ')' ? 1 : 0, j2 = t.charAt(j) == ')' ? 1 : 0;
        if (f(i + i1, j + j1, k + 1) + 1 == f(i, j, k)) {
            ans.append("(");
            maskAns(i + i1, j + j1, k + 1);
        } else {
            ans.append(")");
            maskAns(i + i2, j + j2, k - 1);
        }
    }

    static int f(int i, int j, int k) {
        if (k > n + m) {
            return INF;
        }
        if (i == n && j == m && k == 0) {
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        memo[i][j][k] = INF;

        int i1 = s.charAt(i) == '(' ? 1 : 0, j1 = t.charAt(j) == '(' ? 1 : 0;
        int i2 = s.charAt(i) == ')' ? 1 : 0, j2 = t.charAt(j) == ')' ? 1 : 0;
        int res = f(i + i1, j + j1, k + 1) + 1;
        if (k > 0) {
            res = Math.min(res, f(i + i2, j + j2, k - 1) + 1);
        }
        return memo[i][j][k] = res;
    }
}
/*
F. Two Bracket Sequences
https://codeforces.com/contest/1272/problem/F

灵茶の试炼 2023-06-02
输入两个长度不超过 200 的字符串 s 和 t，只包含左右括号。
输出 s 和 t 的最短公共超序列，要求这个超序列是一个合法括号字符串。（多解输出任意解。）

rating 2200
https://codeforces.com/problemset/submission/1272/208121980
请先看下面这篇题解
https://leetcode.cn/problems/shortest-common-supersequence/solutions/2194615/cong-di-gui-dao-di-tui-jiao-ni-yi-bu-bu-auy8z/
在计算最长公共超序列的基础上，增加一个参数 k 表示左括号比右括号多多少。
相似题目: 1092. 最短公共超序列
https://leetcode.cn/problems/shortest-common-supersequence/
======

input
(())(()
()))()
output
(())()()

input
)
((
output
(())

input
)
)))
output
((()))

input
())
(()(()(()(
output
(()()()(()()))
 */
