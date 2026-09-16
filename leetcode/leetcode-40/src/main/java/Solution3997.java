public class Solution3997 {
    private int ans;

    public int countDominantNodes(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        int subMax = Math.max(node.val, Math.max(leftMax, rightMax));
        if (node.val == subMax) ans++;
        return subMax;
    }
}
/*
3997. 统计二叉树中支配节点的数量
https://leetcode.cn/problems/count-dominant-nodes-in-a-binary-tree/description/

第 511 场周赛 T2。

给你一棵 完全二叉树 的根节点 root。
如果节点 x 的值等于以 x 为根的子树中所有节点值的 最大值，则称节点 x 为 支配节点 。
返回给定树中 支配节点 的数量。
完全二叉树 是指除最后一层外，其余各层都被完全填满，并且最后一层的所有节点都尽可能靠左排列的二叉树。
树中以节点 x 为根的 子树 由节点 x 及其所有后代节点组成。
提示：
树中的节点数量在范围 [1, 10^5] 内。
1 <= Node.val <= 10^9
保证给定的树是一棵完全二叉树。

DFS。
时间复杂度 O(n)。
 */