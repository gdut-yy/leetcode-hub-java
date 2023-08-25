package c159;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc159_f {
    static int n, s;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long ans = 0;
        long[] f = new long[s + 1];
        for (int i = 0; i < n; i++) {
            f[0]++;
            for (int j = s; j >= a[i]; j--) {
                f[j] = (f[j] + f[j - a[i]]) % MOD;
            }
            ans += f[s];
        }
        ans %= MOD;
        return String.valueOf(ans);
    }
}
/*
F - Knapsack for All Segments
https://atcoder.jp/contests/abc159/tasks/abc159_f

灵茶の试炼 2023-08-18
题目大意：
输入 n(1≤n≤3000) s(1≤s≤3000) 和长为 n 的数组 a(1≤a[i]≤3000)。
定义 f(L,R) 等于：在子数组 a[L],a[L+1],...,a[R] 中，元素和恰好等于 s 的子序列的个数。
输出所有 f(L,R) 的和，其中 0≤L≤R<n。
模 998244353。

https://atcoder.jp/contests/abc159/submissions/44666661
下标从 0 开始。
定义 f[i][j] 表示子数组右端点为 i（左端点任意），子序列和为 j 的方案数。
本题要求的答案就是 f[0][s]+f[1][s]+...+f[n-1][s]。
考虑 a[i] 选或不选，有
f[i][j] = f[i-1][j] + f[i-1][j-a[i]]
初始值：f[i][0] = i+1。例如 f[1][0] 表示子数组 {a[1]} 中有 1 个子序列和为 0，子数组 {a[0],a[1]} 中有 1 个子序列和为 0，所以 f[1][0]=2。
======

Input 1
3 4
2 2 4
Output 1
5

Input 2
5 8
9 9 9 9 9
Output 2
0

Input 3
10 10
3 1 4 1 5 9 2 6 5 3
Output 3
152
 */