public class SolutionI0405 {
    public boolean isValidBST(TreeNode root) {
        // -2^31 <= Node.val <= 2^31 - 1
        return postOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean postOrder(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return postOrder(root.left, left, root.val) && postOrder(root.right, root.val, right);
    }
}
/*
面试题 04.05. 合法二叉搜索树
https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/

实现一个函数，检查一棵二叉树是否为二叉搜索树。

同: 98. 验证二叉搜索树
https://leetcode-cn.com/problems/validate-binary-search-tree/
 */