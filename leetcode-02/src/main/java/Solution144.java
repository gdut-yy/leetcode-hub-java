import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        preorder(root, resList);
        return resList;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 前序遍历
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
/*
144. 二叉树的前序遍历
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */