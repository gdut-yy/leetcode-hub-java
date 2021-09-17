public class Solution98 {
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
98. 验证二叉搜索树
https://leetcode-cn.com/problems/validate-binary-search-tree/

前序遍历。注意需要开到 Long
 */