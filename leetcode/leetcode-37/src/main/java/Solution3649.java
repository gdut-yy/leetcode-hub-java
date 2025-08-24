import java.util.Arrays;

public class Solution3649 {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(nums[i]);
        }
        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int L = lowerBound(a, (a[i] + 1) / 2);
            int R = lowerBound(a, a[i] * 2 + 1);
            ans += R - L - 1;
        }
        return ans / 2;
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
3649. 完美对的数目
https://leetcode.cn/problems/number-of-perfect-pairs/description/

第 163 场双周赛 T2。

给你一个整数数组 nums。
如果一对下标 (i, j) 满足以下条件，则称其为 完美 的：
- i < j
- 令 a = nums[i]，b = nums[j]。那么：
  - min(|a - b|, |a + b|) <= min(|a|, |b|)
  - max(|a - b|, |a + b|) >= max(|a|, |b|)
返回 不同 完美对 的数量。
注意：绝对值 |x| 指的是 x 的 非负 值。
提示:
2 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

猜规律。对于绝对值 x，能组成数对的范围为 [ceil(x/2), 2x]，注意减去自身和除以2。
排序 + 二分搜索 找左右端点。
时间复杂度 O(nlogn)。
 */