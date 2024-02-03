package p292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF292E {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        // Time limit exceeded on test 17
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 1, n);
        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            if (op == 1) {
                int y = scanner.nextInt();
                int k = scanner.nextInt();
                seg.update(1, y, y + k - 1, x - y);
            } else {
                int d = seg.query(1, x);
                if (d == INF) {
                    System.out.println(b[x]);
                } else {
                    System.out.println(a[x + d]);
                }
            }
        }
    }

    static final int INF = (int) 1e9;

    static class SegmentTree {
        int n;
        int[] tree_l, tree_r, tree_d;

        public SegmentTree(int n) {
            this.n = n;
            this.tree_l = new int[4 * n];
            this.tree_r = new int[4 * n];
            this.tree_d = new int[4 * n];
        }

        void build(int p, int l, int r) {
            tree_l[p] = l;
            tree_r[p] = r;
            tree_d[p] = INF;
            if (l == r) {
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
        }

        void update(int p, int l, int r, int d) {
            if (l <= tree_l[p] && tree_r[p] <= r) {
                tree_d[p] = d;
                return;
            }
            if (tree_d[p] != INF) {
                tree_d[p << 1] = tree_d[p];
                tree_d[p << 1 | 1] = tree_d[p];
                tree_d[p] = INF;
            }
            int mid = (tree_l[p] + tree_r[p]) >> 1;
            if (l <= mid) update(p << 1, l, r, d);
            if (r > mid) update(p << 1 | 1, l, r, d);
        }

        int query(int p, int i) {
            if (tree_d[p] != INF || tree_l[p] == tree_r[p]) {
                return tree_d[p];
            }
            int mid = (tree_l[p] + tree_r[p]) >> 1;
            if (i <= mid) return query(p << 1, i);
            return query(p << 1 | 1, i);
        }
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
E. Copying Data
https://codeforces.com/contest/292/problem/E

灵茶の试炼 2022-09-28
题目大意：
输入 n(≤1e5) 和 m (≤1e5)，两个长度都为 n 的数组 a 和 b（元素范围在 [-1e9,1e9] 内，下标从 1 开始）。
然后输入 m 个操作：
操作 1 形如 1 x y k，表示把 a 的区间 [x,x+k-1] 的元素拷贝到 b 的区间 [y,y+k-1] 上（输入保证下标不越界）。
操作 2 形如 2 x，输出 b[x]。
思考题：双向 copy 怎么做？  @Hush@Aging

rating 1900
https://codeforces.com/contest/292/submission/173659179
https://codeforces.com/contest/292/submission/173666674
提示 1：操作 1 可以转换为，把区间 [y,y+k-1] 上都打一个「偏移量」标记 x-y。设位置 i 的标记为 delta[i]，那么在输出 b[x] 的时候，输出 a[x+delta[x]] 即可。
提示 2：转换成一个区间赋值，单点查询问题。
提示 3：这可以用线段树或珂朵莉树解决。
由于操作的特殊性，线段树只需要一个 tag 数组。
注：本题还可以用 splay 模拟。
双向操作大概要一个支持可持久化+分裂合并的数据结构。
======

input
5 10
1 2 0 -1 3
3 1 5 -2 0
2 5
1 3 3 3
2 5
2 4
2 1
1 2 1 4
2 1
2 4
1 4 2 1
2 2
output
0
3
-1
3
2
3
-1

20 30
5 6 -6 10 10 -6 10 7 0 -10 3 1 -7 -9 1 -7 5 1 -1 1
8 10 -10 -1 -9 3 9 -9 6 5 10 -2 -5 -9 1 3 -4 -1 -8 -7
2 14
1 8 11 1
2 7
1 6 17 1
1 9 2 7
1 12 1 7
2 20
2 5
1 14 8 2
1 8 17 4
2 4
1 11 12 9
2 8
2 3
2 2
1 17 7 2
1 3 18 1
2 11
1 5 12 6
1 12 7 1
2 16
2 11
2 10
2 19
2 20
2 18
1 18 20 1
2 13
1 3 18 2
1 20 5 1
 */
