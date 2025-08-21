import java.util.Arrays;

public class Solution3634 {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = n - 1;
        for (int i = 0; i < n; i++) {
            int j = upperBound(nums, (long) k * nums[i]);
            ans = Math.min(ans, i + n - j);
        }
        return ans;
    }

    private int upperBound(int[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3634. 使数组平衡的最少移除数目
https://leetcode.cn/problems/minimum-removals-to-balance-array/description/

第 162 场双周赛 T2。

给你一个整数数组 nums 和一个整数 k。
如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^5

排序 + 二分。
时间复杂度 O(nlogn)。
 */