import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3939 {
    private static final int MOD = (int) (1e9 + 7);

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }

        long[][] res = dfs(0, g, nums, k);

        // 恰好被 k 整除即模 k 为 0，注意减去空集的方案数 1
        return (int) ((res[0][0] + res[1][0] - 1 + MOD) % MOD);
    }

    private long[][] dfs(int x, List<Integer>[] g, int[] nums, int k) {
        long[] f0 = new long[k]; // f0[i] 表示不选 x 时，子树 x 的子集点权和模 k 为 i 的方案数
        long[] f1 = new long[k]; // f1[i] 表示选 x 时，子树 x 的子集点权和模 k 为 i 的方案数
        f0[0] = 1;
        f1[nums[x] % k] = 1;

        for (int y : g[x]) {
            long[][] resY = dfs(y, g, nums, k);
            long[] fy0 = resY[0];
            long[] fy1 = resY[1];

            // 不选 x，那么 y 可选可不选
            long[] nf0 = new long[k];
            for (int i = 0; i < k; i++) { // 枚举从子树 y 中选出的点权和模 k 为 i
                long v = fy0[i] + fy1[i];
                if (v == 0) { // 优化
                    continue;
                }
                for (int j = 0; j < k; j++) { // 枚举从之前的子树中选出的点权和模 k 为 j
                    int s = (i + j) % k;
                    nf0[s] = (nf0[s] + v * f0[j]) % MOD;
                }
            }

            // 选 x，那么 y 不能选
            long[] nf1 = new long[k];
            for (int i = 0; i < k; i++) { // 枚举从子树 y 中选出的点权和模 k 为 i
                long v = fy0[i];
                if (v == 0) { // 优化
                    continue;
                }
                for (int j = 0; j < k; j++) { // 枚举从 x 以及之前的子树中选出的点权和模 k 为 j
                    int s = (i + j) % k;
                    nf1[s] = (nf1[s] + v * f1[j]) % MOD;
                }
            }

            f0 = nf0;
            f1 = nf1;
        }

        return new long[][]{f0, f1};
    }
}
/*
3939. 统计有根树中不相邻子集的数目
https://leetcode.cn/problems/count-non-adjacent-subsets-in-a-rooted-tree/description/

第 183 场双周赛 T4。

给你一棵有 n 个节点的有根树，节点编号从 0 到 n - 1 ，由一个长度为 n 的整数数组 parent 表示，其中：
- parent[0] = -1 （节点 0 是根节点）。
- 对于每个 1 <= i < n ，parent[i] 是节点 i 的父节点（0 <= parent[i] < i）。
另外给你一个长度为 n 的整数数组 nums ，其中 nums[i] 是节点 i 的值，以及一个整数 k。
如果节点的一个非空子集满足以下条件，则称为 有效 子集：
- 所选节点的值之 和 可以被 k 整除 。
- 所选节点中没有 两 个节点在树中是 相邻 的（即没有节点及其直接父节点同时包含在子集中）。
返回有效子集的数量对 10^9 + 7 取余的结果。
提示：
n == parent.length == nums.length
1 <= n <= 1000
parent[0] == -1
对于所有的 1 <= i < n：
0 <= parent[i] < i
1 <= nums[i] <= 10^9
1 <= k <= 100
parent 表示一棵有效的有根树。

树上独立集 + 树上背包。
 */