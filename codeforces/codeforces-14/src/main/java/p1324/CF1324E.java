package p1324;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1324E {
    private static int n, h, l, r;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        h = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static int[][] memo;

    private static String solve() {
        memo = new int[n][h];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = f(0, 0);
        return String.valueOf(res);
    }

    private static int f(int i, int s) {
        if (i == n) {
            return (l <= s && s <= r) ? 1 : 0;
        }
        if (memo[i][s] != -1) {
            return memo[i][s];
        }

        int f1 = f(i + 1, (s + a[i]) % h);
        int f2 = f(i + 1, (s + a[i] - 1) % h);
        int res = Math.max(f1, f2);
        if (i > 0 && l <= s && s <= r) {
            res++;
        }

        memo[i][s] = res;
        return res;
    }
}
/*
E. Sleeping Schedule
https://codeforces.com/contest/1324/problem/E

灵茶の试炼 2023-02-13
题目大意：
输入 n(≤2000) h L R (0≤L≤R<h≤2000) 和长为 n 的数组 a(1≤a[i]<h)。
对于每个 a[i]，你可以把它减一，或者保持不变（换句话说，每个 a[i] 至多 -1 一次）。
定义前缀和 s[0]=a[0], s[i]=s[i-1]+a[i]。
如果 s[i]%h 落在闭区间 [L,R] 内，则分数加一。
最大化分数。

https://codeforces.com/contest/1324/submission/193356533
记忆化搜索。
======

input
7 24 21 23
16 17 14 20 20 11 22
output
3
 */
