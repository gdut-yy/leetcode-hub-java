public class Solution1909 {
    public boolean canBeIncreasing(int[] nums) {
        // 拥有一次删除机会
        boolean isDeleted = false;
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果当前并不是严格递增
            if (nums[i] >= nums[i + 1]) {
                // 注意这里有两种选择 删除下标 i 或者删除下标 i+1:

                // 删除下标 i 后达不到严格递增（注意 i-1 下标边界）
                boolean delINotIncr = (i - 1 >= 0) && (nums[i + 1] <= nums[i - 1]);
                // 删除下标 i+1 后达不到严格递增（注意 i+2 下标边界）
                boolean delIp1NotIncr = (i + 2 <= nums.length - 1) && (nums[i + 2] <= nums[i]);

                // 如果删除机会已使用 或 以上两种方式删除方式均不满足，返回 false
                if (isDeleted || (delINotIncr && delIp1NotIncr)) {
                    return false;
                }
                // 用掉一次删除机会
                isDeleted = true;
            }
        }
        return true;
    }
}
/*
1909. 删除一个元素使数组严格递增
https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing/

第 55 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。
如果数组本身已经是严格递增的，请你也返回 true 。
数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。

枚举任意下标对 (i, i+1) 均满足严格递增。当不满足时，可以选择删除 (i, i+1) 之一并判断删除后是否满足严格递增。
 */
