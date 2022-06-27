import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        postorder(root, resList);
        return resList;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        // 后序遍历
        list.add(root.val);
    }
}
/*
145. 二叉树的后序遍历
https://leetcode.cn/problems/binary-tree-postorder-traversal/

给定一个二叉树，返回它的 后序 遍历。
 */
