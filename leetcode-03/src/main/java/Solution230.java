import java.util.ArrayList;
import java.util.List;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, k, inorderList);
        return inorderList.get(k - 1);
    }

    private void inorder(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, list);
        // 中序遍历
        if (list.size() >= k) {
            return;
        }
        list.add(root.val);

        inorder(root.right, k, list);
    }
}
/*
230. 二叉搜索树中第K小的元素
https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/

给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

预备知识: 二叉搜索树的中序遍历是按照键增加的顺序进行的。
 */