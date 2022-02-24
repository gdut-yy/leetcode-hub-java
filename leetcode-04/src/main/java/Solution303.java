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

给定一个整数数组  nums，处理以下类型的多个查询:
1. 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：
- NumArray(int[] nums) 使用数组 nums 初始化对象
- int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )

前缀和。
 */