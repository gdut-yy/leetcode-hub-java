public class Solution236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        rootContainsPQ(root, p, q);
        return ans;
    }

    // root 节点子树中是否包含 p 节点或 q 节点
    private boolean rootContainsPQ(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSon = rootContainsPQ(root.left, p, q);
        boolean rightSon = rootContainsPQ(root.right, p, q);
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) && (leftSon || rightSon))) {
            ans = root;
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }
}
/*
236. 二叉树的最近公共祖先
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
提示：
树中节点数目在范围 [2, 10^5] 内。
-10^9 <= Node.val <= 10^9
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。

不失一般性的 LCA 解法。
时间复杂度 O(n)
空间复杂度 O(n)
 */