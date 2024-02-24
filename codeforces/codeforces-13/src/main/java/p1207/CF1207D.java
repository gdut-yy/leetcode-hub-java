package p1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1207D {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 12
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long ans = 1, sa = 1, sb = 1, sp = 1;
        long[] ca = new long[n + 1];
        long[] cb = new long[n + 1];
        Map<Long, Integer> cp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = a[i][0], y = a[i][1];

            ca[x]++;
            cb[y]++;
            long key = (long) x << 32 | y;
            cp.put(key, cp.getOrDefault(key, 0) + 1);

            ans = ans * (i + 1) % MOD;
            sa = sa * (ca[x]) % MOD;
            sb = sb * (cb[y]) % MOD;
            sp = sp * cp.get(key) % MOD;
        }
        ans -= sa + sb;
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        // if sort.SliceIsSorted(a, func(i, j int) bool { return a[i].y < a[j].y }) {
        //     ans += sp
        // }
        if (isSorted()) {
            ans += sp;
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    static boolean isSorted() {
        for (int i = 1; i < n; i++) {
            if (a[i - 1][1] > a[i][1]) {
                return false;
            }
        }
        return true;
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
D. Number Of Permutations
https://codeforces.com/contest/1207/problem/D

灵茶の试炼 2022-09-01
题目大意：
输入 n (≤3e5) 和一个 pair 数组 p，即 p1=(a1,b1), p2=(a2,b2), ..., pn=(an,bn)，其中 ai 和 bi 均在 [1,n] 内。
定义一个 1~n 的下标排列是好的，当且仅当 p 按照该下标排列重排后，{ai} 序列和 {bi} 序列均不是单调非降的。
输出好的下标排列的个数。

rating 1800
https://codeforces.com/problemset/submission/1207/170446877
提示 1：正难则反。
提示 2：容斥原理。
提示 3：设：
sa 等于让 {ai} 为单调非降序列的下标排列个数，
sb 等于让 {bi} 为单调非降序列的下标排列个数，
sp 等于让 {ai} 和 {bi} 均为单调非降序列的下标排列个数，
根据容斥原理，答案为 n! - sa - sb + sp。
提示 4：如何计算呢？如果有相同元素，那么把它们交换位置就生成了另一种下标排列。由于不同元素值之间是独立的，根据乘法原理，将每个元素出现次数的阶乘乘起来就好了。
如果按照 (ai,bi) 排序后，{bi} 不是单调非降的，则 sp 为 0。
注意：由于有取模，作减法可能会产生负数。
======

input
3
1 1
2 2
3 1
output
3

input
4
2 3
2 2
2 1
2 4
output
0

input
3
1 1
1 1
2 3
output
4
 */
