package p1829;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1829H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int k, int[] a) {
        int[][] dp = new int[n + 1][1 << 6];

        for (int i = 1; i <= n; i++) {
            for (int mask = 0; mask < (1 << 6); ++mask) {
                dp[i][mask] += dp[i - 1][mask];
                if (dp[i][mask] >= MOD) dp[i][mask] -= MOD;
                dp[i][mask & a[i]] += dp[i - 1][mask];
                if (dp[i][mask & a[i]] >= MOD) dp[i][mask & a[i]] -= MOD;
            }
            dp[i][a[i]] = (dp[i][a[i]] + 1) % MOD;
        }

        int ans = 0;
        for (int mask = 0; mask < (1 << 6); ++mask) {
            if (Integer.bitCount(mask) == k) {
                ans = (ans + dp[n][mask]) % MOD;
            }
        }
        return String.valueOf(ans);
    }
}
/*
H. Don't Blame Me
https://codeforces.com/contest/1829/problem/H

题目大意：
遗憾的是，出题者想不出一个有趣的故事，所以他只是让你解决下面的问题。
给定一个由 n 个正整数组成的数组 a，计算子序列中元素的按位与在其二进制表示中恰好有 k 个集合位的非空子序列的个数。答案可能很大，所以输出它对 10^9+7 取模。
回想一下，数组 a 的子序列是一个可以通过删除一些(可能为零)元素从 a 中获得的序列。例如，[1,2,3]，[3]，[1,3]是[1,2,3]的子序列，但[3,2]和[4,5,6]不是。
注意 AND 表示位与操作。

位运算。
我们可以注意到这些数字非常小(最多 63)，and 值也将最多 63。因此，我们可以计算从 0 到 63 的所有 x 的与值等于 x 的子序列的个数。
我们可以用动态规划来实现。我们将 dp[i][j] 表示为使用前 i 个元素的子序列的个数，这些元素的与值总和为 j。转换非常简单。我们可以遍历之前获得的所有 j 个值，并分别更新这些值:
我们有三种情况:
第一种情况是我们不使用第 i 个值。这里我们只更新 dp[i][j] 的方式如下: dp[i][j]=dp[i][j]+dp[i−1][j] .
第二种情况是当我们使用第 i 个值时。这里我们更新 dp[i][a[i]&j] 在以下方式: dp[i][a[i]&j]=dp[i][a[i]&j]+dp[i−1][j] .
第三种情况是从第 i 个元素开始一个新的子序列。因此，我们更新 dp[i][a[i]]=dp[i][a[i]]+1 .
======

input
6
5 1
1 1 1 1 1
4 0
0 1 2 3
5 1
5 5 7 4 2
1 2
3
12 0
0 2 0 2 0 2 0 2 0 2 0 2
10 6
63 0 63 5 5 63 63 4 12 13
output
31
10
10
1
4032
15
 */

