public class Solution4051 {
    public long distantSubarrays(int[] nums, int goal, int k) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2;
        if (k == 0) return total;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + nums[i];
        long low = (long) goal - k + 1;
        long high = (long) goal + k - 1;
        long[] tmp = new long[n + 1];
        long close = countLE(ps.clone(), 0, n, high, tmp)
                - countLE(ps.clone(), 0, n, low - 1, tmp);
        return total - close;
    }

    private long countLE(long[] p, int lo, int hi, long x, long[] tmp) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        long res = countLE(p, lo, mid, x, tmp) + countLE(p, mid + 1, hi, x, tmp);
        int q = lo;
        for (int r = mid + 1; r <= hi; r++) {
            while (q <= mid && p[q] < p[r] - x) q++;
            res += mid - q + 1;
        }
        int i = lo, j = mid + 1, t = lo;
        while (i <= mid && j <= hi) tmp[t++] = p[i] <= p[j] ? p[i++] : p[j++];
        while (i <= mid) tmp[t++] = p[i++];
        while (j <= hi) tmp[t++] = p[j++];
        for (int s = lo; s <= hi; s++) p[s] = tmp[s];
        return res;
    }
}
/*
4051. 统计遥远子数组的数目
https://leetcode.cn/problems/count-subarrays-with-distant-sums/description/

第 519 场周赛 T4。

给你一个整数数组 nums ，以及两个整数 goal 和 k 。
如果一个 子数组 nums[i..j] 满足其元素和与 goal 之间的 绝对差至少 为 k ，则称其为 遥远的 。
返回 遥远的 子数组的数量。
子数组 是数组中连续的非空元素序列。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
-10^9 <= goal <= 10^9
0 <= k <= 10^9

CDQ 分治 / 归并排序统计
时间复杂度 O(nlogn)。
 */