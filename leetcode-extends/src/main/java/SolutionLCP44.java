import java.util.HashSet;
import java.util.Set;

public class SolutionLCP44 {
    public int numColor(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        preorder(root, set);
        return set.size();
    }

    private void preorder(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        preorder(root.left, set);
        preorder(root.right, set);
    }
}
/*
LCP 44. 开幕式焰火
https://leetcode-cn.com/problems/sZ59z6/

LCCUP 力扣杯 2021 秋季编程大赛战队赛 T1。

「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
提示：
1 <= 节点个数 <= 1000
1 <= Node.val <= 1000

前序遍历。
 */