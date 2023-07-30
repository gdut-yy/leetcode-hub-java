package p282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF282E {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve1());
    }

    // Time limit exceeded on test 46
    private static String solve() {
        long ans = 0;

        long pre = 0;
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            // 插入前缀（除了最后一个）
            TrieNode o = root;
            for (int j = 39; j >= 0; j--) {
                int b = (int) (pre >> j & 1);
                if (o.children[b] == null) {
                    o.children[b] = new TrieNode();
                }
                o = o.children[b];
                o.cnt++;
            }
            pre ^= a[i];
            // 前缀最大值
            ans = Math.max(ans, pre);
        }

        long suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf ^= a[i];
            // 「后缀异或前缀」的最大值
            long res = 0;
            TrieNode o = root;
            for (int j = 39; j >= 0; j--) {
                int b = (int) (suf >> j & 1);
                if (o.children[b ^ 1] != null && o.children[b ^ 1].cnt > 0) {
                    res |= 1L << j;
                    b ^= 1;
                }
                o = o.children[b];
            }
            ans = Math.max(ans, res);
        }
        return String.valueOf(ans);
    }

    private static class TrieNode {
        TrieNode[] children;
        int cnt;

        public TrieNode() {
            children = new TrieNode[2];
            cnt = 0;
        }
    }

    // https://codeforces.com/contest/282/submission/212508137
    private static String solve1() {
        long ans = 0;

        Trie trie = new Trie(n, 40);

        long pre = 0;
        for (int i = 0; i < n; i++) {
            trie.insert(pre);
            pre ^= a[i];
        }

        long suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = Math.max(ans, trie.query(suf));
            suf ^= a[i];
        }
        ans = Math.max(ans, trie.query(suf));
        return String.valueOf(ans);
    }

    private static class Trie {
        int[][] dict;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        public void insert(long x) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = (int) (x >> k & 1);
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
            }
        }

        public long query(long x) {
            long res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = (int) (x >> k & 1);
                if (dict[1 - pos][idx] != 0) {
                    res |= 1L << k;
                    idx = dict[1 - pos][idx];
                } else {
                    idx = dict[pos][idx];
                }
            }
            return res;
        }
    }
}
/*
E. Sausage Maximization
https://codeforces.com/contest/282/problem/E

灵茶の试炼 2023-07-07
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e12)。
选择 a 的一个前缀（可以为空）和一个后缀（可以为空），要求前缀后缀不相交。
输出所选数字的异或和的最大值。

前后缀分解 + 0-1 Trie
https://codeforces.com/problemset/submission/282/212487514
先从前到后扫一遍，把每个前缀异或和的值存到 0-1 trie 中。
然后从后往前扫一遍，对每个后缀异或和，计算它与前面的所有前缀异或和的异或的最大值。
由于题目要求前后缀不能相交，所以遍历后缀的时候，还需要删除到下标 i 的前缀异或和。
考虑到重叠的部分的异或和 = 0，对答案没有影响，所以不删除也是可以的。
相似题目: 421. 数组中两个数的最大异或值
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
======

input
2
1 2
output
3

input
3
1 2 3
output
3

input
2
1000 1000
output
1000
 */
