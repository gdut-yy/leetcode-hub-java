public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
/*
700. 二叉搜索树中的搜索
https://leetcode-cn.com/problems/search-in-a-binary-search-tree/

给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */