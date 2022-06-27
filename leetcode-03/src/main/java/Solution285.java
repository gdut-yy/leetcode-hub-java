public class Solution285 {
    /**
     * 剑指 Offer II 053. 二叉搜索树中的中序后继
     * https://leetcode.cn/problems/P5rCT8/
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
/*
$285. 二叉搜索树中的中序后继
https://leetcode.cn/problems/inorder-successor-in-bst/

时间复杂度 O(h)
空间复杂度 O(1)
 */