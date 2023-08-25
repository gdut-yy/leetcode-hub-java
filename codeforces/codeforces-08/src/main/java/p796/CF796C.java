package p796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CF796C {
    static int n;
    static int[] a;
    static Map<Integer, List<Integer>> g;

    public static void main(String[] args) {
        // Time limit exceeded on test 8
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            g.computeIfAbsent(w, key -> new ArrayList<>()).add(v);
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = (int) 2e9;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : a) {
            maxHeap.add(v);
        }

        Map<Integer, Integer> lazy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> nb = g.getOrDefault(i, new ArrayList<>());

            int mx = a[i];
            lazy.put(mx, lazy.getOrDefault(mx, 0) + 1);
            for (Integer v : nb) {
                mx = Math.max(mx, a[v] + 1);
                lazy.put(a[v], lazy.getOrDefault(a[v], 0) + 1);
            }
            while (!maxHeap.isEmpty() && lazy.getOrDefault(maxHeap.peek(), 0) > 0) {
                lazy.put(maxHeap.peek(), lazy.getOrDefault(maxHeap.peek(), 0) - 1);
                maxHeap.remove();
            }
            if (!maxHeap.isEmpty()) {
                mx = Math.max(mx, maxHeap.peek() + 2);
            }
            ans = Math.min(ans, mx);
            maxHeap.add(a[i]);
            for (Integer v : nb) {
                maxHeap.add(a[v]);
            }
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
C. Bank Hacking
https://codeforces.com/contest/796/problem/C

灵茶の试炼 2023-07-27
题目大意：
输入 n(1≤n≤3e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9) 表示树上每个点的点权，然后输入这棵树的 n-1 条边（节点编号从 1 开始）。
执行如下操作恰好一次：
选一个点作为根节点，根节点的点权不变，它的儿子的点权增加 1，其余点的点权增加 2。
最小化这棵树的最大点权，并输出。

https://codeforces.com/problemset/submission/796/215802020
做法不止一种，这里说说最简单的用平衡树/最大堆的模拟做法。
先把所有 a[i] 加入集合（平衡树/最大堆），然后从 1 开始枚举 i，以及 i 的邻居（点权要加 1），从集合中去掉这些点的点权后，集合中的最大值就是「其余点」的点权最大值了（点权要加 2），统计完最大值后，再把 i 和 i 的邻居的点权重新加回来。
每次枚举计算出的最大值，再取最小值，就是答案。
用最大堆实现的话可以用 lazy 删除，具体见下面代码。
======

input
5
1 2 3 4 5
1 2
2 3
3 4
4 5
output
5

input
7
38 -29 87 93 39 28 -55
1 2
2 5
3 2
2 4
1 7
7 6
output
93

input
5
1 2 7 6 7
1 5
5 3
3 4
2 4
output
8
 */
