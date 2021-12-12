import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5935 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        // 预处理，满足记为 1，计算前缀和
        int[] nums1 = new int[len];
        int[] nums2 = new int[len];
        // 第 i 天前连续 time 天警卫数目都是非递增的。
        for (int i = 1; i < len; i++) {
            if (security[i] <= security[i - 1]) {
                nums1[i] = 1;
            }
        }
        // 第 i 天后连续 time 天警卫数目都是非递减的。
        for (int i = 0; i < len - 1; i++) {
            if (security[i] <= security[i + 1]) {
                nums2[i] = 1;
            }
        }

        // 前缀和
        PrefixSum prefixSum1 = new PrefixSum(nums1);
        PrefixSum prefixSum2 = new PrefixSum(nums2);

        List<Integer> part1 = new ArrayList<>();
        for (int i = time; i < len; i++) {
            if (prefixSum1.rangeSum(i - time + 1, i) == time) {
                part1.add(i);
            }
        }
        if (part1.size() == 0) {
            return part1;
        }
        List<Integer> part2 = new ArrayList<>();
        for (int i = 0; i <= len - time; i++) {
            if (prefixSum2.rangeSum(i, i + time - 1) == time) {
                part2.add(i);
            }
        }
        Set<Integer> set1 = new HashSet<>(part1);
        Set<Integer> set2 = new HashSet<>(part2);
        set1.retainAll(set2);
        return new ArrayList<>(set1);
    }

    private static class PrefixSum {
        private final int[] preSum;

        public PrefixSum(int[] nums) {
            int len = nums.length;
            preSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        /**
         * 求 nums[i] 到 nums[j] 的累加和
         */
        public int rangeSum(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }
}
/*
5935. 适合打劫银行的日子
https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/

第 67 场双周赛 T2。

你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。
日子从 0 开始编号。同时给你一个整数 time 。
如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
- 第 i 天前和后都分别至少有 time 天。
- 第 i 天前连续 time 天警卫数目都是非递增的。
- 第 i 天后连续 time 天警卫数目都是非递减的。
更正式的，第 i 天是一个合适打劫银行的日子当且仅当：
security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。

范围 10^5
时间复杂度 O(n)
前缀和分别求出满足两种 非递增 和 非递减 两个集合，再求集合交集
 */