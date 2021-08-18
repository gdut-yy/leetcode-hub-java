public class Solution303 {
    static class NumArray {
        private final int[] preSum;

        /**
         * 使用数组 nums 初始化对象
         *
         * @param nums nums
         */
        public NumArray(int[] nums) {
            int len = nums.length;
            preSum = new int[len + 1];
            preSum[0] = 0;
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        /**
         * 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和
         *
         * @param left  i
         * @param right j
         * @return 数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和
         */
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
/*
303. 区域和检索 - 数组不可变
https://leetcode-cn.com/problems/range-sum-query-immutable/

前缀和。
 */