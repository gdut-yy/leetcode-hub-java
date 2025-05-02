import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P1972 {
    static int n;
    static int[] a;
    static int m;
    static int[][] qs; // l, r, i

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        qs = new int[m][3];
        for (int i = 0; i < m; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = scanner.nextInt();
            qs[i][2] = i;
        }
        System.out.println(solve());
    }

    static final int maxn = (int) (1e6 + 5);

    private static String solve() {
        Arrays.sort(qs, Comparator.comparingInt(o -> o[1]));

        int[] ans = new int[m];
        int pow = 1;
        int[] vis = new int[maxn];
        BIT tr = new BIT(maxn);
        for (int i = 0; i < m; i++) {
            for (int j = pow; j <= qs[i][1]; j++) {
                if (vis[a[j]] != 0) {
                    tr.add(vis[a[j]], -1);
                }
                tr.add(j, 1);
                vis[a[j]] = j;
            }
            pow = qs[i][1] + 1;
            ans[qs[i][2]] = tr.query(qs[i][1]) - tr.query(qs[i][0] - 1);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
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

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
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
P1972 [SDOI2009] HH的项链
https://www.luogu.com.cn/problem/P1972

灵茶の试炼 2024-07-08 ext
# [SDOI2009] HH的项链

## 题目描述

HH 有一串由各种漂亮的贝壳组成的项链。HH 相信不同的贝壳会带来好运，所以每次散步完后，他都会随意取出一段贝壳，思考它们所表达的含义。HH 不断地收集新的贝壳，因此，他的项链变得越来越长。

有一天，他突然提出了一个问题：某一段贝壳中，包含了多少种不同的贝壳？这个问题很难回答…… 因为项链实在是太长了。于是，他只好求助睿智的你，来解决这个问题。

## 输入格式

一行一个正整数 $n$，表示项链长度。
第二行 $n$ 个正整数 $a_i$，表示项链中第 $i$ 个贝壳的种类。

第三行一个整数 $m$，表示 HH 询问的个数。
接下来 $m$ 行，每行两个整数 $l,r$，表示询问的区间。

## 输出格式

输出 $m$ 行，每行一个整数，依次表示询问对应的答案。

## 样例 #1

### 样例输入 #1

```
6
1 2 3 4 3 5
3
1 2
3 5
2 6
```

### 样例输出 #1

```
2
2
4
```

## 提示

【数据范围】

对于 $20\%$ 的数据，$1\le n,m\leq 5000$；
对于 $40\%$ 的数据，$1\le n,m\leq 10^5$；
对于 $60\%$ 的数据，$1\le n,m\leq 5\times 10^5$；
对于 $100\%$ 的数据，$1\le n,m,a_i \leq 10^6$，$1\le l \le r \le n$。

本题可能需要较快的读入方式，最大数据点读入数据约 20MB
 */