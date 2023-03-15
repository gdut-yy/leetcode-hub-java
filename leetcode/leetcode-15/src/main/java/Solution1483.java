public class Solution1483 {
    static class TreeAncestor {
        private final int[][] dp;
        private final int maxIteration;

        public TreeAncestor(int n, int[] parent) {
            // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html#numberOfLeadingZeros(int)
            // ceil(log2(x)) = 32 - numberOfLeadingZeros(x - 1)
            maxIteration = 32 - Integer.numberOfLeadingZeros(n - 1);

            dp = new int[n][maxIteration];
            for (int i = 0; i < n; i++) {
                dp[i][0] = parent[i];
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < maxIteration; ++j) {
                    dp[i][j] = (dp[i][j - 1] == -1) ? -1 : dp[dp[i][j - 1]][j - 1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            if (node == -1 || k == 0) {
                return node;
            }
            // 计算最高一位对应的是哪一位，由于这个结果一定是 2 的幂，因此直接使用 Integer.numberOfTrailingZero 来计算结尾有几个 0，也就是到底是几次方
            int highestBit = Integer.highestOneBit(k);
            int power = Integer.numberOfTrailingZeros(highestBit);
            if (power >= maxIteration) {
                return -1;
            }
            return getKthAncestor(dp[node][power], k & (~highestBit));
        }
    }
}
/*
1483. 树节点的第 K 个祖先
https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/

给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
实现 TreeAncestor 类：
- TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
- getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
提示：
1 <= k <= n <= 5 * 10^4
parent[0] == -1 表示编号为 0 的节点是根节点。
对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
0 <= node < n
至多查询 5 * 10^4 次

倍增法求 LCA
 */