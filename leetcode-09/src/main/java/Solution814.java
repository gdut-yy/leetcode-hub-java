public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
/*
814. 二叉树剪枝
https://leetcode-cn.com/problems/binary-tree-pruning/

后序遍历
 */
