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
https://leetcode.cn/problems/validate-binary-search-tree/

给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
- 节点的左子树只包含 小于 当前节点的数。
- 节点的右子树只包含 大于 当前节点的数。
- 所有左子树和右子树自身必须也是二叉搜索树。
提示：
树中节点数目范围在[1, 10^4] 内
-2^31 <= Node.val <= 2^31 - 1

前序遍历。注意需要开到 Long
 */