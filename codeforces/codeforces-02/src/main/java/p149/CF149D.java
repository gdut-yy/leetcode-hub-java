package p149;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CF149D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static final int MOD = (int) (1e9 + 7);
    private static int[] right;
    private static long[][][][] memo;

    private static String solve(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        right = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                int pop = stack.pop();
                right[pop] = i;
            }
        }

        // 记忆化搜索
        memo = new long[n][n][3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        long res = dfs(0, n - 1, 0, 0);
        return String.valueOf(res);
    }

    private static long dfs(int l, int r, int lc, int rc) {
        if (l > r) {
            return 1L;
        }
        if (memo[l][r][lc][rc] != -1) {
            return memo[l][r][lc][rc];
        }

        long res = 0L;
        int mid = right[l];
        if (mid < r) {
            res += dfs(l + 1, mid - 1, 0, 1) * dfs(mid + 1, r, 1, rc);
            res += dfs(l + 1, mid - 1, 0, 2) * dfs(mid + 1, r, 2, rc);
            if (lc != 1) res += dfs(l + 1, mid - 1, 1, 0) * dfs(mid + 1, r, 0, rc);
            if (lc != 2) res += dfs(l + 1, mid - 1, 2, 0) * dfs(mid + 1, r, 0, rc);
        } else {
            if (lc != 1) res += dfs(l + 1, r - 1, 1, 0);
            if (lc != 2) res += dfs(l + 1, r - 1, 2, 0);
            if (rc != 1) res += dfs(l + 1, r - 1, 0, 1);
            if (rc != 2) res += dfs(l + 1, r - 1, 0, 2);
        }
        res %= MOD;
        return memo[l][r][lc][rc] = res;
    }
}
/*
D. Coloring Brackets
https://codeforces.com/contest/149/problem/D

灵茶の试炼 2023-04-27
题目大意：
输入一个合法括号字符串，仅包含 '(' 和 ')'，长度范围 [2,700]。
对括号染色，必须满足如下所有条件：
1. 一个括号可以染成红色、蓝色或者不染色。
2. 对于一对匹配的括号，恰好其中一个被染色。
3. 两个相邻的染了色的括号，颜色不能相同。
求染色方案数，模 1e9+7。

https://codeforces.com/contest/149/submission/203169633
首先预处理每个左括号对应的右括号的位置，用栈来处理。
由于是从外到内递归，从内到外转移，所以是区间 DP，可以看 https://www.bilibili.com/video/BV1Gs4y1E7EU/
DP 除了记录区间左右端点 l r 外，为了判断条件 3，还需要记录 l-1 和 r+1 的颜色。
然后就是分类讨论了，具体见代码。
======

input
(())
output
12

input
(()())
output
40

input
()
output
4
 */
