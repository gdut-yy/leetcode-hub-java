package p986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF986E {
    // Time limit exceeded on test 20
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MX = (int) (1e7 + 1);
    static final int MOD = (int) (1e9 + 7);
    static int[] lpf;
    static int n;
    static List<Integer>[] g;
    static int[][] pa;
    static int[] dep;
    static int[] a;
    static List<int[]>[] qs;
    static int[] ans;
    static Map<Integer, Map<Integer, Integer>> mulCnt;
    static int mx;

    static void build(int v, int p) {
        pa[v][0] = p;
        for (int w : g[v]) {
            if (w != p) {
                dep[w] = dep[v] + 1;
                build(w, v);
            }
        }
    }

    static int uptoDep(int v, int d) {
        int k = dep[v] - d;
        while (k > 0) {
            int tz = Integer.numberOfTrailingZeros(k);
            v = pa[v][tz];
            k &= k - 1;
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
            int pv = pa[v][i], pw = pa[w][i];
            if (pv != pw) {
                v = pv;
                w = pw;
            }
        }
        return pa[v][0];
    }

    static int pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return (int) res;
    }

    static int abs(int x) {
        return x < 0 ? -x : x;
    }

    static int gcd(int a, int b) {
        while (a != 0) {
            int t = b % a;
            b = a;
            a = t;
        }
        return b;
    }

    static void dfs(int v, int fa) {
        int x = a[v];
        while (x > 1) {
            int p = lpf[x];
            int mul = p;
            x /= p;
            while (x % p == 0) {
                mul *= p;
                x /= p;
            }
            Map<Integer, Integer> m = mulCnt.get(p);
            if (m == null) {
                m = new HashMap<>();
                mulCnt.put(p, m);
            }
            m.put(mul, m.getOrDefault(mul, 0) + 1);
        }
        for (int[] q : qs[v]) {
            long res = 1;
            int qx = abs(q[0]);
            while (qx > 1) {
                int p = lpf[qx];
                int mul = p;
                qx /= p;
                while (qx % p == 0) {
                    mul *= p;
                    qx /= p;
                }
                Map<Integer, Integer> m = mulCnt.get(p);
                if (m != null) {
                    for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                        res = res * pow(Math.min(e.getKey(), mul), e.getValue()) % MOD;
                    }
                }
            }
            if (q[0] > 0) {
                ans[q[1]] = (int) ((long) ans[q[1]] * res % MOD);
            } else {
                ans[q[1]] = (int) ((long) ans[q[1]] * pow((int) res, MOD - 3) % MOD * gcd(-q[0], a[v]) % MOD);
            }
        }
        for (int w : g[v]) {
            if (w != fa) dfs(w, v);
        }
        x = a[v];
        while (x > 1) {
            int p = lpf[x];
            int mul = p;
            x /= p;
            while (x % p == 0) {
                mul *= p;
                x /= p;
            }
            Map<Integer, Integer> m = mulCnt.get(p);
            m.put(mul, m.get(mul) - 1);
        }
    }

    private static void solve() {
        lpf = new int[MX];
        for (int i = 2; i < MX; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j < MX; j += i) {
                    if (lpf[j] == 0) lpf[j] = i;
                }
            }
        }
        n = scanner.nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        pa = new int[n][17];
        dep = new int[n];
        build(0, -1);
        mx = 32 - Integer.numberOfLeadingZeros(n);
        for (int i = 0; i < mx - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = (p != -1) ? pa[p][i] : -1;
            }
        }
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        qs = new ArrayList[n];
        for (int i = 0; i < n; i++) qs[i] = new ArrayList<>();
        int q = scanner.nextInt();
        ans = new int[q];
        Arrays.fill(ans, 1);
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            int lca = getLCA(v, w);
            qs[v].add(new int[]{x, i});
            qs[w].add(new int[]{x, i});
            qs[lca].add(new int[]{-x, i});
        }
        mulCnt = new HashMap<>();
        dfs(0, -1);
        for (int v : ans) out.println(v);
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
E. Prince's Problem
https://codeforces.com/contest/986/problem/E

灵茶の试炼 2026-02-20
题目大意：
输入 n(1≤n≤1e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。
然后输入长为 n 的数组 a(1≤a[i]≤1e7)，表示节点点权。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入 u v(1≤u,v≤n) x(1≤x≤1e7)。
对于每个询问，设从 u 到 v 的简单路径的点权序列为 b，
输出 gcd(x,b[1]) * gcd(x,b[2]) * ... * gcd(x,b[k]) % (1e9+7)，其中 k 是 b 的长度。

rating 2800
从质因子分解的角度计算 gcd。
比如 x = 8，即 2^3。由于 x 只包含质因子 2，那么 gcd 也只包含质因子 2，所以只需考虑点权中的质因子 2 的幂次 e。
对于 e >= 3 的点权，对答案的贡献是 2^3。
对于 e < 3 的点权，对答案的贡献是 2^e。
我们需要知道路径点权的质因子分解中，有多少个 2^1, 2^2, 2^3, ... 这样对不同的 x 也能快速计算。
整体框架为：
1. 把 u 到 v 的 gcd 乘积分解成 (root 到 u 的 gcd 乘积) * (root 到 v 的 gcd 乘积) / ((root 到 lca(u,v) 的 gcd 乘积) ^ 2) * gcd(x, a[lca(u,v])。注：最后一项是因为 gcd(x, a[lca(u,v]) 我们除了两次，要再乘回来。
2. 把询问离线。每个询问分成三个子问题：root 到 u 的 gcd 乘积，root 到 v 的 gcd 乘积，root 到 lca(u,v) 的 gcd 乘积。
3. 写一个回溯，在 DFS 树的过程中，维护从 root 到当前节点的路径点权的质因子的个数。具体地，对于每个质数 p，统计 p^1, p^2, p^3, ... 的出现次数。可以用 map 套 map 记录，p -> p^e -> p^e 的个数。
4. 计算在当前节点的询问。把 x 质因子分解，比如 x 分解出了一个 p^2，那么如果 map[p] 中有 3 个 p^1, 2 个 p^2, 1 个 p^3，对答案的贡献就是 (p^1 ^ 3) * (p^2 ^ 2) * (p^2 ^ 1)，注意最后一项是 p^2，因为我们算的是 gcd，p 的幂次不会超过 x 中的 p 的幂次。
可以随便取一个节点作为 root。
预处理 LPF 可以 O(log x) 分解质因子。
代码 https://codeforces.com/problemset/submission/986/344572947
代码备份（上面打不开的同学看这个）
======

Input
4
1 2
1 3
1 4
6 4 9 5
3
2 3 6
2 3 2
3 4 7
Output
36
4
1

Input
6
1 2
2 3
2 4
1 5
5 6
100000 200000 500000 40000 800000 250000
3
3 5 10000000
6 2 3500000
4 1 64000
Output
196000
12250
999998215
 */
