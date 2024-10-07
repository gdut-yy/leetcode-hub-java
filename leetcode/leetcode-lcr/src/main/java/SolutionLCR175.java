import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionLCR175 {
    public int calculateDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode o = q.remove();
                if (o.left != null) q.add(o.left);
                if (o.right != null) q.add(o.right);
            }
            level++;
        }
        return level;
    }
}
/*
LCR 175. 计算二叉树的深度
https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/

某公司架构以二叉树形式记录，请返回该公司的层级数。
提示：
节点总数 <= 10000

同: 104. 二叉树的最大深度
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */