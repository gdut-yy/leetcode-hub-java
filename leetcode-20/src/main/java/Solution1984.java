import java.util.Arrays;

public class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
/*
1984. 学生分数的最小差值
https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

第 256 场周赛 T1。
排序后 固定大小的滑动窗口比较差值
时间复杂度 O(nlogn)
 */