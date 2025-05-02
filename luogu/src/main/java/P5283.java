import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P5283 {
    static int n, k;
    static long[] a; // v, i

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
            a[i] ^= a[i - 1];
        }
        System.out.println(solve());
    }

    private static String solve() {
        Trie tr = new Trie(n + 1, 32);
        tr.put(0);
        for (int i = 1; i <= n; i++) {
            tr.put(a[i]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(n + 1, Comparator.comparingLong(o -> -o.xor));
        for (int i = 0; i < n + 1; i++) {
            pq.add(new Node(tr.maxXorKth(a[i], 1), i, 1));
        }

        long ans = 0;
        for (k *= 2; k > 0; k--) {
            Node p = pq.remove();
            ans += p.xor;
            p.k++;
            p.xor = tr.maxXorKth(a[p.i], p.k);
            pq.add(p);
        }
        return String.valueOf(ans / 2);
    }

    static class Node {
        long xor;
        int i, k;

        public Node(long xor, int i, int k) {
            this.xor = xor;
            this.i = i;
            this.k = k;
        }
    }

    // 0-1 Trie
//    static final int trieBitLen = 32;
//    static TrieNode root = new TrieNode();
//
//    static class TrieNode {
//        TrieNode[] son = new TrieNode[2];
//        int cnt;
//    }
//
//    static void put(long v) {
//        TrieNode o = root;
//        for (int i = trieBitLen - 1; i >= 0; i--) {
//            int b = (int) (v >> i & 1);
//            if (o.son[b] == null) {
//                o.son[b] = new TrieNode();
//            }
//            o = o.son[b];
//            o.cnt++;
//        }
//    }
//
//    static long maxXorKth(long v, int k) {
//        TrieNode o = root;
//        long ans = 0;
//        for (int i = trieBitLen - 1; i >= 0; i--) {
//            int b = (int) (v >> i & 1);
//            if (o.son[b ^ 1] != null) {
//                if (k <= o.son[b ^ 1].cnt) {
//                    ans |= 1L << i;
//                    b ^= 1;
//                } else {
//                    k -= o.son[b ^ 1].cnt;
//                }
//            }
//            o = o.son[b];
//        }
//        return ans;
//    }

    // 0-1 Trie
    // 2^31
    private static class Trie {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        // op:1 插入 op:-1 删除
        void put(long x) {
            int idx = 0;
            for (int i = m - 1; i >= 0; i--) {
                int b = (int) (x >> i & 1);
                if (dict[b][idx] == 0) {
                    dict[b][idx] = nextIdx++;
                }
                idx = dict[b][idx];
                cnt[idx]++;
            }
        }

        long maxXorKth(long x, int k) {
            long res = 0;
            int idx = 0;
            for (int i = m - 1; i >= 0; i--) {
                int b = (int) (x >> i & 1);
                if (k <= cnt[dict[b ^ 1][idx]]) {
                    res |= 1L << i;
                    b ^= 1;
                } else {
                    k -= cnt[dict[b ^ 1][idx]];
                }
                idx = dict[b][idx];
            }
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
P5283 [十二省联考 2019] 异或粽子
https://www.luogu.com.cn/problem/P5283

灵茶の试炼 2023-11-24
题目大意：
输入 n(1≤n≤5e5) k(1≤k≤2e5) 和长为 n 的数组 a(0≤a[i]<2^32)。
求 a 的非空连续子数组异或和中的前 k 大之和。
保证 a 有 k 个非空连续子数组。
思考：如果 k <= 1e10 呢？

https://www.luogu.com/article/lgethwl9
======

输入 #1
3 2
1 2 3
输出 #1
6
 */