public class Solution124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int pathSum = root.val + left + right;
        max = Math.max(max, pathSum);
        return root.val + Math.max(left, right);
    }
}
/*
124. 二叉树中的最大路径和
https://leetcode.cn/problems/binary-tree-maximum-path-sum/

路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
提示：
树中节点数目范围是 [1, 3 * 10^4]
-1000 <= Node.val <= 1000

输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 -10
 / \
9   20
   /  \
  15   7
15 + 20 + 7 = 42
后序遍历
 */