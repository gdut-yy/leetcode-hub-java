package lq240224;

import java.util.Scanner;

public class LQ240224T9 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] dp = new long[1 << 15];
        dp[0] = 1;
        int s = 0;
        for (int x : a) {
            s |= x;
            for (int j = (1 << 15) - 1; j >= 0; j--) {
                dp[j | x] = (dp[j | x] + dp[j]) % MOD;
            }
        }

        long ans = quickPow(2, n);
        long val = 0;
        for (int i = 0; i < s; i++) {
            val += dp[i];
        }
        val = val % MOD * 2 % MOD;
        ans = (ans - val + MOD) % MOD;
        return String.valueOf(ans);
    }

    // res = a^b % mod
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

}
/*
集合划分【算法赛】

思路引入
对于二进制下某一位 k，若满足第 k 位上为 1 的 ai 个数不为 0 个，那么所有第 k 位上为 1 的数不能划分在同一个集合。
例如对于 (101)_2, (100)_2, (001)_2, (111)_2 这三个数， (101)_2, (001)_2, (111)_2 一定不能被划分在同一个集合，否则另一个集合的最低位一定为 0，不满足题设条件。
深度思考
所有第 k 位上为 1 的数不能划分在同一个集合不好处理，我们考虑其相反面进行容斥，所有第 k 位上为 1 的数都应当划分在同一个集合并不好处理
考虑容斥，强制钦定第 k 位上为 1 的数划分在同一个集合。
现在有若干数强制钦定在同一个集合，将这些数用并查集连接，在同一个并查集里的数说明一定要被分配在一个集合里，考虑乘法原理，每个并查集的连通块都有 2 种可能，即划分在 A 或 B，那么方案数即为 2^并查集连通块个数
复杂度分析
容斥一共有 O(2^15) 种情况。
对于每一种情况，需要进行 O(15N) 的判断，但所有数最多合并到同一个并查集里，并查集部分的复杂度为 NlogN。
复杂度为 O(2^15 * (15N + NlogN))

@hongrock
 */