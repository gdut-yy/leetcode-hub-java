public class Solution124 {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        postorder(root, maxSum);
        return maxSum[0];
    }

    private int postorder(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, postorder(root.left, maxSumLeft));
        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, postorder(root.right, maxSumRight));

        maxSum[0] = Math.max(Math.max(maxSumLeft[0], maxSumRight[0]), root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
/*
124. 二叉树中的最大路径和
https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/

 -10
 / \
9   20
   /  \
  15   7

15 + 20 + 7 = 42

后序遍历
 */