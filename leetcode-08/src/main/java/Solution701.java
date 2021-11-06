public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }
}
/*
701. 二叉搜索树中的插入操作
https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/

给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */