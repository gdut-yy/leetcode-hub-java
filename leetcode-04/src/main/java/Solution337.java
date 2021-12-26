import java.util.HashMap;
import java.util.Map;

public class Solution337 {
    // root 为 key 被选取时的最大值
    Map<TreeNode, Integer> dp0 = new HashMap<>();
    // root 为 key 不被选取时的最大值
    Map<TreeNode, Integer> dp1 = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(dp0.getOrDefault(root, 0), dp1.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        // 动态规划
        // dp0(root) = root.val + dp1(root.left) + dp1(root.right)
        // dp1(root) = max(dp0(root.left), dp1(root.left)) + max(dp0(root.right), dp1(root.right))
        dp0.put(root, root.val + dp1.getOrDefault(root.left, 0) + dp1.getOrDefault(root.right, 0));
        dp1.put(root, Math.max(dp0.getOrDefault(root.left, 0), dp1.getOrDefault(root.left, 0))
                + Math.max(dp0.getOrDefault(root.right, 0), dp1.getOrDefault(root.right, 0)));
    }
}
/*
337. 打家劫舍 III
https://leetcode-cn.com/problems/house-robber-iii/

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

动态规划。
 */