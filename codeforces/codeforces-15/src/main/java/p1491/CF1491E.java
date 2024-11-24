package p1491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF1491E {
    static int n;
    static List<Integer> f;
//    static List<int[]>[] g; // to, eid

    // 链式前向星
    static int N = (int) (2e5 + 5), M = N * 2;
    static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M];
    static int idx = 0;

    static void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) throws IOException {
        // Time limit exceeded on test 9
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        f = new ArrayList<>();
        f.add(1);
        f.add(1);
        while (f.get(f.size() - 1) + f.get(f.size() - 2) <= n) {
            f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
        }
        if (f.getLast() != n) {
            System.out.println("NO");
            return;
        }

        Arrays.fill(he, -1);
//        g = new ArrayList[n + 1];
//        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
//            g[v].add(new int[]{w, i});
//            g[w].add(new int[]{v, i});
            add(v, w, i);
            add(w, v, i);
        }
        System.out.println(solve());
    }

    static boolean[] vis;

    private static String solve() {
        vis = new boolean[n - 1];
        if (check(1, n)) return "YES";
        return "NO";
    }

    static boolean check(int rt, int tar) {
        if (tar == 1) return true;
        t = f.get(searchInts(f, tar) - 1);
        x = 0;
        y = 0;
        z = 0;
        _tar = tar;
        dfs(rt, 0);
        int x0 = x, y0 = y, z0 = z;
        return z0 > 0 && check(x0, z0) && check(y0, tar - z0);
    }

    static int _tar, t;
    static int x, y, z;

    static int dfs(int v, int fa) {
        int size = 1;
//        for (int[] e : g[v]) {
//            int w = e[0], eid = e[1];
        for (int i = he[v]; i != -1; i = ne[i]) {
            int w = ed[i], eid = we[i];

            if (w == fa || vis[eid]) continue;
            int sz = dfs(w, v);
            if (z > 0) return 0;
            if (sz == t || sz == _tar - t) {
                vis[eid] = true;
                x = w;
                y = v;
                z = sz;
            }
            size += sz;
        }
        return size;
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
E. Fib-tree
https://codeforces.com/contest/1491/problem/E

灵茶の试炼 2024-04-12
题目大意：
输入 n(1≤n≤2e5) 和一棵树的 n-1 条边。节点编号从 1 开始。
定义斐波那契数列：
f[0]=f[1]=1。
对于任意 n>=0，f[n+2]=f[n+1]+f[n]。
定义斐波那契树：
树的顶点个数必须等于某个 f[k]，
并且必须满足：要么只有一个点，要么可以通过删除一条边，分成两棵斐波那契树。
判断输入的树是否为斐波那契树。输出 YES 或 NO。

rating 2400
首先，如果 n 不是斐波那契数，直接输出 NO。
对于递推式 f[k]=f[k-1]+f[k-2]，这是唯一一种把 f[k] 表示成两个斐波那契数之和的式子。因为 f[k] 无法等于一个比 f[k-2] 更小的数加上另一个斐波那契数 x，这会导致 x 比 f[k-1] 还大，这是不存在的。
所以，一棵大小为 f[k] 的斐波那契树，唯一一种拆分方案是分成大小为 f[k-1] 的子树和大小为 f[k-2] 的子树。
由于一棵树至多有两棵大小为 f[k-2] 的子树，所以删除边的方案至多有两种。
两种方案都要判断吗？
如果存在两种删边方案，那么把两条边都删除，我们会得到大小为 f[k-2], f[k-2], f[k-3] 的三棵子树。
所以任选一个删边方案就行，反正另外一棵子树在接下来的递归过程中还是要分开的。
所以按照斐波那契树的定义，递归判断即可。
根据斐波那契数列的增长速度，递归的层数只有 O(logn)，所以时间复杂度为 O(nlogn)。
https://codeforces.com/contest/1491/submission/250899412
======

Input
3
1 2
2 3
Output
YES

Input
5
1 2
1 3
1 4
1 5
Output
NO

Input
5
1 3
1 2
4 5
3 4
Output
YES
 */
