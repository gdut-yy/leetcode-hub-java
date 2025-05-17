package p474;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF474F {
    // Time limit exceeded on test 27
    //    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(a[i], e -> new ArrayList<>()).add(i);
        }
        InfoSegmentTree seg = new InfoSegmentTree(n);
        seg.build(a, 1, 0, n - 1);

        List<String> output = new ArrayList<>();
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt();
            int gcd = (int) seg.query(1, 0, n - 1, l, r - 1).gcd;
            List<Integer> p = pos.getOrDefault(gcd, new ArrayList<>());
            long res = r - l - searchInts(p, r) + searchInts(p, l);
            output.add(String.valueOf(res));
        }
        return String.join("\n", output);
    }

    private static String solve1() {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(a[i], e -> new ArrayList<>()).add(i);
        }
        SparseTable st = new SparseTable(a);

        List<String> output = new ArrayList<>();
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt();
            int gcd = (int) st.query(l, r);
            List<Integer> p = pos.getOrDefault(gcd, new ArrayList<>());
            long res = r - l - searchInts(p, r) + searchInts(p, l);
            output.add(String.valueOf(res));
        }
        return String.join("\n", output);
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

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Info {
            long gcd;

            public Info(long gcd) {
                this.gcd = gcd;
            }
        }

        Info mergeInfo(Info a, Info b) {
            return new Info(getGCD(a.gcd, b.gcd));
        }

        int n;
        Info[] info;

        public InfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(A[l]);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }

    static class SparseTable {
        long[][] st;

        public SparseTable(int[] a) {
            int n = a.length;
            st = new long[n][17];
            for (int i = 0; i < n; i++) {
                st[i][0] = a[i];
            }
            for (int j = 1; (1 << j) <= n; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[i][j] = getGCD(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        long query(int l, int r) {
            int k = bitsLen(r - l) - 1;
            return getGCD(st[l][k], st[r - (1 << k)][k]);
        }

        // bits.Len:
        // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
        int bitsLen(long x) {
            if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
            return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
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
F. Ant colony
https://codeforces.com/contest/474/problem/F

灵茶の试炼 2025-04-10
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入两个数 L 和 R，表示下标从 L 到 R 的连续子数组 (1≤L≤R≤n)。
对于每个询问，输出 R-L+1-C，其中 C 为子数组中的元素 x 的个数，满足 x 能整除子数组中的每个数。

rating 2100
对于子数组（区间）中的元素 x，x 必须能整除区间中的所有数，也就是 x 必须能整除区间 GCD。
区间 GCD 怎么求？可以用 ST 表或者线段树。
注意到区间 GCD <= 区间 min。
由于 x 在区间中，所以如果 GCD < min，那么 x 无法整除一个比自己还小的正整数。
如果 GCD = min，那么 x 只能等于 GCD。
所以问题相当于求区间中的值为 GCD 的个数。
把相同元素的下标整理到一个列表中，然后在 GCD 的下标列表中二分查找 [L,R] 中的下标个数，即为区间中的等于 GCD 的元素个数。
代码 https://codeforces.com/contest/474/submission/312284777
代码备份（洛谷）
======

Input
5
1 3 2 4 2
4
1 5
2 5
3 5
4 5
Output
4
4
1
1
 */
