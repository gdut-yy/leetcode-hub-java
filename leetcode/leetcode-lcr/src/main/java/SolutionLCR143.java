public class SolutionLCR143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
/*
LCR 143. 子结构判断
https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/description/

给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
例如:
给定的树 A:
     3
    / \
   4   5
  / \
 1   2
给定的树 B：
   4
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
提示：
0 <= 节点个数 <= 10000
 */