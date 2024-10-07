import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionLCR153 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        preorder(root, target);
        return ans;
    }

    private void preorder(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        preorder(root.left, targetSum);
        preorder(root.right, targetSum);
        path.pollLast();
    }
}
/*
LCR 153. 二叉树中和为目标值的路径
https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
提示：
树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

同: 113. 路径总和 II
https://leetcode.cn/problems/path-sum-ii/
 */