import java.util.ArrayList;
import java.util.List;

public class Solution971 {
    private int[] voyage;
    private int idx;
    private List<Integer> ans;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        idx = 0;
        ans = new ArrayList<>();

        dfs(root);
        if (!ans.isEmpty() && ans.get(0) == -1) {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (node.val != voyage[idx++]) {
            ans.clear();
            ans.add(-1);
            return;
        }
        if (idx < voyage.length && node.left != null
                && node.left.val != voyage[idx]) {
            ans.add(node.val);
            dfs(node.right);
            dfs(node.left);
        } else {
            dfs(node.left);
            dfs(node.right);
        }
    }
}
/*
971. 翻转二叉树以匹配先序遍历
https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/description/

给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
提示：
树中的节点数目为 n
n == voyage.length
1 <= n <= 100
1 <= Node.val, voyage[i] <= n
树中的所有值 互不相同
voyage 中的所有值 互不相同

DFS.
 */