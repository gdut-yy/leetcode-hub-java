import java.util.Arrays;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum - nums[i] == sum - leftSum) {
                return i;
            }
        }
        return -1;
    }
}
/*
724. 寻找数组的中心下标
https://leetcode-cn.com/problems/find-pivot-index/

时间复杂度 O(n)
空间复杂度 O(1)
 */