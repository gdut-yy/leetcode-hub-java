import java.util.Arrays;

public class Solution3444 {
    private static final long INF = (long) 1e18;
    private long[] lcms;
    private long[][] memo;

    public int minimumIncrements(int[] nums, int[] target) {
        int n = nums.length;
        int m = target.length;

        // 预处理 target 的所有子集的 LCM
        lcms = new long[1 << m];
        lcms[0] = 1;
        for (int i = 0; i < m; i++) {
            int bit = 1 << i;
            for (int mask = 0; mask < bit; mask++) {
                lcms[bit | mask] = getLCM(target[i], lcms[mask]);
            }
        }

        memo = new long[n][1 << m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) dfs(n - 1, (1 << m) - 1, nums);
    }

    private long dfs(int i, int j, int[] nums) {
        if (j == 0) return 0;
        if (i < 0) { // 不能有剩余元素
            return INF;
        }
        if (memo[i][j] != -1) return memo[i][j];
        long res = dfs(i - 1, j, nums); // 不修改 nums[i]
        for (int sub = j; sub > 0; sub = (sub - 1) & j) { // 枚举 j 的所有非空子集
            long l = lcms[sub];
            res = Math.min(res, dfs(i - 1, j ^ sub, nums) + (l - nums[i] % l) % l);
        }
        return memo[i][j] = res;
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private long getLCM(long num1, long num2) {
        return num1 / getGCD(num1, num2) * num2;
    }
}
/*
3444. 使数组包含目标值倍数的最少增量
https://leetcode.cn/problems/minimum-increments-for-target-multiples-in-an-array/description/

第 435 场周赛 T3。

给你两个数组 nums 和 target 。
在一次操作中，你可以将 nums 中的任意一个元素递增 1 。
返回要使 target 中的每个元素在 nums 中 至少 存在一个倍数所需的 最少操作次数 。
提示：
1 <= nums.length <= 5 * 10^4
1 <= target.length <= 4
target.length <= nums.length
1 <= nums[i], target[i] <= 10^4

子集状压 DP：记忆化搜索。
rating 2346 (clist.by)
 */