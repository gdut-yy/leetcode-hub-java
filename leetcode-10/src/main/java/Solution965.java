public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        return traverse(root, root.val);
    }

    private boolean traverse(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val == value) {
            return traverse(root.left, value) && traverse(root.right, value);
        }
        return false;
    }
}
/*
965. 单值二叉树
https://leetcode-cn.com/problems/univalued-binary-tree/

第 117 场周赛 T1。
递归判断即可。
 */