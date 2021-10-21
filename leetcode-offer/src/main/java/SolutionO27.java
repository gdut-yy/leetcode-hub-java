public class SolutionO27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历 swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
/*
剑指 Offer 27. 二叉树的镜像
https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9

镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1

同: 226. 翻转二叉树
https://leetcode-cn.com/problems/invert-binary-tree/
 */