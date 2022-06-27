public class SolutionO68_2 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        rootContainsPQ(root, p, q);
        return ans;
    }

    /**
     * root 节点子树中是否包含 p 节点或 q 节点
     */
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
剑指 Offer 68 - II. 二叉树的最近公共祖先
https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

同: 236. 二叉树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */