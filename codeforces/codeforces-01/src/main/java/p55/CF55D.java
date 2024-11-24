package p55;

import java.util.Arrays;
import java.util.Scanner;

public class CF55D {
    static String low, high;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            low = scanner.next();
            high = scanner.next();
            System.out.println(solve());
        }
    }

    static int[] lcms = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 18, 20, 21, 24, 28, 30, 35, 36, 40, 42, 45, 56, 60, 63, 70, 72, 84, 90, 105, 120, 126, 140, 168, 180, 210, 252, 280, 315, 360, 420, 504, 630, 840, 1260, 2520};
    static int[] idx = new int[2521];
    static int[][] lcmRes;

    static {
        for (int i = 0; i < lcms.length; i++) {
            int v = lcms[i];
            idx[v] = i;
        }
        lcmRes = new int[lcms.length][10];
        for (int i = 0; i < lcms.length; i++) {
            int v = lcms[i];
            lcmRes[i][0] = i;
            lcmRes[i][1] = i;
            for (int j = 2; j < 10; j++) {
                lcmRes[i][j] = idx[getLCM(v, j)];
            }
        }
    }

    static int n;
    static long[][][] memo;

    private static String solve() {
        n = high.length();
        low = "0".repeat(n - low.length()) + low;

        memo = new long[n][lcms.length][2520];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lcms.length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return String.valueOf(f(0, 0, 0, true, true));
    }

    static long f(int i, int j, int rem, boolean limitLow, boolean limitHigh) {
        if (i == n) {
            return rem % lcms[j] > 0 ? 0 : 1;
        }
        if (!limitLow && !limitHigh && memo[i][j][rem] != -1) {
            return memo[i][j][rem];
        }
        int lo = limitLow ? low.charAt(i) - '0' : 0;
        int hi = limitHigh ? high.charAt(i) - '0' : 9;
        long res = 0;
        for (int d = lo; d <= hi; d++) {
            res += f(i + 1, lcmRes[j][d], (rem * 10 + d) % 2520, limitLow && d == lo, limitHigh && d == hi);
        }
        if (!limitLow && !limitHigh) {
            memo[i][j][rem] = res;
        }
        return res;
    }

    private static int getLCM(int num1, int num2) {
        return num1 / getGCD(num1, num2) * num2;
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Beautiful numbers
https://codeforces.com/contest/55/problem/D

灵茶の试炼 2024-02-16
题目大意：
输入 T(≤10) 表示 T 组数据。
每组数据输入 L R(1≤L≤R≤9e18)。
输出 [L,R] 内有多少个数字，能被其每个非零数位整除？
例如 240 能被 2 和 4 整除，符合要求。

rating 2500
数位 DP。
如果一个数字 num 被多个数整除，那么 num 也被这些数的最小公倍数（LCM）整除。
比如 num 被 6,4,3 整除，那么 num 也必然被 12 整除。
考虑到 LCM(1,2,3,...,9) = 2520，我们无需在记忆化搜索时记录 num，而是记录 num % 2520。
如果 num % 2520 能被 num 的所有非零数位的 LCM 整除，那么 num 也同样能被 LCM 整除。
定义 dfs(i,j,rem) 表示当前枚举到第 i 个数位，之前枚举的数位的 LCM 为 j，num % 2520 = rem。
递归终点：如果 i = n 时 rem % j = 0，则说明构造的 num 是合法的，返回 1，否则返回 0。
由于 j 最大是 2520，直接创建 9*2520*2520 的 64 位整形数组是会 MLE 的（约 436MB）。
可以预处理 {1,2,3,..,9} 的所有非空子集的 LCM（这有 48 个），把这 48 个数离散化一下，就可以大大减少空间了。
另外在 dfs 中算 LCM 可能有点慢，可以打表预处理这 48 个数与 1~9 的 LCM 的结果。
https://codeforces.com/problemset/submission/55/245857910
======

input
1
1 9
output
9

input
1
12 15
output
2
 */
