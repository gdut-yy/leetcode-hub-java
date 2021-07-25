public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        return isIncrArr(nums) || isDecrArr(nums);
    }

    /**
     * 单调递增
     */
    private boolean isIncrArr(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单调递减
     */
    private boolean isDecrArr(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
/*
896. 单调数列
https://leetcode-cn.com/problems/monotonic-array/

第 100 场周赛 T1。
分别判断 单调递增 或 单调递减 即可。|| 自带剪枝
 */