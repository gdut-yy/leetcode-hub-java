import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SolutionO34 {
    List<List<Integer>> resList = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preorder(root, targetSum);
        return resList;
    }

    private void preorder(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            resList.add(new LinkedList<>(path));
        }
        preorder(root.left, targetSum);
        preorder(root.right, targetSum);
        path.pollLast();
    }
}
/*
剑指 Offer 34. 二叉树中和为某一值的路径
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

同: 113. 路径总和 II
https://leetcode-cn.com/problems/path-sum-ii/
 */