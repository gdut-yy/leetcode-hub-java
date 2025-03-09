import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3462 {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            for (int li = 0; li < limits[i]; li++) {
                int j = m - 1 - li;
                topK.add(grid[i][j]);
            }
        }
        topK.sort(Comparator.reverseOrder());

        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += topK.get(i);
        }
        return ans;
    }
}
/*
3462. 提取至多 K 个元素的最大总和
https://leetcode.cn/problems/maximum-sum-with-at-most-k-elements/description/

第 438 场周赛 T2。

给你一个大小为 n x m 的二维矩阵 grid ，以及一个长度为 n 的整数数组 limits ，和一个整数 k 。你的目标是从矩阵 grid 中提取出 至多 k 个元素，并计算这些元素的最大总和，提取时需满足以下限制：
- 从 grid 的第 i 行提取的元素数量不超过 limits[i] 。
返回最大总和。
提示：
n == grid.length == limits.length
m == grid[i].length
1 <= n, m <= 500
0 <= grid[i][j] <= 10^5
0 <= limits[i] <= m
0 <= k <= min(n * m, sum(limits))

贪心。
 */