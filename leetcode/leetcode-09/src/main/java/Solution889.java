public class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[postorder[i]] = i;
        }
        return dfs(preorder, 0, n, 0, index); // 左闭右开区间
    }

    // 注意 postR 可以省略
    private TreeNode dfs(int[] preorder, int preL, int preR, int postL, int[] index) {
        if (preL == preR) { // 空节点
            return null;
        }
        if (preL + 1 == preR) { // 叶子节点
            return new TreeNode(preorder[preL]);
        }
        int leftSize = index[preorder[preL + 1]] - postL + 1; // 左子树的大小
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, postL, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, postL + leftSize, index);
        return new TreeNode(preorder[preL], left, right);
    }
}
/*
889. 根据前序和后序遍历构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/

给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
如果存在多个答案，您可以返回其中 任何 一个。
提示：
1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
preorder 中所有值都 不同
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
postorder 中所有值都 不同
保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历

从 O(n^2) 到 O(n) https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/2649218/tu-jie-cong-on2-dao-onpythonjavacgojsrus-h0o5/
时间复杂度 O(n)。
 */
