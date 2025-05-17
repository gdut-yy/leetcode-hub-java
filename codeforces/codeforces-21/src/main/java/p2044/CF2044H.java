package p2044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2044H {
    // Time limit exceeded on test 2
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, q;
    static long[][][] s;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            s = new long[n + 1][n + 1][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long v = scanner.nextInt();
                    s[i + 1][j + 1][0] = s[i + 1][j][0] + s[i][j + 1][0] - s[i][j][0] + v;
                    s[i + 1][j + 1][1] = s[i + 1][j][1] + s[i][j + 1][1] - s[i][j][1] + v * i;
                    s[i + 1][j + 1][2] = s[i + 1][j][2] + s[i][j + 1][2] - s[i][j][2] + v * (j + 1);
                }
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        for (int i = 0; i < q; i++) {
            int r1 = scanner.nextInt() - 1;
            int c1 = scanner.nextInt() - 1;
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();

            long s0 = query(r1, c1, r2, c2, 0);
            long s1 = query(r1, c1, r2, c2, 1);
            long s2 = query(r1, c1, r2, c2, 2);
            long res = (c2 - c1) * (s1 - r1 * s0) + s2 - c1 * s0;
            out.print(res);
            out.print(" ");
        }
        out.println();
    }

    static long query(int r1, int c1, int r2, int c2, int t) {
        return s[r2][c2][t] - s[r2][c1][t] - s[r1][c2][t] + s[r1][c1][t];
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
H. Hard Demon Problem
https://codeforces.com/contest/2044/problem/H

灵茶の试炼 2025-01-02
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2000。
每组数据输入 n(1≤n≤2000) q(1≤q≤1e6) 和 n 行 n 列的矩阵 a(1≤a[i][j]≤1e6)。
然后输入 q 个询问，每个询问输入四个数 r1 c1 r2 c2，表示子矩阵左上角的行列编号、右下角的行列编号。编号从 1 开始。
把子矩形展开成一维数组 A，也就是子矩阵的第一行 + 第二行 + 第三行 + ... 拼起来。A 的下标从 1 开始。
输出 1 * A[1] + 2 * A[2] + 3 * A[3] + ... + k * A[k]，其中 k 是数组 A 的长度。
注：由于数据量大，使用快读可以显著减少运行时间。

rating 2100
推荐先看 https://www.bilibili.com/video/BV1hQ4y1L7Tk/
设子矩形的宽为 w。
那么子矩形展开成一维数组后，子矩形的第 i 行第 j 列（i 和 j 从 0 开始）的元素在一维数组中的下标为 i*w+j。
于是，题目要计算的式子变形为
  ∑(i*w+j+1)*a[x][y]
= ∑i*w*a[x][y] + ∑(j+1)*a[x][y]
= w*∑i*a[x][y] + ∑(j+1)*a[x][y]
其中 x-i = 定值，y-j = 定值。
所以原问题变成计算 ∑i*a[x][y] 和 ∑(j+1)*a[x][y]，也就是矩阵的带权二维前缀和。
我们可以先把 ∑a[i][j]、∑i*a[i][j] 和 ∑(j+1)*a[i][j] 计算出来，
这样对于 ∑i*a[x][y] 来说，相当于 ∑i*a[i][j] 中的每个数的权值都减少了 x-i，
所以 ∑i*a[x][y] 可以用 ∑i*a[i][j] 和 ∑a[i][j] 表示。
对于 ∑(j+1)*a[x][y] 同理。
注意用 64 位整数。
代码 https://codeforces.com/problemset/submission/2044/298912565
代码备份（洛谷）
======

Input
2
4 3
1 5 2 4
4 9 5 3
4 5 2 3
1 5 5 2
1 1 4 4
2 2 3 3
1 2 4 3
3 3
1 2 3
4 5 6
7 8 9
1 1 1 3
1 3 3 3
2 2 2 2
Output
500 42 168
14 42 5
 */