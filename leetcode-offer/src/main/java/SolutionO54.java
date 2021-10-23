import java.util.ArrayList;
import java.util.List;

public class SolutionO54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> resList = new ArrayList<>();
        reverseInorder(root, k, resList);
        return resList.get(k - 1);
    }

    /**
     * 中序遍历倒序
     */
    private void reverseInorder(TreeNode root, int k, List<Integer> resList) {
        if (root == null) {
            return;
        }
        reverseInorder(root.right, k, resList);
        resList.add(root.val);
        if (resList.size() == k) {
            return;
        }
        reverseInorder(root.left, k, resList);
    }
}
/*
剑指 Offer 54. 二叉搜索树的第k大节点
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

给定一棵二叉搜索树，请找出其中第k大的节点。

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4

二叉搜索树的 中序遍历 为 递增序列
二叉搜索树的 中序遍历倒序 为 递减序列
 */