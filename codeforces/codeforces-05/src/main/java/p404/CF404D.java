package p404;

import java.util.Arrays;
import java.util.Scanner;

public class CF404D {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve1());
    }

    static final int MOD = (int) (1e9 + 7);
    static long[][] memo;

    private static String solve() {
        int n = s.length;
        memo = new long[3][n];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = (f(n - 1, 0) + f(n - 1, 1)) % MOD;
        return String.valueOf(ans);
    }

    // java 8/21 Runtime error on test 8: StackOverflowError
    // 替换成 BiFunction 一样 StackOverflowError，太sb了
    //     static BiFunction<Integer, Integer, Long> func = new BiFunction<>() {
    //        @Override
    //        public Long apply(Integer i, Integer j) {
    //            ...
    //        }
    //    };
    static long f(int i, int j) {
        if (i < 0) {
            return j == 1 ? 0 : 1;
        }
        if (memo[j][i] != -1) return memo[j][i];

        long res;
        // s[i] 不能是雷
        if (j == 0) {
            if (s[i] == '0') {
                res = f(i - 1, 0);
            } else if (s[i] == '1') {
                res = f(i - 1, 1);
            } else if (s[i] == '2' || s[i] == '*') {
                res = 0;
            } else {
                res = (f(i - 1, 0) + f(i - 1, 1)) % MOD;
            }
        }
        // s[i] 一定是雷
        else if (j == 1) {
            if (s[i] == '0' || s[i] == '1' || s[i] == '2') {
                res = 0;
            } else {
                res = f(i - 1, 2);
            }
        }
        // s[i+1] 是雷
        else {
            if (s[i] == '0') {
                res = 0;
            } else if (s[i] == '1') {
                res = f(i - 1, 0);
            } else if (s[i] == '2') {
                res = f(i - 1, 1);
            } else if (s[i] == '*') {
                res = f(i - 1, 2);
            } else {
                res = (f(i - 1, 0) + f(i - 1, 1) + f(i - 1, 2)) % MOD;
            }
        }
        return memo[j][i] = res;
    }

    private static String solve1() {
        long f0 = 1, f1 = 0, f2 = 1;
        for (char c : s) {
            if (c == '0') {
                f1 = 0;
                f2 = 0;
            } else if (c == '1') {
                f2 = f0;
                f0 = f1;
                f1 = 0;
            } else if (c == '2') {
                f2 = f1;
                f0 = 0;
                f1 = 0;
            } else if (c == '*') {
                f0 = 0;
                f1 = f2;
            } else {
                long _f0 = f0, _f1 = f1, _f2 = f2;
                f0 = (f0 + f1) % MOD;
                f1 = f2;
                f2 = (_f0 + _f1 + _f2) % MOD;
            }
        }
        long ans = (f0 + f1) % MOD;
        return String.valueOf(ans);
    }
}
/*
D. Minesweeper 1D
https://codeforces.com/contest/404/problem/D

灵茶の试炼 2023-11-09
题目大意：
输入一个长度在 [1,1e6] 内的字符串，由五种字符 *?012 组成，表示一个「一维扫雷游戏」的局面。
其中 * 表示雷，数字表示左右相邻位置有多少个雷。
把 ? 替换成 *012 中的一个，可以得到多少个合法的局面？模 1e9+7。

rating 1900
定义 dfs(i,j) 表示考虑 s[0]~s[i]，j=0/1/2 分别为：s[i]不能是雷/s[i]一定是雷/s[i+1]是雷，返回在这种情况下的方案数。
分类讨论即可。
递归边界：dfs(-1,0) = dfs(-1,2) = 1, dfs(-1,1) = 0
递归入口：dfs(n-1,0) + dfs(n-1,1)
记忆化搜索 https://codeforces.com/contest/404/submission/231110907
1:1 翻译成递推 + 空间优化 https://codeforces.com/contest/404/submission/231112560
Python 递推代码 https://codeforces.com/contest/404/submission/231114035
======

input
?01???
output
4

input
?
output
2

input
**12
output
0

input
1
output
0
 */
