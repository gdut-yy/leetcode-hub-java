import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        inorder(root, resList);
        return resList;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        // 中序遍历
        list.add(root.val);
        inorder(root.right, list);
    }
}
/*
94. 二叉树的中序遍历
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
