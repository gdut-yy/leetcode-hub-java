package p498;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF498B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n, T;

    public static void main(String[] args) {
        n = scanner.nextInt();
        T = scanner.nextInt();
        solve();
        out.flush();
    }

    private static void solve() {
        double ans = 0;
        double[] f = new double[T + 1];
        f[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            double p = scanner.nextInt();
            int t = scanner.nextInt();
            p /= 100;
            double np = Math.pow(1 - p, t - 1);
            double np2 = np * (1 - p);
            double[] nf = new double[T + 1];
            for (int j = i; j <= T; j++) {
                double d = 0;
                if (j > t) {
                    d = f[j - t - 1] * np;
                }
                nf[j] = (nf[j - 1] - d) * (1 - p) + f[j - 1] * p;
                if (j >= t) {
                    nf[j] += f[j - t] * np2;
                }
                ans += nf[j];
            }
            f = nf;
        }
        out.printf("%.9f\n", ans);
    }
}
/*
B. Name That Tune
https://codeforces.com/contest/498/problem/B

灵茶の试炼 2025-05-23
题目大意：
输入 n(1≤n≤5000) 和 T(1≤T≤5000)。
有 n 首歌，每首歌输入两个整数 pi(0≤pi≤100) 和 t(1≤t≤T)。
你在听歌识曲，按输入顺序依次播放。
每首歌从头开始听。每过一秒，识别出这首歌的概率是 p。在这首歌的第 t 秒，你可以立刻识别出这首歌。
成功识别后，立刻开始播放下一首歌。
注：相当于有 t 次抽卡机会，且第 t 次（最后一次）一定抽中。
注：如果所有歌曲都播放完毕，则识别结束，不会重复循环。
输出在 T 秒内识别出的歌曲个数的期望值。
与正确答案的绝对（相对）误差必须 ≤ 1e-6。

rating 2400
由期望的线性性质可知，累加每首歌的期望，就是总期望。
考虑其中一首歌，设其在 T 秒内被识别出的概率是 q，那么这首歌对总期望的贡献是 1*q + 0*(1-q) = q，正好等于概率。
所以累加每首歌在 T 秒内被识别出的概率，就是总期望。
「T 秒内」等价于「第 1,2,3,...,T 秒」。
计算每首歌分别在恰好第 1,2,3,...,T 秒被识别出的概率，累加，就是这首歌在 T 秒内被识别出的概率。
注：比如第二首歌，无法在第 1 秒被识别出，那么这个时刻识别出它的概率为 0。
定义 f[i][j] 表示第 i 首歌恰好在第 j 秒被识别出的概率。
比如 1 秒就识别出第 i 首歌，那么问题变成第 i-1 首歌恰好在第 j-1 秒被识别出的概率，即 f[i-1][j-1]。
以 t[i] = 4 为例，我们有（下文 p 表示 p[i]，t 表示 t[i]）
f[i][j] = f[i-1][j-1] * p + f[i-1][j-2] * (1-p)*p + f[i-1][j-3] * (1-p)^2*p + f[i-1][j-4] * (1-p)^3
对比 f[i][j-1] 和 f[i][j] 的转移方程，比较相似之处（请在草稿纸上推导，回想一下错位相减法），化简可得
f[i][j] = f[i-1][j-1] * p + (f[i][j-1] - f[i-1][j-5] * (1-p)^3) * (1-p) + f[i-1][j-4] * (1-p)^4
一般地
f[i][j] = f[i-1][j-1] * p + (f[i][j-1] - f[i-1][j-t-1] * (1-p)^(t-1)) * (1-p) + f[i-1][j-t] * (1-p)^t
（我代码中把 f[i-1][j-1] * p 移到了右边，只是改了下位置）
初始值 f[0][0] = 1。
答案为 f[i][j] 之和，其中 1<=i<=n 且 1<=j<=T。
代码 https://codeforces.com/problemset/submission/498/319835505
代码备份（洛谷）
======

Input
2 2
50 2
10 1
Output
1.500000000

Input
2 2
0 2
100 2
Output
1.000000000

Input
3 3
50 3
50 2
25 2
Output
1.687500000

Input
2 2
0 2
0 2
Output
1.000000000
 */
