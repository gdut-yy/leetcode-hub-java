package p2081;

import java.util.Arrays;
import java.util.Scanner;

public class CF2081A {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve1());
        }
    }

    static final int MOD = (int) (1e9 + 7);
    static final int inv2 = (MOD + 1) / 2;

    private static String solve() {
        long f = 0;
        for (int i = n - 1; i > 0; i--) {
            f = (f + (s[i] & 1)) * inv2 % MOD;
        }
        long ans = (n - 1 + f) % MOD;
        return String.valueOf(ans);
    }

    static int[] cnt1;
    static long[][] dp;

    private static String solve1() {
        int c1 = 0;
        cnt1 = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                c1 = 0;
            } else {
                c1++;
                cnt1[i] = c1;
            }
        }

        dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return String.valueOf(f(n - 1, 0));
    }

    static long f(int i, int j) {
        if (i <= 0) {
            return 0;
        }
        if (dp[i][j] >= 0) return dp[i][j];
        long res = f(i - 1, 0) + 1;
        if (j == 0 && s[i] == '0') {
            return res;
        }
        int c = cnt1[i - j] + j;
        long res2 = f(i - c, 1) + c;
        return dp[i][j] = (res + res2) * inv2 % MOD;
    }
}
/*
A. Math Division
https://codeforces.com/contest/2081/problem/A

灵茶の试炼 2025-05-22
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的字符串 s，表示一个二进制整数 x。保证最高位 s[0]=1。
每次操作，要么把 x 变成 floor(x/2)，要么把 x 变成 ceil(x/2)，概率都是 1/2。
输出把 x 变成 1 的期望操作次数，模 M=1e9+7。
设答案为既约分数 P/Q，你需要输出 P*pow(Q,M-2)%M。

rating 1800
从位运算的角度看，下取整就是右移一位，上取整就是先加一再右移一位。
最终要得到 1。
加一会导致进位。
如果最高位 s[0] 没有发生进位，那么右移次数是 n-1。
如果最高位 s[0] 发生进位，那么右移次数是 n。
因此，转化成计算最高位发生进位的概率 P，那么答案为 n-1+P。
从右往左算。下标从 n-1 到 0。
定义 f[i] 表示 s[i] 发生进位的概率。
如果 s[i] = 0，那么 s[i+1] 必须进位且 s[i] 选择上取整，才能让 s[i] 进位，得 f[i] = f[i+1] * (1/2)。
如果 s[i] = 1，那么若 s[i+1] 进位，则 s[i] 一定进位；或者 s[i+1] 没有进位且 s[i] 选择上取整，从而让 s[i] 进位，得 f[i] = f[i+1] + (1-f[i+1]) * (1/2) = (f[i+1]+1) * (1/2)。
二者整合为：f[i] = (f[i+1] + int(s[i])) * (1/2)
初始 f[n] = 0。
计算到 f[1] 为止。
如果 s[1] 进位，那么 s[0] 一定会进位。（s[0] 一定是 1）
如果 s[1] 没有进位，那么 s[0] 不会进位。注意我们不会在 s[0] 做上取整，因为此时已经是 1 了。
所以 P = f[1]。
代码 https://codeforces.com/contest/2081/submission/320484694
代码备份（洛谷）
附：状态机 DP 写法 https://codeforces.com/contest/2081/submission/320454305
======

Input
3
3
110
3
100
10
1101001011
Output
500000006
2
193359386
 */
