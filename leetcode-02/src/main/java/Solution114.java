public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 后缀遍历
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树作为右子树
        root.left = null;
        root.right = left;
        // 将原先的右子树接到当前右子树的末端
        TreeNode rootNode = root;
        while (rootNode.right != null) {
            rootNode = rootNode.right;
        }
        rootNode.right = right;
    }
}
/*
114. 二叉树展开为链表
https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

   1
  / \
 2   5
/ \   \
3  4   6

=>

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

二叉树后序遍历
 */