public class Solution3566 {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        for (int msk = 0; msk < 1 << (n - 1); msk++) {
            long prod1 = 1;
            long prod2 = 1;
            for (int i = 0; i < n; i++) {
                if ((msk & (1 << i)) != 0) {
                    prod1 *= nums[i];
                } else {
                    prod2 *= nums[i];
                }
                if (prod1 > target || prod2 > target) break;
            }
            if (prod1 == prod2 && prod1 == target) return true;
        }
        return false;
    }
}
/*
3566. 等积子集的划分方案
https://leetcode.cn/problems/partition-array-into-two-equal-product-subsets/description/

第 452 场周赛 T1。

给你一个整数数组 nums，其中包含的正整数 互不相同 ，另给你一个整数 target。
请判断是否可以将 nums 分成两个 非空、互不相交 的 子集 ，并且每个元素必须  恰好 属于 一个 子集，使得这两个子集中元素的乘积都等于 target。
如果存在这样的划分，返回 true；否则，返回 false。
子集 是数组中元素的一个选择集合。
提示：
3 <= nums.length <= 12
1 <= target <= 10^15
1 <= nums[i] <= 100
nums 中的所有元素互不相同。

二进制枚举。
时间复杂度 O(n * 2^n)。
 */