import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return preorder(root, targetSum, map, 0);
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
437. 路径总和 III
https://leetcode-cn.com/problems/path-sum-iii/

前序遍历
 */