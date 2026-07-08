package p1083;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF1083E {
    // Time limit exceeded on test 4
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    // 1. Math.multiplyHigh 替代 BigInteger - 零分配，纯内联实现 128 位比较
    // 2. 使用扁平数组 xs[]/ys[]/as[] 替代 int[][] - 避免对 100 万条记录进行逐行对象分配
    // 3. 压缩排序键（long 类型，高 32 位存放 x，低 32 位存放索引）- 单数组排序，无需比较器装箱
    // 4. 1MB IO 缓冲区 - 处理大输入时减少系统调用次数
    private static void solve() {
        int n = scanner.nextInt();
        long[] xs = new long[n];
        long[] ys = new long[n];
        long[] as = new long[n];
        long[] sortKey = new long[n];
        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextLong();
            ys[i] = scanner.nextLong();
            as[i] = scanner.nextLong();
            sortKey[i] = (xs[i] << 32) | i;
        }
        Arrays.sort(sortKey);
        long ans = 0;
        long[] qx = new long[n + 1];
        long[] qy = new long[n + 1];
        int head = 0, tail = 1;
        for (int ii = 0; ii < n; ii++) {
            int i = (int) (sortKey[ii] & 0xFFFFFFFFL);
            long px = -ys[i];
            while (tail - head > 1 && qx[head] * px + qy[head] <= qx[head + 1] * px + qy[head + 1]) {
                head++;
            }
            long f = qx[head] * px + qy[head] + xs[i] * ys[i] - as[i];
            if (f > ans) ans = f;
            long vx = xs[i], vy = f;
            while (tail - head > 1) {
                long ax = qx[tail - 1] - qx[tail - 2];
                long ay = qy[tail - 1] - qy[tail - 2];
                long bx = vx - qx[tail - 1];
                long by = vy - qy[tail - 1];
                long h1 = Math.multiplyHigh(ax, by);
                long h2 = Math.multiplyHigh(ay, bx);
                if (h1 < h2 || (h1 == h2 && Long.compareUnsigned(ax * by, ay * bx) < 0)) break;
                tail--;
            }
            qx[tail] = vx;
            qy[tail] = vy;
            tail++;
        }
        out.println(ans);
    }

    static class TLE {
        record vec(long x, long y) {
            vec sub(vec b) {
                return new vec(x - b.x, y - b.y);
            }

            long dot(vec b) {
                return x * b.x + y * b.y;
            }

            long det(vec b) {
                return x * b.y - y * b.x;
            }
        }

        private static void solve() {
            int n = scanner.nextInt();
            long[][] a = new long[n][3];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextLong();
                a[i][1] = scanner.nextLong();
                a[i][2] = scanner.nextLong();
            }
            Arrays.sort(a, Comparator.comparingLong(p -> p[0]));
            long ans = 0;
            vec[] q = new vec[n + 1];
            int head = 0, tail = 1;
            q[0] = new vec(0, 0);
            for (int i = 0; i < n; i++) {
                long tx = a[i][0], ty = a[i][1], ta = a[i][2];
                vec pi = new vec(-ty, 1);
                while (tail - head > 1 && pi.dot(q[head]) <= pi.dot(q[head + 1])) {
                    head++;
                }
                long f = pi.dot(q[head]) + tx * ty - ta;
                ans = Math.max(ans, f);
                vec vj = new vec(tx, f);
                while (tail - head > 1 && q[tail - 1].sub(q[tail - 2]).det(vj.sub(q[tail - 1])) >= 0) {
                    tail--;
                }
                q[tail++] = vj;
            }
            out.println(ans);
        }
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
E. The Fair Nut and Rectangles
https://codeforces.com/contest/1083/problem/E

灵茶の试炼 2026-02-06
题目大意：
输入 n(1≤n≤1e6) 和 n 个矩形。
每个矩形输入三个数 x y(1≤x,y≤1e9) a(1≤a≤x*y)，
表示一个左下角为 (0,0)，右上角为 (x,y) 的矩形，其代价为 a。
保证不存在嵌套的矩形。
从中选择若干矩形，你需要最大化：矩形并集的面积 - 矩形代价之和。

rating 2400
把矩形按照 x 排序。
由于题目保证不存在嵌套的矩形，所以排序后，矩形的 y 严格递减。
考虑子序列 DP + 枚举选哪个。
定义 f[i] 表示以第 i 个矩形结尾的子序列，对应的最大得分。
枚举上一个矩形是第 j 个，那么问题变成以第 i 个矩形结尾的子序列，对应的最大得分，
再加上第 i 个矩形新增的面积，即 (x[i] - x[j]) * y[i]，再减去 a[i]。
取最大值，得
f[i] = max_{j=0}^{i-1} f[j] + (x[i] - x[j]) * y[i] - a[i]
     = x[i]*y[i] - a[i] + max_{j=0}^{i-1} -y[i] * x[j] + 1 * f[j]
问题变成计算向量 (-y[i], 1) 与一堆向量 (x[j], f[j]) 中的某个向量的点积的最大值。
原理见 我的题解（补充了一张图方便大家理解）。注意这里求的是最大值，要用上凸包。
初始值 f[0] = 0，想象在坐标原点处有一个面积为 0，代价为 0 的矩形。
答案为 max(f)。
推荐使用快读。
代码 https://codeforces.com/problemset/submission/1083/315798097
代码备份（上面打不开的同学看这个）
======

Input
3
4 4 8
1 5 0
5 2 10
Output
9

Input
4
6 2 4
1 6 2
2 4 3
5 3 8
Output
10
 */
