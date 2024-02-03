package p1921;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1921F {
    static int n, q;
    static long[] a;
    static int[][] sdk;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            sdk = new int[q][3];
            for (int i = 0; i < q; i++) {
                sdk[i][0] = scanner.nextInt();
                sdk[i][1] = scanner.nextInt();
                sdk[i][2] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static final int MAX_N = (int) 1e5;
    static final int B = 300; // sqrt(MAX_N)
    static long[][] pre = new long[B][MAX_N + B], sum = new long[B][MAX_N + B];

    private static String solve() {
        for (int d = 1; d < B; d++) {
            for (int i = 0; i < n; i++) {
                pre[d][i + d] = pre[d][i] + a[i];
                sum[d][i + d] = sum[d][i] + a[i] * (i / d + 1);
            }
        }

        long[] ans = new long[q];
        for (int qi = 0; qi < q; qi++) {
            int s = sdk[qi][0] - 1, d = sdk[qi][1], k = sdk[qi][2];
            if (d < B) {
                int r = s + d * k;
                ans[qi] = sum[d][r] - sum[d][s] - (pre[d][r] - pre[d][s]) * (s / d);
            } else {
                for (int i = 0; i < k; i++) {
                    ans[qi] += a[s + d * i] * (i + 1);
                }
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
F. Sum of Progression
https://codeforces.com/contest/1921/problem/F

题目大意：
给你一个 n 个数的数组 a。还有 q 个像 s d k 这样的查询。
对于每个查询 q，找出 a[s] + a[s+d]*2 + ... + a[s+d*(k−1)]*k 的元素之和。换句话说，对于每个查询，都需要找到索引从第 s -th 开始的数组中 k 个元素的和，采取大小为 d 的步骤，将其乘以结果序列中元素的序列号。

带权前缀和+根号算法【Codeforces 920 (Div. 3) F】
https://www.bilibili.com/video/BV1hQ4y1L7Tk/
https://codeforces.com/contest/1921/submission/241870966
======

input
5
3 3
1 1 2
1 2 2
2 2 1
1 1 2
3 1
-100000000 -100000000 -100000000
1 1 3
5 3
1 2 3 4 5
1 2 3
2 3 2
1 1 5
3 1
100000000 100000000 100000000
1 1 3
7 7
34 87 5 42 -44 66 -32
2 2 2
4 3 1
1 3 2
6 2 1
5 2 2
2 5 2
6 1 2
output
5 1 3
-600000000
22 12 55
600000000
171 42 118 66 -108 23 2
 */
