public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }

    private int preorder(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return preorder(root.left, path) + preorder(root.right, path);
    }
}
/*
129. 求根节点到叶节点数字之和
https://leetcode.cn/problems/sum-root-to-leaf-numbers/

  1
 / \
2   3
12 + 13 = 25
前序遍历
 */