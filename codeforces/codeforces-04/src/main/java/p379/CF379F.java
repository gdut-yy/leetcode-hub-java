package p379;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF379F {
    // Time limit exceeded on test 21
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int q;

    public static void main(String[] args) {
        q = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int n = 5 + q * 2;
        pa = new int[n][mx];
        pa[2][0] = 1;
        pa[3][0] = 1;
        pa[4][0] = 1;
        dep = new int[n];
        dep[2] = 1;
        dep[3] = 1;
        dep[4] = 1;

        end1 = 2;
        end2 = 3;
        diameter = 2;
        cur = 5;
        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int v = scanner.nextInt();
            pa[cur][0] = v;
            for (int i = 0; i + 1 < mx; i++) {
                pa[cur][i + 1] = pa[pa[cur][i]][i];
            }
            pa[cur + 1] = pa[cur];
            dep[cur] = dep[v] + 1;
            dep[cur + 1] = dep[cur];

            int d1 = getDis(end1, cur);
            int d2 = getDis(end2, cur);
            if (d1 > diameter) {
                end2 = cur;
                diameter = d1;
            } else if (d2 > diameter) {
                end1 = cur;
                diameter = d2;
            }
            ans[qi] = diameter;
            cur += 2;
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    // CF916E
    static final int mx = 20;
    static int[][] pa;
    static int[] dep;
    static int end1, end2, diameter, cur;

    static int uptoDep(int v, int d) {
        for (int k = dep[v] - d; k > 0; k &= k - 1) {
            v = pa[v][Integer.numberOfTrailingZeros(k)];
        }
        return v;
    }

    static int getLCA(int v, int w) {
        if (dep[v] > dep[w]) {
            int tmp = v;
            v = w;
            w = tmp;
        }
        w = uptoDep(w, dep[v]);
        if (w == v) return v;
        for (int i = mx - 1; i >= 0; i--) {
            if (pa[v][i] != pa[w][i]) {
                v = pa[v][i];
                w = pa[w][i];
            }
        }
        return pa[v][0];
    }

    static int getDis(int v, int w) {
        return dep[v] + dep[w] - dep[getLCA(v, w)] * 2;
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
F. New Year Tree
https://codeforces.com/contest/379/problem/F

灵茶の试炼 2024-10-25
题目大意：
你有一棵树，一开始有 4 个节点，编号为 1,2,3,4，其中 2,3,4 都和 1 相连。
输入 q(1≤q≤5e5) 表示有 q 次操作。
每次操作，输入 v(1≤v≤当前树的大小)，保证 v 是叶子。
在叶子 v 的下面添加两个新的节点与 v 相连，编号分别为 n+1 和 n+2，其中 n 是当前树的大小。
每次操作后，输出树的直径长度。

rating 2400
注意到，每次增加一个节点，直径长度至多增加 1，并且直径的两个端点，其中一个不变。
维护直径的两个端点 end1 和 end2，以及直径长度 diameter。
初始值 end1=2, end2=3, diameter=2。
每次添加节点 cur 时，计算 cur 到端点的距离 dis(end1, cur) 和 dis(end2, cur)，如果其中有一个距离大于 diameter，那么更新 diameter 和直径端点。
计算 dis 需要用到 LCA，原理请看【讲解】。
代码 https://codeforces.com/problemset/submission/379/287503951
代码备份（洛谷）
======

Input
5
2
3
4
8
5
Output
3
4
4
5
6
 */
