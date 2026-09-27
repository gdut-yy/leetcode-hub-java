import java.util.Arrays;

public class SolutionP3802 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int n, int[] a) {
        long s = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.min(a[i], n - 1);
            s += a[i];
        }
        Arrays.sort(a);

        long ans = 0;
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] < n) {
                s -= a[i];
                i++;
            } else {
                s -= a[j];
                ans = (ans + s - (long) (n - a[j] - 1) * (j - i)) % MOD;
                j--;
            }
        }
        return (int) ((ans * 2 % MOD + MOD) % MOD); // 保证结果非负
    }
}
/*
$3802. 给纸张涂色的方式数量
https://leetcode.cn/problems/number-of-ways-to-paint-sheets/description/

给定一个整数 n 表示纸张的数量。
同时给定一个长度为 m 的整数数组 limit，其中 limit[i] 是使用颜色 i 能够涂色的最大纸张数。
你必须在下列条件下给 所有 n 张纸涂色：
- 恰好使用两种不同 颜色。
- 每种颜色必须覆盖 连续的一段 纸张。
- 用颜色 i 涂的纸张数量不能超过 limit[i]。
返回一个整数表示给所有纸张染色的 不同 方式数量。由于答案可能很大，返回答案对 109 + 7 取模的结果。
注意：如果 至少 有一张纸涂上了不同的颜色，就是不同的两种方式。
示例 1：
输入：n = 4, limit = [3,1,2]
输出：6
示例 2：
输入：n = 3, limit = [1,2]
输出：2
示例 3：
输入：n = 3, limit = [2,2]
输出：4
提示：
2 <= n <= 10^9
2 <= m == limit.length <= 10^5
1 <= limit[i] <= 10^9
 */