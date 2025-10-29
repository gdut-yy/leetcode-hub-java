package c413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Abc413_g {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int h, w, k;

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static Map<Long, Long> parent;
    static Map<Long, Integer> size;

    static long find(long i) {
        if (!parent.containsKey(i)) {
            parent.put(i, i);
            size.put(i, 1);
        }
        while (i != parent.get(i)) {
            parent.put(i, parent.get(parent.get(i)));
            i = parent.get(i);
        }
        return i;
    }

    static void unite(long i, long j) {
        i = find(i);
        j = find(j);
        if (i == j) return;
        if (size.get(i) < size.get(j)) {
            long tmp = i;
            i = j;
            j = tmp;
        }
        size.merge(i, size.get(j), Integer::sum);
        parent.put(j, i);
    }

    static long coordinate_to_index(long x, long y) {
        if (x == 0 || y == w) return 0;
        if (y == 0 || x == h) return 1;
        return x * w + y;
    }

    // 1036
    private static void solve() {
        h = scanner.nextInt();
        w = scanner.nextInt();
        k = scanner.nextInt();

        parent = new HashMap<>();
        size = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x > 1) unite(coordinate_to_index(x - 1, y), coordinate_to_index(x - 1, y - 1));
            if (y > 1) unite(coordinate_to_index(x, y - 1), coordinate_to_index(x - 1, y - 1));
            if (x < h) unite(coordinate_to_index(x, y - 1), coordinate_to_index(x, y));
            if (y < w) unite(coordinate_to_index(x - 1, y), coordinate_to_index(x, y));
        }
        out.println((find(0) == find(1) ? "No" : "Yes"));
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
G - Big Banned Grid
https://atcoder.jp/contests/abc413/tasks/abc413_g

题目大意：
有一个 H * W 网格。让 (i,j) 表示从上往下第 i 行 (1<=i<=H) 和从左往上第 j 列 (1<=j<=W) 的单元格。
网格中的每个单元格要么有障碍物，要么什么都没有。有障碍物的单元格有 K 个：单元格 (r_1,c_1),(r_2,c_2),...,(r_K,c_K) 。
高桥最初位于 (1,1) 单元格，想要通过重复移动（上、下、左、右）到没有任何障碍物的相邻单元格，从而到达 (H,W) 单元格。
更确切地说，他可以任意重复下面的操作：
- 从以下四种操作中选择一种，并执行所选操作：
    - 如果 1 < i 和 (i-1,j) 单元格上没有放置任何内容，则移动到 (i-1,j) 单元格。否则不移动。
    - 如果 1 < j 和 (i,j-1) 单元格上没有放置任何内容，则移动到 (i,j-1) 单元格。否则不移动。
    - 如果 i < H 和 (i+1,j) 单元格上没有放置任何内容，则移动到 (i+1,j) 单元格。否则不移动。
    - 如果 j < W 和 (i,j+1) 单元格上没有放置任何内容，则移动到 (i,j+1) 单元格。否则不移动。
判断能否从 (1,1) 格移动到 (H,W) 格。

和 1036. 逃离大迷宫 类似，但是本题 k <= 2e5
https://atcoder.jp/contests/abc413/editorial/13403
======

Input 1
4 5 5
1 4
2 3
3 2
3 4
4 2
Output 1
No

Input 2
2 7 3
1 2
2 4
1 6
Output 2
Yes

Input 3
1 1 0
Output 3
Yes

Input 4
10 12 20
8 3
1 11
6 4
3 7
10 4
5 7
4 7
5 5
4 3
6 1
1 6
2 7
6 7
1 3
6 3
2 12
9 6
7 3
3 11
9 7
Output 4
Yes
 */
