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
437. 路径总和 III
https://leetcode-cn.com/problems/path-sum-iii/

后序遍历
 */