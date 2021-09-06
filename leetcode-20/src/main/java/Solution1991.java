import java.util.Arrays;

public class Solution1991 {
    public int findMiddleIndex(int[] nums) {
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
1991. 找到数组的中间位置
https://leetcode-cn.com/problems/find-the-middle-index-in-array/

第 60 场双周赛 T1。
同第 724 题 寻找数组的中心下标 https://leetcode-cn.com/problems/find-pivot-index/
 */