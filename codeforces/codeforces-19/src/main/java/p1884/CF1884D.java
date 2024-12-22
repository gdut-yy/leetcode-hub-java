package p1884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1884D {
    static int n;
    static int[] cnt;

    public static void main(String[] args) {
        // Time limit exceeded on test 16
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                cnt[v]++;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean[] hasD = new boolean[n + 1];
        long[] res = new long[n + 1];
        for (int i = n; i > 0; i--) {
            long c = 0;
            for (int j = i; j <= n; j += i) {
                if (cnt[i] > 0) {
                    hasD[j] = true;
                }
                c += cnt[j];
                res[i] -= res[j];
            }
            res[i] += c * (c - 1) / 2;
        }
        long ans = 0;
        for (int i = 0; i < hasD.length; i++) {
            if (!hasD[i]) {
                ans += res[i];
            }
        }
        return String.valueOf(ans);
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
D. Counting Rhyme
https://codeforces.com/contest/1884/problem/D

灵茶の试炼 2024-05-17
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤1e6。
每组数据输入 n(1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤n)。
输出有多少对 (i,j)，满足 i<j 且不存在 a[k] (1≤k≤n) 既可以整除 a[i] 又可以整除 a[j]。

rating 2100
整体思路
考虑有多少对 (a[i],a[j]) 的 GCD 恰好等于 k，将其记作 res[k]。
如果 a 中没有数能整除 k，我们就可以把 res[k] 加入答案。
如何计算 res[k]
统计 a 中每个元素的出现次数 cnt。
枚举 k 及其倍数（k,2k,3k,...），累加这些数的出现次数，记作 c。
这 c 个数中，任选两个数的 GCD，一定是 k 的倍数。所以 c*(c-1)/2 就是 GCD 等于 k,2k,3k,... 的数对的个数。
但我们要计算的是【恰好】等于 k 的数对个数，所以要减去 GCD 恰好等于 2k,3k,... 的数对个数，得
res[k] = c*(c-1)/2 - res[2k] - res[3k] - ...
这个过程可以用 O(nlogn) 的枚举完成。（调和级数）
注意要倒序枚举 k，因为转移来源是比 k 大的数。
如何计算 a 中是否有整除 k 的数（a 中是否有 k 的因子）
如果 cnt[i] > 0，那么对于 i,2i,3i,... 这些数来说，a 中都有这些数的因子。标记这些数。
这个过程也可以用 O(nlogn) 的枚举完成。
注意使用 64 位整数。
如果觉得代码有些慢，可以加个快读来提速。
https://codeforces.com/contest/1884/submission/261204647
======

Input
6
4
2 4 4 4
4
2 3 4 4
9
6 8 9 4 6 8 9 4 9
9
7 7 4 4 9 9 6 2 9
18
10 18 18 15 14 4 5 6 8 9 10 12 15 16 18 17 13 11
21
12 19 19 18 18 12 2 18 19 12 12 3 12 12 12 18 19 16 18 19 12
Output
0
3
26
26
124
82
 */
