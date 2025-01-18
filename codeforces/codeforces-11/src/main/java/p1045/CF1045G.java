package p1045;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1045G {
    static int n, k;
    static int[][] a; // x, r, iq
    static Map<Integer, List<Integer>> g;

    public static void main(String[] args) {
        // Time limit exceeded on test 21
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n][3];
        g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int r = scanner.nextInt();
            int iq = scanner.nextInt();
            a[i][0] = x;
            a[i][1] = r;
            a[i][2] = iq;
            g.computeIfAbsent(iq, e -> new ArrayList<>()).add(x);
        }
        System.out.println(solve());
    }

    static Map<Integer, int[]> tree;

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> -o[1]));

        tree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            int iq = entry.getKey();
            List<Integer> xs = entry.getValue();
            xs.sort(null);
            tree.put(iq, new int[xs.size() + 1]);
        }
        long ans = 0;
        for (int[] p : a) {
            for (int iq = p[2] - k; iq <= p[2] + k; iq++) {
                ans += pre(iq, p[0] + p[1] + 1) - pre(iq, p[0] - p[1]);
            }
            add(p[2], p[0]);
        }
        return String.valueOf(ans);
    }

    static void add(int iq, int i) {
        if (!tree.containsKey(iq)) return;
        int[] t = tree.get(iq);
        for (i = searchInts(g.get(iq), i) + 1; i < t.length; i += i & -i) {
            t[i]++;
        }
    }

    static long pre(int iq, int i) {
        if (!tree.containsKey(iq)) return 0;
        long res = 0;
        int[] t = tree.get(iq);
        for (i = searchInts(g.get(iq), i); i > 0; i &= i - 1) {
            res += t[i];
        }
        return res;
    }

    static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
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
G. AI robots
https://codeforces.com/contest/1045/problem/G

灵茶の试炼 2024-11-29
题目大意：
输入 n(1≤n≤1e5) k(0≤k≤20) 和 n 个机器人的属性。
每个机器人都有三个属性：x r q，值都在 [0,1e9] 中。
x 表示机器人在一维数轴上的位置，q 表示机器人的智商。
机器人可以与位置在 [x-r,x+r] 中的，智商在 [q-k,q+k] 中的其他机器人交流。
能够【互相】交流的机器人有多少对？

rating 2200
按照 r 从大到小排序+遍历，若机器人 A 能看到前面遍历过的机器人 B，那么 B 必然也能看到 A。
把 (q,x) 当作二维坐标上的点，问题变成矩形区域 [q-k,q+k] × [x-r,x+r] 的二维数点问题。
本题由于 k 比较小，每个智商用一个树状数组维护，暴力枚举 [q-k,q+k] 内的智商。
需要离散化。
代码 https://codeforces.com/contest/1045/submission/293581356
代码备份（洛谷）
======

Input
3 2
3 6 1
7 3 10
10 5 8
Output
1

Input
10 5
41 436 1
478 604 2
169 153 2
358 382 1
334 716 8
500 895 7
724 726 1
464 538 9
962 912 7
467 299 5
Answer
19
 */
