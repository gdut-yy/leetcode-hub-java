public class SolutionLCP67 {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root.left != null) {
            TreeNode tmp = root.left;
            root.left = new TreeNode(-1);
            root.left.left = expandBinaryTree(tmp);
        }
        if (root.right != null) {
            TreeNode tmp = root.right;
            root.right = new TreeNode(-1);
            root.right.right = expandBinaryTree(tmp);
        }
        return root;
    }
}
/*
LCP 67. 装饰树
https://leetcode.cn/problems/KnLfVT/

LCCUP'22 力扣杯秋季编程大赛战队赛 T2。

力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
- 完成装饰的二叉树根结点与 root 的根结点值相同
- 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 - 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 - 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
提示：
0 <= root.Val <= 1000
root 节点数量范围为 [1, 10^5]

递归。
 */