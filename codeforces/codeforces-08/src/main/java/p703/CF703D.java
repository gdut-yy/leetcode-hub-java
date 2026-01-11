package p703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF703D {
    // Stuck in sleigh traffic on flight 14 TL14
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record Pair(int l, int i) {
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            s[i] = s[i - 1] ^ a[i];
        }

        int m = scanner.nextInt();
        ArrayList<Pair>[] qs = new ArrayList[n + 1];
        Arrays.setAll(qs, e -> new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            qs[r].add(new Pair(l, i));
        }

        int[] ans = new int[m];
        BIT t = new BIT(n + 1);
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int v = a[i];
            if (last.containsKey(v)) {
                t.update(last.get(v), v);
            }
            last.put(v, i);
            t.update(i, v);

            for (Pair p : qs[i]) {
                ans[p.i] = s[i] ^ s[p.l - 1] ^ t.pre(i) ^ t.pre(p.l - 1);
            }
        }

        for (int v : ans) {
            out.println(v);
        }
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void update(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] ^= val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret ^= tree[pos];
            return ret;
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
D. Mishka and Interesting sum
https://codeforces.com/contest/703/problem/D

灵茶の试炼 2025-07-17
题目大意：
输入 n(1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e9)。下标从 1 开始。
然后输入 m(1≤m≤1e6) 和 m 个询问。
每个询问输入 L R(1≤L≤R≤n)，请输出 a 的子数组 [L,R] 中的出现次数为偶数的元素，去重后的异或和。

rating 2100
同一个数 XOR 两次等于 0，XOR 偶数次也等于 0。
所以区间元素异或和 = 区间中出现次数为【奇数】的元素异或和。
所以区间元素异或和 XOR 区间去重后的元素异或和 = 区间中出现次数为【偶数】的元素异或和。
区间元素异或和，用前缀和解决。
区间去重后的元素异或和，用洛谷经典题 P1972 [SDOI2009] HH 的项链 解决。
具体来说，维护每个元素 v 上一次出现的位置 last[v]，用树状数组维护前缀去重后的元素异或和。
遍历到 v=a[i] 时，先撤消，即 update(last[v], v)；再更新，即 update(i, v)。这样可以让每个元素在树状数组上的位置尽量靠右。
把询问离线。树状数组计算 query(L,R) 就是区间 [L,R] 去重后的元素异或和。
输入量比较大，可以考虑用快读加速。
代码 + 快读 https://codeforces.com/contest/703/submission/329133481
代码 + 非快读 https://codeforces.com/contest/703/submission/329133391
代码备份（Ubuntu Pastebin）
======

Input
3
3 7 8
1
1 3
Output
0

Input
7
1 2 1 3 3 2 3
5
4 7
4 5
1 3
1 7
1 5
Output
0
3
1
3
2
 */
