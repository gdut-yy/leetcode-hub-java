import java.util.HashMap;
import java.util.Map;

public class SolutionLCR124 {
    private Map<Integer, Integer> idxMap;

    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }
        int inRoot = idxMap.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        int cntLeft = inRoot - inLeft;
        root.left = myBuildTree(preorder, preLeft + 1, preLeft + cntLeft, inLeft);
        root.right = myBuildTree(preorder, preLeft + cntLeft + 1, preRight, inRoot + 1);
        return root;
    }
}
/*
LCR 124. 推理二叉树
https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/description/

某二叉树的先序遍历结果记录于整数数组 preorder，它的中序遍历结果记录于整数数组 inorder。请根据 preorder 和 inorder 的提示构造出这棵二叉树并返回其根节点。
注意：preorder 和 inorder 中均不含重复数字。
提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列

同: 105. 从前序与中序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */