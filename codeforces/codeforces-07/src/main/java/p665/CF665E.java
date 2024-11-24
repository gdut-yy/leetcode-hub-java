package p665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF665E {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static String solve() {
        Trie_Arr trie = new Trie_Arr(n, 31);
        long ans = 0;
        int ps = 0;
        trie.insert(ps);
        for (int i = 0; i < n; i++) {
            ps ^= a[i];
            ans += trie.query(ps, k);
            trie.insert(ps);
        }
        return String.valueOf(ans);
    }

    // 0-1 Trie
    // 2^31
    static class Trie_Arr {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie_Arr(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        public void insert(int x) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx]++;
            }
        }

        // >= U
        public int query(int x, int U) {
            int res = 0;
            int idx = 0;
            int cur = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if ((cur | (1 << k)) >= U) {
                    res += cnt[dict[pos ^ 1][idx]];
                    idx = dict[pos][idx];
                } else {
                    idx = dict[pos ^ 1][idx];
                    cur |= (1 << k);
                }
                if (idx == 0) break;
            }
            if (cur >= U) res += cnt[idx];
            return res;
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
E. Beautiful Subarrays
https://codeforces.com/contest/665/problem/E

题目大意：
一天，编码员 ZS 写下了一个元素为 a1,a2,...,an 的整数数组 a 。
数组 a 的一个子数组是某个整数 (l,r) 的序列 al,al+1,...,ar ，其中 1≤l≤r≤n .编码员 ZS 认为，如果子数组 a 中所有元素的比特 xor 至少为 k ，那么这个子数组 a 就是优美的。
请帮助编码员 ZS 找出 a 的优美子数组的个数！

相似题目: 1803. 统计异或值在范围内的数对有多少
https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/description/
======

Input
3 1
1 2 3
Output
5

Input
3 2
1 2 3
Output
3

Input
3 3
1 2 3
Output
2
 */
