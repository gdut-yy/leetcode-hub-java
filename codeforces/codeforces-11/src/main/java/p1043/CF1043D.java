package p1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1043D {
    static int m, n;
    static int[][] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 9
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] pos = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = a[i][j];
                pos[i][v] = j;
            }
        }

        long ans = 0, c = 0;
        int[] ps = new int[m];
        ps[0] = -2;
        for (int j = 0; j < a[0].length; j++) {
            int v = a[0][j];
            for (int i = 0; i < pos.length; i++) {
                int[] p = pos[i];

                ps[i]++;
                if (ps[i] != p[v]) {
                    for (int i0 = 0; i0 < pos.length; i0++) {
                        int[] p0 = pos[i0];
                        ps[i0] = p0[v];
                    }
                    c = 0;
                    break;
                }
            }
            c++;
            ans += c;
        }
        return String.valueOf(ans);
    }

    private static class FastReader {
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
D. Mysterious Crime
https://codeforces.com/contest/1043/problem/D

灵茶の试炼 2022-08-02
题目大意：
输入 n(≤1e5) 和 m(≤10)，然后输入 m 个长为 n 的排列，元素范围均在 [1,n]。
输出有多少个不同的非空子数组，是每个排列都有的。
注：子数组是连续的。

rating 1700
https://codeforces.com/contest/1043/submission/166640293
62ms 快读 https://codeforces.com/contest/1043/submission/166640185
对第 i 个排列，记录第 j 个元素 v 的下标 pos[i][v] = j。
然后遍历第一个排列，看它的子数组是否出现在所有排列中。
具体做法是，每次向右扩展一个元素 a[0][j]，看 pos[i][a[0][j]] 是否等于 pos[i][a[0][j-1]]+1
这样可以得到右端点为 j 的子数组的最长长度，从而得到子数组的个数。
======

input
3 2
1 2 3
2 3 1
output
4

input
5 6
1 2 3 4 5
2 3 1 4 5
3 4 5 1 2
3 5 4 2 1
2 3 5 4 1
1 2 3 4 5
output
5

input
2 2
1 2
2 1
output
2
 */