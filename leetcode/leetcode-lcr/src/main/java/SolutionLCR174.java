import java.util.ArrayList;
import java.util.List;

public class SolutionLCR174 {
    public int findTargetNode(TreeNode root, int cnt) {
        List<Integer> resList = new ArrayList<>();
        reverseInorder(root, cnt, resList);
        return resList.get(cnt - 1);
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
LCR 174. 寻找二叉搜索树中的目标节点
https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
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