import java.util.Arrays;

public class Solution3489 {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0; // nums 全为 0

        int n = nums.length;
        boolean[][] f = new boolean[n][];
        for (int i = 0; i < n; i++) {
            f[i] = new boolean[nums[i] + 1];
            f[i][0] = true;
        }

        for (int k = 0; k < queries.length; k++) {
            int[] q = queries[k];
            int val = q[2];
            for (int i = q[0]; i <= q[1]; i++) {
                if (f[i][nums[i]]) continue; // 小优化：已经满足要求，不计算
                for (int j = nums[i]; j >= val; j--) {
                    f[i][j] = f[i][j] || f[i][j - val];
                }
            }
            // if all Ture
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (!f[i][nums[i]]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return k + 1;
        }
        return -1;
    }
}
/*
3489. 零数组变换 IV
https://leetcode.cn/problems/zero-array-transformation-iv/description/

第 441 场周赛 T3。

给你一个长度为 n 的整数数组 nums 和一个二维数组 queries ，其中 queries[i] = [li, ri, vali]。
每个 queries[i] 表示以下操作在 nums 上执行：
- 从数组 nums 中选择范围 [li, ri] 内的一个下标子集。
- 将每个选中下标处的值减去 正好 vali。
零数组 是指所有元素都等于 0 的数组。
返回使得经过前 k 个查询（按顺序执行）后，nums 转变为 零数组 的最小可能 非负 值 k。如果不存在这样的 k，返回 -1。
数组的 子集 是指从数组中选择的一些元素（可能为空）。
提示：
1 <= nums.length <= 10
0 <= nums[i] <= 1000
1 <= queries.length <= 1000
queries[i] = [li, ri, vali]
0 <= li <= ri < nums.length
1 <= vali <= 10

0-1 背包。
时间复杂度 O(qnU)。
 */
