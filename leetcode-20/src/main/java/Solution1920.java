public class Solution1920 {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
/*
1920. 基于排列构建数组
https://leetcode-cn.com/problems/build-array-from-permutation/

周赛签到题。ans[i] = nums[nums[i]
 */
