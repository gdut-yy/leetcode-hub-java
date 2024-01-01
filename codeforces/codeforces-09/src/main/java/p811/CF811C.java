package p811;

import java.util.Scanner;

public class CF811C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MAX_N = 5005;

    private static String solve() {
        int[] l = new int[MAX_N];
        int[] r = new int[MAX_N];
        for (int i = 1; i <= n; i++) {
            if (l[a[i]] == 0) {
                l[a[i]] = i;
            }
            r[a[i]] = i;
        }

        int[] f = new int[n + 1];
        int[] vis = new int[MAX_N];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            int j = i, ll = l[a[i]], xor = 0;
            while (j > 0) {
                int v = a[j];
                if (vis[v] < i) {
                    if (r[v] > j) break;
                    vis[v] = i;
                    ll = Math.min(ll, l[v]);
                    xor ^= v;
                }
                if (ll == j) {
                    f[i] = Math.max(f[i], f[j - 1] + xor);
                }

                j--;
            }
        }
        return String.valueOf(f[n]);
    }
}
/*
C. Vladik and Memorable Trip
https://codeforces.com/contest/811/problem/C

灵茶の试炼 2022-10-05
题目大意：
输入 n(≤5000) 和一个长为 n 的数组 a (0≤a[i]≤5000)。
你需要从 a 中选取若干个互不相交的子数组，且对于每个子数组 b，b 中的元素不会出现在 b 外面。
对每个子数组去重，求异或和，然后把所有异或和相加，输出相加后的最大值。
注：子数组是连续的。
注：你不需要把每个 a[i] 都选上，见样例二。

左右位置：https://codeforces.com/contest/811/submission/174568758
元素个数（代码更短）：https://codeforces.com/contest/811/submission/174568255
dp[i] = dp[j-1] + xor(unique(j..i)) if a[j..i] is valid.
判断合法有两种写法，见上面的代码。
======

input
6
4 4 2 5 2 3
output
14

input
9
5 1 3 1 5 2 4 2 5
output
9
 */
