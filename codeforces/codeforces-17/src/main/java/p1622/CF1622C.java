package p1622;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1622C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, long k, int[] a) {
        long tot = 0L;
        for (int x : a) {
            tot += x;
        }
        if (tot <= k) {
            return "0";
        }

        Arrays.sort(a);
        // tot 需减少 tot-k
        long ans = tot - k;
        long s = a[0] - ans;
        for (int i = n - 1; i > 0; i--) {
            s += a[i];
            // x 表示 a[0] 的值
            long x;
            // y 表示减少到 x 的个数
            long y = n - i + 1L;
            if (s >= 0) {
                x = s / y;
            } else {
                x = (s - y + 1) / y;
            }
            x = Math.min(x, a[0]);
            ans = Math.min(ans, (a[0] - x) + (y - 1));
        }
        return String.valueOf(ans);
    }
}
/*
C. Set or Decrease
https://codeforces.com/contest/1622/problem/C

灵茶の试炼 2023-03-28
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(≤2e5) k(1≤k≤1e15) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作，选择一个 a[i]，要么把 a[i] 变成 a[i]-1，要么变成另外一个 a[j]。
要使 sum(a) <= k，至少需要操作多少次？
注意可以把 a[i] 减成负数。

rating 1600
https://codeforces.com/contest/1622/submission/155250743
提示 1：对于减一操作来说，把两个数减一，把一个数减二，都需要操作两次。
考虑到一个数更小，越有利于修改操作（把 a[i] 变成 a[j]），
所以减一操作只需要在 a 中最小的数上进行。
提示 2：先减一，再修改。
提示 3-1：修改最大的若干个数，变成最小的数。
提示 3-2：枚举修改了最大的 0/1/2/3/... 个数，可以反推要执行多少次减一操作。
======

input
4
1 10
20
2 69
6 9
7 8
1 2 1 3 1 2 1
10 1
1 2 3 1 2 6 1 6 8 10
output
10
0
2
7

1
9 789481196696522
6505738 2215625 5092296 2105235 420976 2212868 52678 541483 3147701
0
 */
