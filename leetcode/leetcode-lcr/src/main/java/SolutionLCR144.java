public class SolutionLCR144 {
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
LCR 144. 翻转二叉树
https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/

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
提示：
树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100

同: 226. 翻转二叉树
https://leetcode.cn/problems/invert-binary-tree/
 */