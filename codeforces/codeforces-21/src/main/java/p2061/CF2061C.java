package p2061;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2061C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve1();
        }
        out.flush();
    }

    static final int MOD = 998244353;

    // 状态机 DP
    private static void solve() {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[][] f = new long[n][2];
        f[0][0] = 1;
        if (a[0] == 0) {
            f[0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][1];
            if (a[i] == a[i - 1]) {
                f[i][1] = f[i - 1][1];
            }
            if (i == 1 && a[1] == 1 || i > 1 && a[i] - a[i - 2] == 1) {
                f[i][1] = (f[i][1] + f[i - 1][0]) % MOD;
            }
        }
        long ans = (f[n - 1][0] + f[n - 1][1]) % MOD;
        out.println(ans);
    }

    // 线性 DP
    private static void solve1() {
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i] == a[i - 1]) {
                f[i] = f[i - 1];
            }
            if (i > 1 && a[i] - a[i - 2] == 1) {
                f[i] = (f[i] + f[i - 2]) % MOD;
            }
        }
        long ans = (f[n - 1] + f[n]) % MOD;
        out.println(ans);
    }
}
/*
C. Kevin and Puzzle
https://codeforces.com/contest/2061/problem/C

灵茶の试炼 2025-06-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤n)。
n 个人排成一行，每个人要么是好人（一定说真话），要么是骗子（可能说真话也可能说假话）。
已知第 i 个人说：我左边（不含 i）恰好有 a[i] 个骗子。
已知两个骗子不能相邻。
一共有 2^n 种好人/骗子序列，其中有多少个是符合已知信息的？答案模 998244353。

rating 1600
分析：
如果 i 是骗子，那么 i-1 一定是好人。
如果 i 是好人，那么 i-1 可以是好人也可以是骗子：
- 如果 i-1 是好人，必须有 a[i]=a[i-1]。
- 如果 i-1 是骗子，那么 i-2 一定是好人，必须有 a[i]-a[i-2]=1。
关键在于，我们不需要在 i 的位置去保证左边一定有 a[i] 个骗子，数学归纳法可以为我们保驾护航。如果可以把方案数从最左边一路传过来，那么就自动保证左边一定有 a[i] 个骗子。
根据上面的分析，可以写状态机 DP 或者线性 DP。
状态机 DP https://codeforces.com/contest/2061/submission/323109263
线性 DP https://codeforces.com/contest/2061/submission/323109955
代码备份（洛谷）
提示：注意到状态机 DP 中的 f[i][0] = f[i-1][1]，即骗子总是从好人转移过来，我们可以用 f[i-1][1] 代替 f[i][0]，从而去掉 f[i][0]，化简成线性 DP。
======

Input
8
3
0 1 2
5
0 0 0 0 0
5
0 0 1 1 2
5
0 1 2 3 4
5
0 0 1 1 1
5
5 1 5 2 5
1
0
4
2 3 1 1
Output
1
2
3
0
4
1
2
0
 */
