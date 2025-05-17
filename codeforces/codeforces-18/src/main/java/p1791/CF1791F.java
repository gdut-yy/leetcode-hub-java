package p1791;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1791F {
    // Time limit exceeded on test 4
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.close();
    }

    private static void solve() {
//        List<String> output = new ArrayList<>(q);
        DSU dsu = new DSU(n + 1);
        for (int qi = 0; qi < q; qi++) {
            int op = scanner.nextInt();
            int l = scanner.nextInt() - 1;
            if (op == 2) {
                out.println(a[l]);
//                output.add(String.valueOf(a[l]));
                continue;
            }
            int r = scanner.nextInt();
            for (int i = dsu.find(l); i < r; i = dsu.find(i + 1)) {
                int s = 0;
                for (int v = a[i]; v > 0; v /= 10) {
                    s += v % 10;
                }
                a[i] = s;
                if (s < 10) {
                    dsu.fa[i] = i + 1;
                }
            }
        }
//        return String.join("\n", output);
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
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
F. Range Update Point Query
https://codeforces.com/contest/1791/problem/F

灵茶の试炼 2025-04-08
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n q(1≤n,q≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。下标从 1 开始。
然后输入 q 个询问，格式如下：
"1 l r"：把下标在 [l,r] 中的数都更新成其数位和，例如 a[i]=420，更新成 a[i]=4+2+0=6。
"2 x"：输出 a[x]。

rating 1500
注意到，一个数一旦小于 10，就不会再变化。
我们可以维护 >= 10 的数的下标集合 idx。一旦一个数小于 10，就删掉。
和上场周赛第四题一样，这可以用并查集、有序集合或者线段树维护。（如果本题有区间询问，最合适的数据结构就是线段树了，仍然是暴力更新和维护区间，如果区间 max < 10 就不更新）
然后就是暴力了。
为什么？因为一个数 x 更新为其数位和后，会变成 9log(x)，那么操作 O(log* x) 次，就能变成一个小于 10 的数。其中 log* 指「迭代对数」。
注：并查集的做法是，如果要删除 i，那么把 i 和 i+1 合并即可（i 指向 i+1）。通过 find(i) 就能找到 >= i 的最小的没被删除的下标。
代码 https://codeforces.com/problemset/submission/1791/314371151
代码备份（洛谷）
======

Input
3
5 8
1 420 69 1434 2023
1 2 3
2 2
2 3
2 4
1 2 5
2 1
2 3
2 5
2 3
9999 1000
1 1 2
2 1
2 2
1 1
1
2 1
Output
6
15
1434
1
6
7
36
1
1
 */
