public class SolutionI0406 {
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
面试题 04.06. 后继者
https://leetcode-cn.com/problems/successor-lcci/

设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
如果指定节点没有对应的“下一个”节点，则返回null。

同: $285. 二叉搜索树中的中序后继
https://leetcode-cn.com/problems/inorder-successor-in-bst/
 */