import java.util.Arrays;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = sorted[j];
            if (i + 1 < n) {
                nums[i + 1] = sorted[k];
            }
        }
    }
}
/*
324. 摆动排序 II
https://leetcode.cn/problems/wiggle-sort-ii/

给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
你可以假设所有输入数组都可以得到满足题目要求的结果。
提示：
1 <= nums.length <= 5 * 10^4
0 <= nums[i] <= 5000
题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？

相似题目: $280. 摆动排序
https://leetcode.cn/problems/wiggle-sort/
 */