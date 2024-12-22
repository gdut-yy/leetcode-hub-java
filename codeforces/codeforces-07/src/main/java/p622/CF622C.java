package p622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF622C {
    // Time limit exceeded on test 20
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, m;
    static int[][] a; // v, l

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            a[i][0] = scanner.nextInt();
            if (a[i][0] != a[i - 1][0]) {
                a[i][1] = i - 1;
            } else {
                a[i][1] = a[i - 1][1];
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int v = scanner.nextInt();
            if (v != a[r][0]) {
                ans[i] = r;
            } else if (l <= a[r][1]) {
                ans[i] = a[r][1];
            } else {
                ans[i] = -1;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
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
C. Not Equal on a Segment
https://codeforces.com/contest/622/problem/C

灵茶の试炼 2024-08-28
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
然后输入 m 个询问，每个询问输入三个数 L R x(1≤x≤1e6)。
下标从 1 开始。
对于每个询问，输出任意 i，满足 i 在闭区间 [L,R] 内且 a[i] ≠ x。
如果不存在这样的 i，输出 -1。

rating 1700
对于每个 a[i]，记录其左侧最近的不等于 a[i] 的数的下标 left[i]：
如果 a[i] != a[i-1]，那么 left[i] = i-1。
如果 a[i] = a[i-1]，那么 left[i] = left[i-1]。
回答询问：
如果 a[r] != x，那么输出 r。
如果 left[r] >= l，那么输出 left[r]。
否则输出 -1。
代码 https://codeforces.com/contest/622/submission/277847281
======

Input
6 4
1 2 1 1 3 5
1 4 1
2 6 2
3 4 1
3 4 2
Output
2
6
-1
4
 */