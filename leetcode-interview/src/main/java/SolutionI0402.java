public class SolutionI0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
/*
面试题 04.02. 最小高度树
https://leetcode-cn.com/problems/minimum-height-tree-lcci/

给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

同: 108. 将有序数组转换为二叉搜索树
https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */