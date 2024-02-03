package p522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF522D {
    static int n, m;
    static int[] a;
    static int[][] lr;

    public static void main(String[] args) {
        // Time limit exceeded on test 28
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static String solve() {
        List<int[]>[] q = new ArrayList[n + 1];
        Arrays.setAll(q, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int l = lr[i][0], r = lr[i][1];
            q[r].add(new int[]{l, i});
        }

        int[] ans = new int[m];
        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 1, n);
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int p0 = last.getOrDefault(a[i], 0);
            if (p0 > 0) {
                seg.update(1, p0, i - p0);
            }
            for (int[] p : q[i]) {
                int res = seg.query(1, p[0], i);
                if (res == INF) {
                    res = -1;
                }
                ans[p[1]] = res;
            }
            last.put(a[i], i);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static final int INF = (int) 1e9;

    static class SegmentTree {
        int n;
        int[] tree_l, tree_r, tree_val;

        public SegmentTree(int n) {
            this.n = n;
            this.tree_l = new int[4 * n];
            this.tree_r = new int[4 * n];
            this.tree_val = new int[4 * n];
        }

        void build(int p, int l, int r) {
            tree_l[p] = l;
            tree_r[p] = r;
            tree_val[p] = INF;
            if (l == r) {
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
        }

        void update(int p, int i, int val) {
            if (tree_l[p] == tree_r[p]) {
                tree_val[p] = val;
                return;
            }
            int mid = (tree_l[p] + tree_r[p]) >> 1;
            if (i <= mid) update(p << 1, i, val);
            else update(p << 1 | 1, i, val);
            tree_val[p] = Math.min(tree_val[p << 1], tree_val[p << 1 | 1]);
        }

        int query(int p, int l, int r) {
            if (l <= tree_l[p] && tree_r[p] <= r) {
                return tree_val[p];
            }
            int mid = (tree_l[p] + tree_r[p]) >> 1;
            if (r <= mid) return query(p << 1, l, r);
            if (l > mid) return query(p << 1 | 1, l, r);
            return Math.min(query(p << 1, l, r), query(p << 1 | 1, l, r));
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
D. Closest Equals
https://codeforces.com/contest/522/problem/D

灵茶の试炼 2022-09-23
题目大意：
输入 n(≤5e5) 和 m(≤5e5)；然后输入一个长为 n 的数组 a(-1e9≤a[i]≤1e9)，数组下标从 1 开始；然后输入 m 个询问，每个询问表示一个数组 a 内的闭区间 [L,R] (1≤L≤R≤n)。
对每个询问，输出区间内的相同元素下标之间的最小差值。如果区间内不存在相同元素，输出 -1。
相似题目：https://www.luogu.com.cn/problem/P1972

rating 2000
https://codeforces.com/contest/522/submission/173138916
本题用到的技巧十分经典（指提示 4），如果你对此题没有思路，请务必掌握这一技巧。
提示 1：在相同元素中，只需要考虑相邻的元素。换句话说，这些元素对可以看成是若干线段。
提示 2：问题转换成查询区间内的最短线段。
提示 3：把询问离线，按照右端点排序。
提示 4：把提示 1 中的线段长度记录在线段的左端点上。
提示 5：遍历排序后的询问 [L,R]，如果位置 R 有线段的右端点，则更新线段左端点处的线段长度，我们最后要做的就是查询区间 [L,R] 内的最小值。
提示 6：用线段树实现。
线段长度可以一边遍历数组 a，一边用一个 last map 记录。
======

input
5 3
1 1 2 3 2
1 5
2 4
3 5
output
1
-1
2

input
6 5
1 2 1 3 2 3
4 6
1 3
2 5
2 4
1 6
output
2
2
3
-1
2
 */