package lq240824;

import java.util.Scanner;

public class LQ240824T9 {
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

    static final int INF = (int) 1e9;

    private static String solve() {
        int m;
        if (n <= 10) m = 1000 * n;
        else if (n <= 100) m = 1000 * 10;
        else m = 10000;

        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            ans += a[i];
            for (int j = 0; j < m + 1; j++) {
                dp[i + 1][j] += dp[i][j];
                dp[i + 1][j] = Math.min(dp[i + 1][j], 2);
                int x = j + a[i];
                if (x > m)
                    continue;
                dp[i + 1][x] += dp[i][j];
                dp[i + 1][x] = Math.min(dp[i + 1][x], 2);
            }
        }
        int mi = INF;
        for (int i = 0; i < m; i++) {
            if (dp[n][i + 1] == 2) {
                mi = Math.min(mi, i + 1);
            }
        }
        if (mi == INF || ans <= 2 * mi) return "-1";
        ans -= 2 * mi;
        return String.valueOf(ans);
    }
}
/*
三英战萝卜【算法赛】

在本题中，我们需要最大化刘备能够吃到的萝卜总重量。
为了方便后续的表述，我们可以先将萝卜的总重量定义为 sum（sum = \sum\limits_{i=1}^n a_i），刘备吃到的萝卜的总重量为 L，关羽吃到的萝卜的总重量为 G，张飞吃到的萝卜的总质量为 Z。
sum, L, G, Z 满足：sum = L + G + Z
根据题目要求，三位将军需要分配萝卜，并且有以下条件：
- 每位将军至少要吃一个萝卜，即 L > 1, G > 1, Z > 1。
- 关羽和张飞所吃的萝卜总重量必须相等，即 G = Z。
因为 G 和 Z 相等，所以我们可以设 G = B = t。这样 L 就可以重写为：
L = sum - 2t
为了最大化刘备所能吃到的萝卜重量（即 L），我们需要最小化 t 的取值。那么如何求解最小的 t 呢？我们可以使用动态规划。
定义 dp[i][j]，表示前 i 个萝卜中，有多少种选择方案可以使得选中的萝卜的总重量为 j。根据第 i 个萝卜选和不选两种情况，其转移方程为：
dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i]]
如果 dp[n][j] >= 2，则说明这 n 个萝卜至少有两种不同的选择使得总重量 j。满足 dp[n][j] 的最小的 j 即为我们要求的 t。将 t 带入 L = sum - 2t，即可完成求解。
说明 1： dp[i][j] 如何保证不同方案选择的萝卜不会重复？
dp[i][j] 无法确保不同方案中选择的萝卜不会重复。但如果 dp[i][j] 所对应的方案中，有 2 个方案都包含相同的萝卜（例如 a_x），那么在对应的状态 dp[i][j - a_x] 中，能够形成该状态的方案数必然大于等于 2。
最小的 t 值对应的状态 dp[n][j] 必须满足 dp[n][j] >= 2，这意味着 t 不可能等于 j，因为至少存在一个 j - a_x 的状态，它对应的组合数也大于等于 2。如此，我们即可保证了不会有重复选择的问题。
说明2：t 的上限是多少？
举例来说：
当 n = 10 时，t 的上限为 $10\times \max(a_i) = 10^4$。
当 n = 100 时，t 的上限为 $100 \times \max(a_i) = 10^5$。
当 n = 1000 时：从 n 个萝卜中选择 2 个萝卜的方案数为 $C_{1000}^2 = 499500$。由于 1 <= a_i <= 10^3，所以如果我们只考虑 2 种萝卜的重量和，
那么它们的总和最小为 2，最大为 2000，即所有可能的重量和的范围在 2 到 2000 之间。根据鸽巢原理，如果我们有 499500 种组合，而这些组合的范围仅为 1999(2 ~ 2000)，那么必然会存在至少一对组合具有相同的总重量。
一般地，当我们选择了 k 个萝卜时，如果组合数量 $C_n^k$ 大于 $k \times \max(a_i)$，那么可以推断出 t 的值不会超过 $k \times \max(a_i)$。这是因为如果 t 的值过大，就会导致选择的组合数量不足。
于是，对于不同的 n，我们就可以设置不同的 t 的上限，来减少计算复杂度，确保效率。
> 如果组合数量很大，重量范围相对较小，总会有多个组合对应相同的重量。因此，限制上限不会导致有效解的丢失，而是更高效地聚焦于可能的解。
 */