import java.util.Arrays;

public class Solution3704 {
    private char[] s;
    private long[][][] memo;

    public long countNoZeroPairs(long n) {
        s = Long.toString(n).toCharArray();
        int m = s.length;
        memo = new long[m][2][2];
        for (long[][] mat : memo) {
            for (long[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(m - 1, false, true);
    }

    // borrowed = true 表示被低位（i+1）借了个 1
    // isNum = true 表示之前填的数位，两个数都无前导零
    private long dfs(int i, boolean borrowed, boolean isNum) {
        if (i < 0) {
            // borrowed 必须为 false
            return borrowed ? 0 : 1;
        }
        int ib = borrowed ? 1 : 0;
        int in = isNum ? 1 : 0;
        if (memo[i][ib][in] != -1) return memo[i][ib][in];

        int d = s[i] - '0' - (borrowed ? 1 : 0);
        long res = 0;
        // 情况一：两个数位都不为 0
        if (isNum) {
            res = dfs(i - 1, false, true) * twoSumWays(d); // 不向高位借 1
            res += dfs(i - 1, true, true) * twoSumWays(d + 10); // 向高位借 1
        }
        // 情况二：其中一个数位填前导零
        if (i < s.length - 1) { // 不能是最低位
            if (d != 0) {
                // 如果 d < 0，必须向高位借 1
                // 如果 isNum = true，根据对称性，方案数要乘以 2
                res += dfs(i - 1, d < 0, false) * (isNum ? 2 : 1);
            } else if (i == 0) { // 两个数位都填 0，只有当 i = 0 的时候才有解
                res++;
            }
        }
        return memo[i][ib][in] = res;
    }

    // 返回两个 1~9 的整数和为 target 的方案数
    private int twoSumWays(int target) {
        return Math.max(Math.min(target - 1, 19 - target), 0); // 保证结果非负
    }
}
/*
3704. 统计和为 N 的无零数对
https://leetcode.cn/problems/count-no-zero-pairs-that-sum-to-n/description/

第 470 场周赛 T4。

一个 无零 整数是一个十进制表示中 不包含数字 0 的 正 整数。
给定一个整数 n，计算满足以下条件的数对 (a, b) 的数量：
- a 和 b 都是 无零 整数。
- a + b = n
返回一个整数，表示此类数对的数量。
提示:
2 <= n <= 10^15

从低到高的数位 DP
https://leetcode.cn/problems/count-no-zero-pairs-that-sum-to-n/solutions/3798539/cong-di-wang-gao-de-shu-wei-dppythonjava-r8dh/
rating 2429 (clist.by)
 */