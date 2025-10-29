package c423;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc423_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] pre0 = new long[n + 1];
        long[] pre1 = new long[n + 1];
        long[] pre2 = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            pre0[i] = pre0[i - 1] + a[i];
            pre1[i] = pre1[i - 1] + a[i] * i;
            pre2[i] = pre2[i - 1] + a[i] * i * i;
        }

        while (q-- > 0) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            long S0 = pre0[R] - pre0[L - 1];
            long S1 = pre1[R] - pre1[L - 1];
            long S2 = pre2[R] - pre2[L - 1];

            long ans = -S2 + (L + R) * S1 + (R + 1L) * (1 - L) * S0;
            out.println(ans);
        }
    }
}
/*
E - Sum of Subarrays
https://atcoder.jp/contests/abc423/tasks/abc423_e

题目大意：
给你一个长度为 N(3e5) 的整数序列 A = (A1, A2, ..., AN)。Ai<=100
给出了 Q(3e5) 个查询，请找出每个查询的答案。
在 i-th 查询中，给出了整数 Li 和 Ri ，请找出 $\sum_{l = L_i}^{R_i}\sum_{r = l}^{R_i}\sum_{j = l}^{r} A_j$ 作为答案。

前缀和 + 数学。
https://chat.deepseek.com/a/chat/s/d49ddb21-9d12-4a18-8e7c-033143272786
======

Input 1
5 4
2 1 3 3 1
2 4
1 4
1 5
3 3
Output 1
24
44
74
3
 */
