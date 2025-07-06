package p266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF266E {
    //    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve();
        out.flush();
    }

    private static void solve() {
        sPow = new long[n + 1][MX];
        for (int i = 1; i <= n; i++) {
            long powI = 1;
            for (int j = 0; j < MX; j++) {
                sPow[i][j] = (sPow[i - 1][j] + powI) % MOD;
                powI = powI * i % MOD;
            }
        }

        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n);
        seg.build(a, 1, 1, n);

        for (int i = 0; i < m; i++) {
            char op = scanner.next().charAt(0);
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();

            if (op == '=') {
                seg.modify(1, 1, n, l, r, k);
            } else {
                long[] s = seg.query(1, 1, n, l, r);
                long res = 0, powL = 1;
                for (int j = k; j >= 0; j--) {
                    res += s[j] * C[k][j] % MOD * powL;
                    powL = powL * -(l - 1) % MOD;
                }
                long ans = (res % MOD + MOD) % MOD;
                out.println(ans);
            }
        }
    }

    static final int MOD = (int) (1e9 + 7);
    static final int MX = 6;
    static long[][] C, sPow;

    static {
        C = new long[MX][MX];
        for (int i = 0; i < MX; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            int l, r;
            long[] sum;
            long todo;

            public Info(int l, int r, long[] sum, long todo) {
                this.l = l;
                this.r = r;
                this.sum = sum;
                this.todo = todo;
            }
        }

        long[] mergeInfo(long[] a, long[] b) {
            long[] c = new long[MX];
            for (int i = 0; i < MX; i++) {
                c[i] = a[i] + b[i];
            }
            return c;
        }

        void _do(int p, long x) {
            Info cur = info[p];
//            int l = p << 1, r = p << 1 | 1;
            int l = cur.l, r = cur.r;

            for (int i = 0; i < MX; i++) {
                cur.sum[i] = x * (sPow[r][i] - sPow[l - 1][i]) % MOD;
            }
            cur.todo = x;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
        }

        void build(int[] A, int p, int l, int r) {
            info[p] = new Info(l, r, new long[MX], -1);
            if (l == r) {
                info[p].sum[0] = A[l - 1];
                for (int i = 1; i < MX; i++) {
                    info[p].sum[i] = info[p].sum[i - 1] * l % MOD;
                }
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p].sum = mergeInfo(info[p << 1].sum, info[p << 1 | 1].sum);
        }

        void spread(int p) {
            long f = info[p].todo;
            if (f < 0) return;
            _do(p << 1, f);
            _do(p << 1 | 1, f);
            info[p].todo = -1;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, qv);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }

        long[] query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p].sum;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
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
E. More Queries to Array...
https://codeforces.com/contest/266/problem/E

灵茶の试炼 2025-06-27
题目大意：
输入 n(1≤n≤1e5) m(1≤m≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
下标从 1 开始。
然后输入 m 个询问，格式如下：
"= l r x"：把下标在 [l,r] 中的 a[i] 改成 x。(0≤x≤1e9)
"? l r k"：输出 a[l]*1^k + a[l+1]*2^k + ... + a[r]*(r-l+1)^k，其中 ^ 是幂运算，0≤k≤5。
答案模 1e9+7。

rating 2500
用 lazy 线段树维护 6 种元素和，即 a[i] * i^j 之和，其中 j=0,1,2,3,4,5。
区间修改，我们需要计算 x * (l^j + (l+1)^j + ... + r^j)，和式的计算可以用前缀和，需要提前预处理 i^0 的前缀和，i^1 的前缀和，……，i^5 的前缀和。即代码中的 sPow。
区间查询，首先从线段树中获取到长为 6 的数组 s[j] = a[l]*l^j + a[l+1]*(l+1)^j + ... + a[r]*r^j，其中 j=0,1,2,3,4,5。
我们要计算的是 sum_{i=l}^r a[i] * (i-l')^k，其中 l'=l-1。
用二项式定理把 (i-l')^k 展开，与 a[i] 相乘，把其中的 a[i]*i^j 用 s[j] 代替，得到最终答案为 C(k,j) * s[j] * (-l')^(k-j)
代码 https://codeforces.com/contest/266/submission/325343329
代码备份（Ubuntu Pastebin）
======

Input
4 5
5 10 2 1
? 1 2 1
= 2 2 0
? 2 4 3
= 1 4 1
? 1 4 5
Output
25
43
1300

Input
3 1
1000000000 1000000000 1000000000
? 1 3 0
Output
999999986
 */
