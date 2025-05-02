import java.util.Arrays;
import java.util.Comparator;

public class Solution3534 {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(i -> nums[i]));

        // rank[i] 表示 nums[i] 是 nums 中的第几小，或者说节点 i 在 idx 中的下标
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[ids[i]] = i;
        }

        // 双指针，从第 i 小的数开始，向左一步，最远能跳到第 left 小的数
        int mx = 32 - Integer.numberOfLeadingZeros(n);
        int[][] pa = new int[n][mx];
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (nums[ids[i]] - nums[ids[left]] > maxDiff) {
                left++;
            }
            pa[i][0] = left;
        }

        // 倍增
        for (int i = 0; i < mx - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = pa[p][i];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            if (l == r) { // 不用跳
                continue;
            }
            l = rank[l];
            r = rank[r];
            if (l > r) {
                int tmp = l;
                l = r;
                r = tmp; // 保证 l 在 r 左边
            }
            // 从 r 开始，向左跳到 l
            int res = 0;
            for (int k = mx - 1; k >= 0; k--) {
                if (pa[r][k] > l) {
                    res |= 1 << k;
                    r = pa[r][k];
                }
            }
            ans[qi] = pa[r][0] > l ? -1 : res + 1; // 再跳一步就能到 l
        }
        return ans;
    }
}
/*
3534. 针对图的路径存在性查询 II
https://leetcode.cn/problems/path-existence-queries-in-a-graph-ii/description/

第 447 场周赛 T4。

给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。
同时给你一个长度为 n 的整数数组 nums，以及一个整数 maxDiff。
如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。
此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，找到节点 ui 和节点 vi 之间的 最短距离 。如果两节点之间不存在路径，则返回 -1。
返回一个数组 answer，其中 answer[i] 是第 i 个查询的结果。
注意：节点之间的边是无权重（unweighted）的。
提示：
1 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^5
0 <= maxDiff <= 10^5
1 <= queries.length <= 10^5
queries[i] == [ui, vi]
0 <= ui, vi < n

排序+双指针+倍增
https://leetcode.cn/problems/path-existence-queries-in-a-graph-ii/solutions/3663266/pai-xu-shuang-zhi-zhen-bei-zeng-pythonja-ckht/
时间复杂度 O((n+q)logn)。
rating 2509 (clist.by)
 */