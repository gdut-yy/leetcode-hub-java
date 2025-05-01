package p276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF276C {
    // Time limit exceeded on test 7
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        int[] diff = new int[n + 1];
        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            diff[l - 1]++;
            diff[r]--;
        }
        for (int i = 0; i < n - 1; i++) {
            diff[i + 1] += diff[i];
        }
        Arrays.sort(diff, 0, n);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) a[i] * diff[i];
        }
        return String.valueOf(ans);
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
C. Little Girl and Maximum Sum
https://codeforces.com/contest/276/problem/C

灵茶の试炼 2024-12-10
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。下标从 1 开始。
然后输入 q 个询问，每个询问输入两个数 L 和 R，表示计算下标从 L 到 R 的连续子数组的元素和 (1≤L≤R≤n)。
在计算之前，你可以重排 a 中的元素。
输出所有询问结果总和的最大值。

rating 1500
差分数组计算出每个下标给答案贡献了多少次。
然后根据排序不等式，把小的数与贡献次数小的位置匹配。
也就是把 a 和差分数组的前缀和都从小到大排序，然后计算点积，即为答案。
代码 https://codeforces.com/problemset/submission/276/295813034
代码备份（洛谷）
======

Input
3 3
5 3 2
1 2
2 3
1 3
Output
25

Input
5 3
5 2 4 1 3
1 5
2 3
2 3
Output
33
 */
