import java.util.ArrayList;
import java.util.List;

public class Solution3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<Integer> discontinuityPoints = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > maxDiff) {
                discontinuityPoints.add(i); // 间断点
            }
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int[] p = queries[i];
            ans[i] = (lowerBound(discontinuityPoints, p[0]) == lowerBound(discontinuityPoints, p[1]));
        }
        return ans;
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3532. 针对图的路径存在性查询 I
https://leetcode.cn/problems/path-existence-queries-in-a-graph-i/description/

第 447 场周赛 T2。

给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。
同时给你一个长度为 n 的整数数组 nums，该数组按 非递减 顺序排序，以及一个整数 maxDiff。
如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。
此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，需要判断节点 ui 和 vi 之间是否存在路径。
返回一个布尔数组 answer，其中 answer[i] 等于 true 表示在第 i 个查询中节点 ui 和 vi 之间存在路径，否则为 false。
提示：
1 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^5
nums 按 非递减 顺序排序。
0 <= maxDiff <= 10^5
1 <= queries.length <= 10^5
queries[i] == [ui, vi]
0 <= ui, vi < n

间断点 + 二分查找
时间复杂度 O(n + qlogn)。
 */