public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历 swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
/*
226. 翻转二叉树
https://leetcode-cn.com/problems/invert-binary-tree/

     4                4
   /   \            /   \
  2     7    =>    7     2
 / \   / \        / \   / \
1   3 6   9      9   6 3   1

前缀（或后缀）遍历交换左右叶子节点即可
 */