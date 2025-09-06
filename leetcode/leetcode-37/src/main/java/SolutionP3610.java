import java.util.Arrays;

public class SolutionP3610 {
    public int minNumberOfPrimes(int n, int m) {
        int[] coins = getCoins(n, m);
        return coinChange(coins, n);
    }

    // solution322
    private int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            f[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return (f[amount] > amount) ? -1 : f[amount];
    }

    static final int MAX_N = (int) 1e4;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (np[i]) continue;
            for (int j = i * i; j <= MAX_N; j += i) np[j] = true;
        }
    }

    private int[] getCoins(int n, int m) {
        int[] primes = new int[n];
        int count = 0;
        for (int i = 2; i <= n; ++i) {
            if (np[i]) continue;
            primes[count++] = i;
            if (count == m) break;
        }
        return Arrays.copyOf(primes, count);
    }
}
/*
$3610. 目标和所需的最小质数个数
https://leetcode.cn/problems/minimum-number-of-primes-to-sum-to-target/description/

给定两个整数 n 和 m。
你必须从 前 m 个 质数 中选择一个多重集合，使得所选质数的和 恰好 为 n。你可以 多次 使用每个质数。
返回组成 n 所需的最小质数个数，如果不可能，则返回 -1。
提示：
1 <= n <= 1000
1 <= m <= 1000

复用322题代码-完全背包
相似题目: 322. 零钱兑换
https://leetcode.cn/problems/coin-change/
 */