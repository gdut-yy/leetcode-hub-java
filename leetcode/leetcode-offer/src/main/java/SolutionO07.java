import java.util.HashMap;
import java.util.Map;

public class SolutionO07 {
    private Map<Integer, Integer> idxMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
剑指 Offer 07. 重建二叉树
https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/

输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

同: 105. 从前序与中序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */