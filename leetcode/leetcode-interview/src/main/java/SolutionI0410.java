public class SolutionI0410 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}
/*
面试题 04.10. 检查子树
https://leetcode.cn/problems/check-subtree-lcci/

检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
注意：此题相对书上原题略有改动。

同: 572. 另一棵树的子树
https://leetcode.cn/problems/subtree-of-another-tree/
 */