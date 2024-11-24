package p1270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1270G {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 8
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        List<String> output = new ArrayList<>(t);
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            output.add(solve());
        }
        System.out.println(String.join(System.lineSeparator(), output));
    }

    private static String solve() {
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            g[i] = i - v;
        }
        int x = 1;
        for (; g[x] > 0; x = -g[x]) {
            g[x] = -g[x];
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(x);
        int st = x;
        for (x = -g[x]; x != st; x = -g[x]) {
            ans.add(x);
        }
        return ans.size() + System.lineSeparator() + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
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
G. Subset with Zero Sum
https://codeforces.com/contest/1270/problem/G

灵茶の试炼 2024-01-05
题目大意：
输入 T(≤1e6) 表示 T 组数据。所有数据的 n 之和 ≤1e6。
每组数据输入 n(1≤n≤1e6) 和长为 n 的数组 a(i-n≤a[i]≤i-1)，下标从 1 开始。
求 a 的一个非空子集，满足子集元素和恰好等于 0。
输出子集的大小，以及子集元素在 a 中的下标。
多解输出任意解，下标的顺序不重要。
允许子集有重复元素。

rating 2700
提示 1
注意 a[i] 的范围，为什么如此奇怪？
提示 2
变形得到 1<=i-a[i]<=n。
提示 3
从 i 向 i-a[i] 连边，得到内向基环树森林。
提示 4
任意一个环就是答案。
证明：
对于一个环上的所有边 x[i] -> y[i]，我们有 ∑x[i] = ∑y[i]。
例如环 1->2->3->1，我们有 1+2+3 = 2+3+1。
对于本题建的图来说就是 ∑i = ∑(i-a[i])
由于右边 = ∑i - ∑a[i]，所以得到
∑i = ∑i - ∑a[i]
化简得
∑a[i] = 0
https://codeforces.com/contest/1270/submission/239941368
======

input
2
5
0 1 2 3 4
4
-3 1 1 1
output
1
1
4
1 4 3 2
 */
