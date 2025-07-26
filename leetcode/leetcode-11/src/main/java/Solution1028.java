public class Solution1028 {
    private char[] s;
    private int n, i;

    public TreeNode recoverFromPreorder(String traversal) {
        s = traversal.toCharArray();
        n = s.length;
        i = 0;
        return dfs(0);
    }

    private TreeNode dfs(int level) {
        // 从 i 开始构建 level 层的子树
        int x = 0, h = 0;
        int j = i;
        for (; j < n && s[j] == '-'; ++j) ++h;
        if (h < level) return null;   // 非当前层节点 直接返回

        for (; j < n && Character.isDigit(s[j]); ++j) x = x * 10 + (s[j] - '0');

        // 是当前层节点
        i = j;  // 更新i
        TreeNode node = new TreeNode(x);
        node.left = dfs(level + 1);
        node.right = dfs(level + 1);
        return node;
    }
}
/*
1028. 从先序遍历还原二叉树
https://leetcode.cn/problems/recover-a-tree-from-preorder-traversal/description/

我们从二叉树的根节点 root 开始进行深度优先搜索。
在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
如果节点只有一个子节点，那么保证该子节点为左子节点。
给出遍历输出 S，还原树并返回其根节点 root。
提示：
原始树中的节点数介于 1 和 1000 之间。
每个节点的值介于 1 和 10 ^ 9 之间。

递归版本 https://leetcode.cn/problems/recover-a-tree-from-preorder-traversal/solutions/292136/cong-xian-xu-bian-li-huan-yuan-er-cha-shu-by-leetc/comments/2391035/
时间复杂度：O(|traversal|)，其中 |traversal| 是字符串 traversal 的长度。
 */