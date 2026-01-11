package p1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1766D {
    // Time limit exceeded on test 3
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = (int) 1e7;
    static int[] lpf = new int[mx];

    static {
        for (int i = 2; i < mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j < mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }
    }

    private static void solve() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        y -= x;
        if (y == 1) {
            out.println("-1");
            return;
        }
        int mn = y;
        while (y > 1) {
            int p = lpf[y];
            while (y % p == 0) {
                y /= p;
            }
            if (x % p == 0) {
                mn = 0;
                break;
            }
            mn = Math.min(mn, p - x % p);
        }
        out.println(mn);
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
D. Lucky Chains
https://codeforces.com/contest/1766/problem/D

灵茶の试炼 2025-10-08
题目大意：
输入 T(≤1e6) 表示 T 组数据。
每组数据输入 x y(1≤x<y≤1e7)。
输出如下连续互质序列的最长长度。
(x,y), (x+1,y+1), (x+2,y+2), ..., (x+k,y+k)
其中每一对元素都是互质的。
如果 (x,y) 不互质，输出 0。
如果序列无限长，输出 -1。

rating 1600
由于 gcd(x,y) = gcd(x,y-x)，
所以 gcd(x+k,y+k) = gcd(x+k,y-x)。
如果 y-x = 1，那么 gcd(x+k,y-x) 恒为 1，输出 -1。
否则，当且仅当 x+k 是 y-x 的某个质因子 p 的倍数时，gcd(x+k,y-x) > 1。
我们需要算出 x 到 >= x 的 p 的倍数的最小距离，即 k=(p-x%p)%p，更新答案的最小值。
预处理 LPF（最小质因子），可以快速分解 y-x。
代码 https://codeforces.com/problemset/submission/1766/341638950
代码备份（上面打不开的同学看这个）
======

Input
4
5 15
13 37
8 9
10009 20000
Output
0
1
-1
79
 */
