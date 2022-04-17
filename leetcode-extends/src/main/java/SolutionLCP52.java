import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SolutionLCP52 {
    public int getNumber(TreeNode root, int[][] ops) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, treeSet);
        Set<Integer> redSet = new HashSet<>();

        // 从后往前
        int len = ops.length;
        for (int i = len - 1; i >= 0; i--) {
            Set<Integer> subSet = new HashSet<>(treeSet.subSet(ops[i][1], true, ops[i][2], true));
            if (ops[i][0] == 1) {
                redSet.addAll(subSet);
            }
            treeSet.removeAll(subSet);
        }
        return redSet.size();
    }

    private void dfs(TreeNode root, TreeSet<Integer> treeSet) {
        if (root == null) {
            return;
        }
        treeSet.add(root.val);
        dfs(root.left, treeSet);
        dfs(root.right, treeSet);
    }
}
/*
LCP 52. 二叉搜索树染色
https://leetcode-cn.com/problems/QO5KpG/

LCCUP 力扣杯 2022 春季编程大赛个人赛 T3。

欢迎各位勇者来到力扣城，本次试炼主题为「二叉搜索树染色」。
每位勇士面前设有一个二叉搜索树的模型，模型的根节点为 root，树上的各个节点值均不重复。初始时，所有节点均为蓝色。
现在按顺序对这棵二叉树进行若干次操作， ops[i] = [type, x, y] 表示第 i 次操作为：
- type 等于 0 时，将节点值范围在 [x, y] 的节点均染蓝
- type 等于 1 时，将节点值范围在 [x, y] 的节点均染红
请返回完成所有染色后，该二叉树中红色节点的数量。
注意：
题目保证对于每个操作的 x、y 值定出现在二叉搜索树节点中
提示：
1 <= 二叉树节点数量 <= 10^5
1 <= ops.length <= 10^5
ops[i].length == 3
ops[i][0] 仅为 0 or 1
0 <= ops[i][1] <= ops[i][2] <= 10^9
0 <= 节点值 <= 10^9
 */