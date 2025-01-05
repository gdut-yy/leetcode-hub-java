import java.util.Arrays;

public class Solution3375 {
    public int minOperations(int[] nums, int k) {
        int[] a = Arrays.stream(nums).distinct().sorted().toArray();
        int i = lowerBound(a, k);
        if (i > 0) return -1;
        return a.length - i - (a[i] == k ? 1 : 0);
    }

    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3375. 使数组的值全部为 K 的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/description/

第 145 场双周赛 T1。

给你一个整数数组 nums 和一个整数 k 。
如果一个数组中所有 严格大于 h 的整数值都 相等 ，那么我们称整数 h 是 合法的 。
比方说，如果 nums = [10, 8, 10, 8] ，那么 h = 9 是一个 合法 整数，因为所有满足 nums[i] > 9 的数都等于 10 ，但是 5 不是 合法 整数。
你可以对 nums 执行以下操作：
- 选择一个整数 h ，它对于 当前 nums 中的值是合法的。
- 对于每个下标 i ，如果它满足 nums[i] > h ，那么将 nums[i] 变为 h 。
你的目标是将 nums 中的所有元素都变为 k ，请你返回 最少 操作次数。如果无法将所有元素都变 k ，那么返回 -1 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100

去重后排序。
首先不能有 < k 的数。
 */