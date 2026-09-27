import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP3879 {
    private long ans = Long.MIN_VALUE;
    private Map<TreeNode, TreeNode> parentMap;

    public int maxSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        parentMap = new HashMap<>();
        buildParent(root, null);
        reroot(root);
        return (int) ans;
    }

    private void buildParent(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }

    private void reroot(TreeNode node) {
        if (node == null) {
            return;
        }
        calc(node);
        reroot(node.left);
        reroot(node.right);
    }

    private void calc(TreeNode root) {
        Set<Integer> vis = new HashSet<>();
        dfs(root, 0, vis);
    }

    private void dfs(TreeNode node, long s, Set<Integer> vis) {
        if (node == null) {
            return;
        }
        int v = node.val;
        if (vis.contains(v)) {
            return;
        }
        vis.add(v);
        s += v;
        ans = Math.max(ans, s);
        dfs(node.left, s, vis);
        dfs(node.right, s, vis);
        dfs(parentMap.get(node), s, vis);
        vis.remove(v);
    }
}
/*
$3879. 二叉树中的最大不同路径和
https://leetcode.cn/problems/maximum-distinct-path-sum-in-a-binary-tree/description/

给定一棵 二叉树 的 root，其中每个节点包含一个整数值。
树中的 有效 路径是指一系列 相连 的节点，使得：
- 路径可以在树中的 任意节点 开始和结束。
- 路径 不 需要经过根节点。
- 路径上的所有节点值都是 不同 的。
返回一个整数，表示所有有效路径中节点值的 最大 可能总和。
示例 1：
输入：root = [2,2,1]
输出：3
示例 2：
输入：root = [1,-2,5,null,null,3,5]
输出：9
示例 3：
输入：root = [4,6,6,null,null,null,9]
输出：19
提示：
树中的节点数范围为 [1, 1000]。
-1000 <= Node.val <= 1000
 */