package p1807;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1807D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[][] lrk = new int[q][3];
            for (int i = 0; i < q; i++) {
                lrk[i][0] = scanner.nextInt();
                lrk[i][1] = scanner.nextInt();
                lrk[i][2] = scanner.nextInt();
            }
            System.out.println(solve(n, q, a, lrk));
        }
    }

    private static String solve(int n, int q, int[] a, int[][] lrk) {
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (a[i] & 1);
        }

        String[] res = new String[q];
        for (int i = 0; i < q; i++) {
            int l = lrk[i][0] - 1, r = lrk[i][1] - 1, k = lrk[i][2] & 1;
            int sum = preSum[n] - (preSum[r + 1] - preSum[l]) + (r - l + 1) * k;
            res[i] = (sum & 1) == 1 ? "YES" : "NO";
        }
        return String.join(System.lineSeparator(), res);
    }
}
/*
D. Odd Queries
https://codeforces.com/contest/1807/problem/D

题目大意：
你有一个数组 a1,a2,...,an。回答以下形式的 q 个问题:
如果我们把数组中 al,al+1,...,ar 范围内的所有元素都换成 k，整个数组的和会是奇数吗?
注意，查询是独立的，不会影响将来的查询。

前缀和，奇数和偶数可以压缩成等价的 0 和 1。
======

input
2
5 5
2 2 1 3 2
2 3 3
2 3 4
1 5 5
1 4 9
2 4 3
10 5
1 1 1 1 1 1 1 1 1 1
3 8 13
2 5 10
3 8 10
1 10 2
1 9 100
output
YES
YES
YES
NO
YES
NO
NO
NO
NO
YES
 */
