package p1547;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1547E {
    static int n, k;
    static int[] a, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = scanner.nextInt();
            }
            t = new int[k];
            for (int i = 0; i < k; i++) {
                t[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] f = new long[n];
        Arrays.fill(f, INF);
        for (int j = 0; j < k; j++) {
            int i = a[j];
            f[i - 1] = t[j];
        }
        for (int i = n - 2; i >= 0; i--) {
            f[i] = Math.min(f[i], f[i + 1] + 1);
        }

        long mn = INF;
        for (int i = 0; i < n; i++) {
            mn = Math.min(f[i], mn + 1);
            f[i] = mn;
        }
        return Arrays.stream(f).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. Air Conditioners
https://codeforces.com/contest/1547/problem/E

灵茶の试炼 2024-03-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n k (1≤k≤n≤3e5)，长为 k 的数组 a(1≤a[i]≤n)，长为 k 的数组 t(1≤t[i]≤1e9)。
数轴上有 k 个正在制冷的空调，第 i 个空调的位置是 a[i]，温度为 t[i]。
位置 j 的温度会受到空调 i 的影响，离空调越远，温度越高，具体温度为 t[i] + |a[i] - j|。
如果位置 j 被多个空调影响，取温度最小值。
输出 1~n 每个位置的温度。

rating 1500
设 f[i] 是位置 i 的温度。如果 i 位置有空调，那么初始化 f[i] 为对应温度，否则 f[i]=inf。
考虑 i 左侧空调的影响。
如果我们知道了 f[i-1] 的温度，那么 f[i] 的温度就是 min(f[i], f[i-1]+1)。
这可以从左到右递推算出。
对于 i 右侧空调也一样，有 f[i] = min(f[i],f[i+1]+1)，从右到左递推算出。
https://codeforces.com/contest/1547/submission/250445406
======

Input
5

6 2
2 5
14 16

10 1
7
30

5 5
3 1 4 2 5
3 1 4 2 5

7 1
1
1000000000

6 3
6 1 3
5 5 5
Output
15 14 15 16 16 17
36 35 34 33 32 31 30 31 32 33
1 2 3 4 5
1000000000 1000000001 1000000002 1000000003 1000000004 1000000005 1000000006
5 6 5 6 6 5
 */
