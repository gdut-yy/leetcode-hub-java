package p1720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CF1720D2 {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static int[] tt, dp;
    private static int cnt;

    // https://codeforces.com/contest/1720/submission/168880618
    private static String solve(int n, int[] a) {
        int m = (2 + n * 30) * 2 + 1;
        tt = new int[m];
        dp = new int[m];
        cnt = 4;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = query(a[i], i) + 1;
            ans = Math.max(ans, x);
            update(a[i], i, x);
        }
        return String.valueOf(ans);
    }

    private static void update(int a_, int i_, int x) {
        for (int t = 1, h = 29; h >= 0; h--) {
            int a = a_ >> h & 1, i = i_ >> h & 1;
            int ai = t << 1 ^ a ^ i;
            if (tt[ai] == 0) {
                tt[ai] = cnt++;
            }
            t = tt[ai];
            ai = t << 1 ^ i;
            if (dp[ai] < x) {
                dp[ai] = x;
            }
        }
    }

    private static int query(int a_, int i_) {
        int x = 0;
        for (int t = 1, h = 29; h >= 0 && t > 0; h--) {
            int a = a_ >> h & 1, i = i_ >> h & 1;
            // b ^ i < a ^ j
            // a 1  i 1  b 1  j 0
            // a 1  i 0  b 0  j 0
            // a 0  i 1  b 1  j 1
            // a 0  i 0  b 0  j 1
            int t_ = tt[t << 1 ^ a ^ i ^ 1];
            int y = dp[t_ << 1 ^ a ^ 1];
            if (x < y) {
                x = y;
            }
            t = tt[t << 1 ^ a ^ i];
        }
        return x;
    }

    // TLE
    private static String solve1(int n, int[] a) {
        List<Map<Integer, int[][]>> f = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            f.add(new HashMap<>());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int mx = 0;
            for (int k = 0; k < 30; k++) {
                mx = Math.max(mx, f.get(k).getOrDefault((v ^ i) >> (k + 1), new int[2][2])[v >> k & 1 ^ 1][i >> k & 1]);
            }
            mx++;
            ans = Math.max(ans, mx);
            for (int k = 0; k < 30; k++) {
                int[][] p = f.get(k).getOrDefault((v ^ i) >> (k + 1), new int[2][2]);
                p[i >> k & 1][v >> k & 1] = Math.max(p[i >> k & 1][v >> k & 1], mx);
                f.get(k).put((v ^ i) >> (k + 1), p);
            }
        }
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
D2. Xor-Subsequence (hard version)
https://codeforces.com/contest/1720/problem/D2

灵茶の试炼 2023-05-12
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(2≤n≤3e5) 和长为 n 的数组 a(0≤a[i]≤1e9)，下标从 0 开始。
构造一个严格单调递增的，元素范围在 [0,n-1] 的下标数组 id。
要求 id 中的所有相邻元素 i 和 j，都满足 a[i] XOR j < a[j] XOR i。
例如 a=[5,2,4,3,1]，构造 id=[1,2,4]，满足 a[1] XOR 2 < a[2] XOR 1 以及 a[2] XOR 4 < a[4] XOR 2。
输出 id 的最大长度。

灵神解法 TLE
https://codeforces.com/contest/1720/submission/204199800
看到 a[i] XOR j < a[j] XOR i 这个式子，就很想把 i 移到左边，j 移到右边，这样就好处理了。
但这是小于，不是等于，没法移项！
要是能想办法改成等于就好了。
既然是位运算，那么从比特位入手，想一想这个 < 是怎么产生的。
假设 a[i] XOR j 和 a[j] XOR i 的高 k 个比特位都相等，从高到低第 k+1 个比特位不同，那么一定是 a[i] XOR j 这一位是 0，a[j] XOR i 这一位是 1，这样才能是小于的关系。
a[i] XOR j 和 a[j] XOR i 的高 k 个比特位都相等，意味着只看这些比特位，a[i] XOR j = a[j] XOR i。
是等号！太棒了，这样就可以把 i 移到左边，j 移到右边了，用哈希表统计 a[i] XOR i，统计什么呢？
但还要比较第 k+1 个比特位，必须满足：
1. a[i] XOR j = 0，那要么 a[i] = j = 0，要么 a[i] = j = 1。
2. a[j] XOR i = 1，那要么 a[j] = 0，i = 1，要么 a[j] = 1，i = 0。
假设当前遍历到 a[j]，由于 j 和 a[j] 是已知的，我们需要找的 a[i] 和 j 在这个比特位是相等的，i 和 a[j] 在这个比特位是相反的。
一通分析后，定义 f[k][x][0/1][0/1] 记录 a[i] XOR i 的高 k 个比特位的值为 x，i 的从高到低第 k+1 的比特值 0/1，a[i] 的从高到低第 k+1 的比特值 0/1，此时的下标数组 id 长度的最大值。
枚举 k，按上述规则求 id 长度的最大值，加一后更新到对应的位置上。
======

input
3
2
1 2
5
5 2 4 3 1
10
3 8 8 2 9 1 6 2 8 3
output
2
3
6

1
3
0 805306368 536870912
 */
