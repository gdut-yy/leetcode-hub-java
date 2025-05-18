package p145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CF145C {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 35
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // https://codeforces.com/contest/145/submission/310334243
    private static String solve() {
        Map<Integer, Integer> cnt = new HashMap<>();
        // tot := 0
        int tot = n;
        for (int v : a) {
            // if strings.Count(s, "4")+strings.Count(s, "7") == len(s) {
            //   v, _ := strconv.Atoi(s)
            //   cnt[v]++
            //   tot++
            // }
            if (onlyHas47(v)) {
                cnt.merge(v, 1, Integer::sum);
                tot--;
            }
        }

        int m = cnt.size();
        long[] f = new long[m + 1];
        f[0] = 1;
        for (Integer c : cnt.values()) {
            for (int j = f.length - 1; j > 0; j--) {
                f[j] = (f[j] + f[j - 1] * c) % MOD;
            }
        }

        // for i, v := range f {
        //   ans = (ans + v*cm.c(n-tot, k-i)) % mod
        // }
        long ans = 0;
        for (int i = Math.min(m, k); i >= 0; i--) {
            if (tot + i >= k) {
                ans += f[i] * comb(tot, k - i) % MOD;
            }
        }
        ans %= MOD;
        return String.valueOf(ans);
    }

    static boolean onlyHas47(int x) {
        while (x > 0) {
            int d = x % 10;
            if (d != 4 && d != 7) return false;
            x /= 10;
        }
        return true;
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 1e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
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
C. Lucky Subsequence
https://codeforces.com/contest/145/problem/C

灵茶の试炼 2025-03-13
题目大意：
输入 n k(1≤k≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义幸运数字为：只包含 4 和 7 的数字。
输出 a 中有多少个长为 k 的子序列 b，满足 b 中没有相同的幸运数字。（非幸运数字可以有一样的）
答案模 1e9+7。
注：子序列不一定连续。如果两个子序列完全一样，但有元素下标不一样，也视作不同的子序列。

rating 2100
注意到，1e9 内的幸运数字，按照十进制长度 1,2,...,9 统计，只有 S = 2^1 + 2^2 + ... + 2^9 = 1022 个。
这样我们可以写一个 O(S^2) 的 DP。
设 f[i][j] 表示从（a 中的）前 i 种幸运数字中选 j 个幸运数字的方案数。
设第 i 种幸运数字有 c 个。
不选，问题变成从前 i-1 种幸运数字中选 j 个幸运数字的方案数，即 f[i][j] = f[i-1][j]。
从 c 个中选一个，问题变成从前 i-1 种幸运数字中选 j-1 个幸运数字的方案数，即 f[i][j] = f[i-1][j-1] * c。
根据加法原理相加，得 f[i][j] = f[i-1][j] + f[i-1][j-1] * c。
初始值 f[0][0] = 1。
最后，枚举选 j=0,1,2... 个幸运数字，这有 f.back()[j] 种选法，那么其余 k-j 个非幸运数字有 C(n-totalLucky, k-j) 种选法，其中 totalLucky 是 a 中幸运数字的总数。二者相乘，加到答案中。
代码实现时，f 的第一维度可以去掉。
代码 https://codeforces.com/problemset/submission/145/309699354
代码备份（洛谷）
======

Input
3 2
10 10 10
Output
3

Input
4 2
4 4 7 7
Output
4
 */
