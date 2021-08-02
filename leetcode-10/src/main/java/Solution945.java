import java.util.Arrays;

public class Solution945 {
    public int minIncrementForUnique(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increase = nums[i - 1] - nums[i] + 1;
                nums[i] += increase;
                cnt += increase;
            }
        }
        return cnt;
    }
}
/*
945. 使数组唯一的最小增量
https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/

第 112 场周赛 T1。
排序后，后一个数 增加到刚好大于 前一个数 即可。
排序时间复杂度 O(nlogn)
 */