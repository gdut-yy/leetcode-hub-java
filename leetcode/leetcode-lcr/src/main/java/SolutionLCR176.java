public class SolutionLCR176 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
/*
LCR 176. 判断是否为平衡二叉树
https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
提示：
0 <= 树的结点个数 <= 10000

同: 110. 平衡二叉树
https://leetcode.cn/problems/balanced-binary-tree/
 */