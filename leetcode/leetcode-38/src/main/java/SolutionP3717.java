import java.util.Arrays;

public class SolutionP3717 {
    private static final int INF = (int) 1e9;

    public int minOperations(int[] nums) {
        int n = nums.length;
        int m = Arrays.stream(nums).max().orElseThrow();
        int threshold = 2 * m;
        // f[i][j] 表示当数组 nums 的下标 i 的元素变成 j 时的美丽数组的下标范围 [0,i] 的总操作次数最小值
        int[][] f = new int[n][threshold + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][nums[0]] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = nums[i]; j <= threshold; j++) {
                int cur = INF;
                for (int k = nums[i - 1]; k <= j; k++) {
                    if (j % k == 0) {
                        cur = Math.min(cur, f[i - 1][k] + j - nums[i]);
                    }
                }
                f[i][j] = cur;
            }
        }
        return Arrays.stream(f[n - 1]).min().orElseThrow();
    }
}
/*
$3717. 使数组变美的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-make-the-array-beautiful/description/

给定一个整数数组 nums。
如果对于每个索引 i > 0，nums[i] 的值能被 nums[i - 1] 整除，则该数组称为 美丽 数组。
在一次操作中，你可以给任何元素 nums[i] （其中 i > 0）增加 1。
返回使数组变美的 最小操作数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 50

动态规划。
贪心不行的，比如 [5, 13, 18]，如果用贪心会改成 [5, 15, 30]，需要操作14次。但是如果改成 [6, 18, 18]，只需操作 9 次。
时间复杂度：O(nm^2)，其中 n 是数组 nums 的长度，m 是数组 nums 中的最大元素。
 */