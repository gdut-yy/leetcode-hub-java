package p134;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF134B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int INF = (int) 1e9;

    private static void solve() {
        int n = scanner.nextInt();
        int ans = n;

        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f(i, n));
        }
        out.print(ans);
    }

    public static int f(int a, int b) {
        int ans = 0;
        while (a > 1) {
            ans += b / a;
            int temp = b % a;
            b = a;
            a = temp;
        }
        if (a == 1) {
            return ans + b - 1;
        }
        return INF; // 1e9
    }
}
/*
B. Pairs of Numbers
https://codeforces.com/contest/134/problem/B

灵茶の试炼 2025-10-30
题目大意：
输入 n(1≤n≤1e6)。
你从 (a,b) = (1,1) 出发。
从 (a,b) 可以一步移动到 (a+b,b) 或者 (a,a+b)。
输出从 (1,1) 移动到一个包含 n 的坐标的最小步数，即移动到 (n,i) 或者 (i,n)。

rating 1900
关键性质：
如果 a > b，那么上一步一定是 a += b
如果 a < b，那么上一步一定是 b += a
如果 a = b，那么上一步在 (a,0) 或者 (0,a)，无解。
我们可以像计算 gcd 那样，用辗转相除法。
定义递归函数 f(a,b)：
如果 a=0，那么无解，返回 inf。
如果 a=1，那么只能把 b 不断倒退回到 (1,1)，需要 b-1 步。
否则返回 b/a + f(b%a,a)：
如果 a>b，那么我们计算的是 f(b,a)。（注意 f(a,b) = f(b,a)）
否则先计算把 b 减小到 < a 的步数，即 b/a，再加上从 (b%a,a) 倒退回到起点的最小步数。
最后，枚举 i，计算 f(i,n) 的最小值。
只需要从 1 枚举到 n，因为对于 i>n 来说，要先倒退回到 i<=n，这是不优的。
代码 https://codeforces.com/problemset/submission/134/342711531
代码备份（上面打不开的同学看这个）
相似题目
LC780. 到达终点
LC2543. 判断一个点是否可以到达
LC3609. 到达目标点的最小移动次数
======

Input
5
Output
3

Input
1
Output
0
 */
