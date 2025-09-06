public class SolutionP3353 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) ans++;
        }
        return ans;
    }

}
/*
$3353. 最小总操作数
https://leetcode.cn/problems/minimum-total-operations/description/

给定一个整数数组 nums，你可以在这个数组上进行 任意 次操作。
在每次 操作 中，你可以：
- 选择这个数组的一个 前缀。
- 选择一个整数 k（可以为负）并且对选中前缀的每一个元素加 k。
数组的 前缀 是一个子数组，从数组的开头开始并延伸到数组内的任何位置。
返回使 arr 中的所有元素都相等的 最小 操作数。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

脑筋急转弯。
看相邻不相等元素的个数。
时间复杂度 O(n)。
 */