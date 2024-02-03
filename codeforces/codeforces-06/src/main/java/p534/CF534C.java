package p534;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF534C {
    static int n;
    static long s;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextLong();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        s -= n;
        long sa = 0;
        for (int v : a) {
            sa += v;
        }

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long mn = Math.max(s - sa + a[i], 0);
            long mx = Math.min(s, a[i]);
            ans[i] = a[i] - mx + mn;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Polycarpus' Dice
https://codeforces.com/contest/534/problem/C

灵茶の试炼 2023-11-22
题目大意：
输入 n(1≤n≤2e5) s(n≤s≤sum(a)) 和长为 n 的数组 a(1≤a[i]≤1e6)。
有 n 个骰子，第 i 个骰子可以掷出 1 到 a[i] 中的任意整数。
掷出这 n 个骰子后，只告诉你所有骰子的数字之和为 s。
对于每个骰子，输出这个骰子不可能掷出的数字有多少个。

rating 1600
为方便计算，把 s 减去 n，把每个 a[i] 都减一，表示骰子掷出的数字从 0 开始。
第 i 个骰子至多可以掷出 mx=min(a[i], s)，至少可以掷出 mn=max(a[i]-(sum(a)-s), 0)，因为相比 sum(a)，少掷出了 sum(a)-s，这部分从 a[i] 中减掉就是第 i 个骰子能掷出的最小值。
所以第 i 个骰子无法掷出的数字个数 = 大于 mx 的数的个数 + 小于 mn 的数的个数 = (a[i]-mx) + mn。
https://codeforces.com/problemset/submission/534/232978698
======

input
2 8
4 4
output
3 3

input
1 3
5
output
4

input
2 3
2 3
output
0 1
 */
