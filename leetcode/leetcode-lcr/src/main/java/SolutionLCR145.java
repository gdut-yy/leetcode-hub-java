public class SolutionLCR145 {
    public boolean checkSymmetricTree(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
/*
LCR 145. 判断对称二叉树
https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/

请设计一个函数判断一棵二叉树是否 轴对称 。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
提示：
0 <= 节点个数 <= 1000

同: 101. 对称二叉树
https://leetcode.cn/problems/symmetric-tree/
 */