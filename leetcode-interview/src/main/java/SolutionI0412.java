import java.util.HashMap;
import java.util.Map;

public class SolutionI0412 {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return preorder(root, sum, map, 0);
    }

    private int preorder(TreeNode root, int targetSum, Map<Integer, Integer> map, int path) {
        if (root == null) {
            return 0;
        }
        path += root.val;
        int cnt = map.getOrDefault(path - targetSum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        cnt += preorder(root.left, targetSum, map, path);
        cnt += preorder(root.right, targetSum, map, path);
        map.put(path, map.get(path) - 1);
        return cnt;
    }
}
/*
面试题 04.12. 求和路径
https://leetcode-cn.com/problems/paths-with-sum-lcci/

给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。

同: 437. 路径总和 III
https://leetcode-cn.com/problems/path-sum-iii/
 */