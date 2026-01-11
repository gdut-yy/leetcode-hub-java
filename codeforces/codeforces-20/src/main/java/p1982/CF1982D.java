package p1982;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1982D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        long d = 0;
        long[][] sum = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                int c = (s.charAt(j) % 2 * 2) - 1;
                d += a[i][j] * c;
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + c;
            }
        }

        long g = 0;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                g = getGCD(g, query(sum, i - k, j - k, i, j));
            }
        }

        if (d == 0 || (g != 0 && d % g == 0)) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }

    private static long query(long[][] sum, int r1, int c1, int r2, int c2) {
        return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Beauty of the mountains
https://codeforces.com/contest/1982/problem/D

灵茶の试炼 2025-10-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤2.5e5。
每组数据输入 n m(1≤n,m≤500) k(1≤k≤min(n,m))
然后输入 n 行 m 列的矩阵 a，元素范围 [0,1e9]。
然后输入 n 行 m 列的 0-1 矩阵，表示 a 中每个元素的类型是 0 还是 1。
每次操作，你可以选择 a 的一个 k*k 的子矩阵，把其中所有元素增加任意整数（可以是负数）。
能否让所有类型 0 的元素之和等于所有类型 1 的元素之和？
输出 YES 或 NO。

rating 1700
转化成两种类型的元素和之差 d，目标是让 d 变成 0。
每次操作相当于把差值增加或者减少 x_ij 的倍数，其中 x_ij 是 k*k 区域中的两种类型的元素个数之差，这可以用二维前缀和计算。
问题相当于给你 (n-k+1)*(m-k+1) 个 x_ij，用这些 x_ij 的倍数凑出 d。
根据裴蜀定理，只要这些 x_ij 的 GCD 是 d 的因子即可。
特判 d = 0 以及 GCD = 0 的情况，前者一定行，后者如果 d ≠ 0 就不行。
代码 https://codeforces.com/contest/1982/submission/339828755
代码备份（上面打不开的同学看这个）
======

Input
8
3 3 2
7 11 3
4 2 3
0 1 15
100
010
000
4 4 3
123 413 24 233
123 42 0 216
22 1 1 53
427 763 22 6
0101
1111
1010
0101
3 3 2
2 1 1
1 1 2
1 5 4
010
101
010
3 3 2
2 1 1
1 1 2
1 5 3
010
101
010
3 4 3
46 49 50 1
19 30 23 12
30 25 1 46
1000
0100
0010
5 4 4
39 30 0 17
22 42 30 13
10 44 46 35
12 19 9 39
21 0 45 40
1000
1111
0011
0111
1100
2 2 2
3 4
6 7
00
00
2 2 2
0 0
2 0
01
00
Output
YES
NO
YES
NO
YES
NO
YES
YES
 */
