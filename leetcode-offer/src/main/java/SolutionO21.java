public class SolutionO21 {
    public int[] exchange(int[] nums) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // left 找偶数
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            // right 找奇数
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            // swap
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

双指针。
 */
