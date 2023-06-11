package p1826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF1826E {
    static int m, n;
    static int[][] a;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        m = scanner.nextInt();
        n = scanner.nextInt();

        // 注意 行列交换
        a = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            a[i][m] = scanner.nextInt();
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static int M = 5005;

    // https://codeforces.com/contest/1826/submission/204586852
    private static String solve() {
        // 注意 行列交换
        // sort(a.begin(), a.end());
        Arrays.sort(a, (o1, o2) -> {
            int i = 0;
            while (i < m && o1[i] == o2[i]) i++;
            if (i == m) return 0;
            return Integer.compare(o1[i], o2[i]);
        });

        BitSet[] lower = new BitSet[n];
        for (int i = 0; i < n; i++) {
            lower[i] = new BitSet(M);
            // 全置 1
            lower[i].set(0, M);
        }

        // 下标数组
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;

        for (int i = 0; i < m; i++) {
            final int i1 = i;
            Arrays.sort(ids, Comparator.comparingInt(o -> a[o][i1]));

            BitSet cur = new BitSet(M);
            int p0 = 0;
            for (int j = 0; j < n; j++) {
                while (a[ids[p0]][i] < a[ids[j]][i]) cur.set(ids[p0++]);
                lower[ids[j]].and(cur);
            }
        }

        // LIS O(n^2)
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = a[i][m];
            for (int j = 0; j < i; j++) {
                if (lower[i].get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i][m]);
                }
            }
        }
        long ans = Arrays.stream(dp).max().orElseThrow();
        return String.valueOf(ans);
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
E. Walk the Runway
https://codeforces.com/contest/1826/problem/E

题目大意：
一次时装之旅包括在不同城市举办的 m 场相同的时装秀。有 n 个模特愿意参加这次巡演，编号从 1 到 n。不同城市的人对时尚产业有不同的看法，所以他们对每个模特的评价也不同。特别是，城市 i 的人对模型 j 的评级为 ri,j。
你要选择 k 个模型，以及它们的顺序，让选择的模型有索引 j1, j2,...,jk 按照选择的顺序。在每个城市，这 k 位模特将按照这个顺序依次走 t 台。
为了让这场秀更精彩，在每个城市，模特的评分应该严格按照她们的表现顺序递增。更正式地说，对于任何城市 i 和指标 t(2≤t≤k)，评级必须满足 r[i][jt−1]<r[i][jt]。
毕竟，时尚行业都是关于钱的，所以选择模特 j 参加巡演会给你带来 pj 钱。在满足所有要求的情况下，通过选择模型及其顺序，计算您所能获得的最大总利润。

bitset 优化 DP、LIS
时间复杂度 O(m·n^2) 即 500*5000*5000 = 1.25 * 1e8
注意 c++ 的 sort 对于第一维相等的情况下会比较下一维，依次类推
======

input
3 5
10 10 10 10 10
1 2 3 4 5
1 5 2 3 4
2 3 4 5 1
output
30

input
3 5
10 10 10 10 50
1 2 3 4 5
1 5 2 3 4
2 3 4 5 1
output
50

input
1 1
1000000000
1
output
1000000000

input
5 5
1000000000 1000000000 1000000000 1000000000 1000000000
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
output
5000000000

input
1 3
1 2 3
3 3 3
output
3
 */
