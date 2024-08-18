package lq240713;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240713T4 {
    static int n;
    static int[] v, a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = new int[n + 1];
        a = new int[n + 1];
        b = new int[n + 1];
        for (int i = 1; i <= n; i++) v[i] = scanner.nextInt();
        for (int i = 1; i <= n; i++) a[i] = scanner.nextInt();
        for (int i = 1; i <= n; i++) b[i] = scanner.nextInt();
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] dp = new long[1001];
        Arrays.fill(dp, INF);
        dp[v[1]] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v[i] - 1; j++) {
                dp[j] = INF;
            }
            for (int j = 1000; j >= 0; j--) {
                if (j + b[i] <= 1000) {
                    dp[j + b[i]] = Math.min(dp[j + b[i]], dp[j] + a[i]);
                } else {
                    dp[1000] = Math.min(dp[1000], dp[j] + a[i]);
                }
            }
        }

        long ans = Arrays.stream(dp).min().orElseThrow();
        return ans == INF ? "-1" : String.valueOf(ans);
    }
}
/*
能力爆表【算法赛】

我们需要找到从位置 1 到位置 N 的最小花费，并且在每个位置处，我们可以选择是否提升能力值。在这道题中，我们可以将问题划分为多个子问题：
对于位置 i，要想达到位置 i 的最小花费，我们需要考虑从位置 1 到位置 i-1 的最小花费，并选择在位置 i 处是否提升能力值，并且这些操作的后效性（能力值的改变）是有办法解决的，这种子问题的结构使得我们可以使用动态规划来解决。
状态设计
最简单的思路，定义一个二维数组 dp[i][j] 表示，到 i 位置，能力值为 j 的最小花费，但是这样会使得我们的数组有可能过大，开不下这么大的数组，
但同时我们可以观察到，数组的第二维复用性很强，是类似 0-1 背包的结构，所以我们可以定义一个一维数组 dp，其中 dp[i] 表示能力值提升到 i 的最小花费，
状态初始化
首先，初始化数组 dp 为一个很大的数（比如 10^18），表示初始状态下无法到达该能力值。然后，将起始位置的能力值 V1 对应的 dp 值设为 0，表示起始位置的能力值不需要提升。
状态转移
接下来，我们从位置 2 开始遍历到位置 N，对于每个位置，我们遍历 0 到 v[i]-1 的能力值，将这些地方的花费设置为无限大，表示到该位置为止，如果能力值还低于 v[]，那么这些能力值对应的方案就是非法的，即没有办法移动到位置 i，故置为无穷大。
对于每个能力值 j，我们判断能否通过在位置 i 提升能力值达到 j+b[i]，果可以，则更新 dp[j+b[i]]为 dp[j]+a[i]，表示通过在位置 i 提升能力值到达 j+b[i] 的最小花费。
注意，如果 j+b[i] 超过了最大能力值 1000，则将其限制为最大能力值 1000，即 dp[1000]。
最后，我们遍历数组 dp，找到其中的最小值，即为从位置 1 到位置 N 的最小花费。
时间复杂度
遍历位置 2 到位置 N 对于每个位置遍历能力值范围 0 到⌈ v[i]-1，因此时间复杂度为 O（N * Vmax），其中 Vmax 表示最大能力值，
 */