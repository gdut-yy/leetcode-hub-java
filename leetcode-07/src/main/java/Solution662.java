import java.util.HashMap;
import java.util.Map;

public class Solution662 {
    private int max;
    private Map<Integer, Integer> leftMap;

    public int widthOfBinaryTree(TreeNode root) {
        max = 0;
        leftMap = new HashMap<>();
        dfs(root, 0, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        leftMap.putIfAbsent(depth, pos);
        max = Math.max(max, pos - leftMap.get(depth) + 1);
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }
}
/*
662. 二叉树最大宽度
https://leetcode.cn/problems/maximum-width-of-binary-tree/

给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
注意: 答案在32位有符号整数的表示范围内。

宽 = 层最右 - 层最左 + 1
 */