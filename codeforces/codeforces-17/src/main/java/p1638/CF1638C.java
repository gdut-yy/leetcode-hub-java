package p1638;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1638C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[] p) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, p[i]);
            if (max == i + 1) {
                cnt++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
C. Inversion Graph
https://codeforces.com/contest/1638/problem/C

题目大意：
给出整数 n 和长度为 n 的序列 p。如果 i < j 且 p[i] > p[j] 时，i 和 j 可用连接，求数组 a 的联通分量大小。

从左到右枚举出到目前为止的最大值。如果等于其下标，则 cnt+=1
======

input
6
3
1 2 3
5
2 1 4 3 5
6
6 1 4 2 5 3
1
1
6
3 2 1 6 5 4
5
3 1 5 2 4

output
3
3
1
1
2
1
 */