package p914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF914D {
    // Time limit exceeded on test 8
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

    static int[] treeL, treeR, treeGcd;
    static int size;

    static int gcd(int a, int b) {
        while (a != 0) {
            int t = b % a;
            b = a;
            a = t;
        }
        return b;
    }

    static void maintain(int o) {
        treeGcd[o] = gcd(treeGcd[o << 1], treeGcd[o << 1 | 1]);
    }

    static void build(int o, int l, int r) {
        treeL[o] = l;
        treeR[o] = r;
        if (l == r) {
            treeGcd[o] = scanner.nextInt();
            return;
        }
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
        maintain(o);
    }

    static void update(int o, int i, int v) {
        if (treeL[o] == treeR[o]) {
            treeGcd[o] = v;
            return;
        }
        int m = (treeL[o] + treeR[o]) >> 1;
        if (i <= m) update(o << 1, i, v);
        else update(o << 1 | 1, i, v);
        maintain(o);
    }

    static int query(int o, int l, int r, int v) {
        if (treeGcd[o] % v == 0) return 0;
        if (treeL[o] == treeR[o]) return 1;
        int m = (treeL[o] + treeR[o]) >> 1;
        int cnt = 0;
        if (l <= m) cnt += query(o << 1, l, r, v);
        if (cnt < 2 && r > m) cnt += query(o << 1 | 1, l, r, v);
        return cnt;
    }

    private static void solve() {
        int n = scanner.nextInt();
        size = 2 << bitsLen(n - 1);
        treeL = new int[size];
        treeR = new int[size];
        treeGcd = new int[size];
        build(1, 1, n);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int op = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
            if (op == 2) {
                update(1, l, r);
                continue;
            }
            int v = scanner.nextInt();
            out.println(query(1, l, r, v) < 2 ? "YES" : "NO");
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
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
D. Bash and a Tough Math Puzzle
https://codeforces.com/contest/914/problem/D

灵茶の试炼 2026-04-30
题目大意：
输入 n(1≤n≤5e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。下标从 1 开始。
然后输入 q(1≤q≤4e5) 和 q 个询问，格式如下：
"1 L R x"：能否通过修改子数组 [L,R] 中的至多一个数，使得子数组 gcd 等于 x？其中 1≤x≤1e9。输出 YES 或 NO。
"2 i y"：把 a[i] 更新成 y。其中 1≤y≤1e9。
注：询问 1 不会真的修改数组。

rating 1900
区间 gcd 等于 x，必要条件是区间内的数都是 x 的倍数。
如果区间内的数都是 x 的倍数，那么随便选一个数改成 x，区间 gcd 即为 x。
如果区间内只有一个数不是 x 的倍数，那么把这个数改成 x，区间 gcd 即为 x。
如果区间内至少有两个数不是 x 的倍数，那么无法把区间 gcd 变成 x。
用线段树维护单点修改。
查询时，统计区间内的不是 x 的倍数的数的个数。
如果区间 gcd 是 x 的倍数，说明区间内的数都是 x 的倍数，不再递归。
否则区间内一定有不是 x 的倍数的数，递归找。
找到两个就不再递归了，这保证了时间复杂度。
代码 https://codeforces.com/contest/914/submission/372668039
代码备份（上面打不开的同学看这个）
======

Input
3
2 6 3
4
1 1 2 2
1 1 3 3
2 1 9
1 1 3 2
Output
YES
YES
NO

Input
5
1 2 3 4 5
6
1 1 4 2
2 3 6
1 1 4 2
1 1 5 2
2 5 10
1 1 5 2
Output
NO
YES
NO
YES
 */
