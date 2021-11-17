public class SolutionI0408 {
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
面试题 04.08. 首个共同祖先
https://leetcode-cn.com/problems/first-common-ancestor-lcci/

设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

同: 235. 二叉搜索树的最近公共祖先
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
236. 二叉树的最近公共祖先
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */