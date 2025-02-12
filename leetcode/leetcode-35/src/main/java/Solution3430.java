import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution3430 {
    public long minMaxSubarraySum(int[] nums, int k) {
        long ans = sumSubarrayMins(nums, k);
        // 所有元素取反，就可以复用同一份代码求最大值的贡献了
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        ans -= sumSubarrayMins(nums, k);
        return ans;
    }

    // 计算最小值的贡献
    private long sumSubarrayMins(int[] nums, int k) {
        int n = nums.length;
        // 左边界 left[i] 为左侧严格小于 nums[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        Arrays.fill(left, -1);
        // 右边界 right[i] 为右侧小于等于 nums[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵，方便赋值 left
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[i] <= nums[st.peek()]) {
                right[st.pop()] = i; // i 是栈顶的右边界
            }
            left[i] = st.peek();
            st.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int l = left[i];
            int r = right[i];
            if (r - l - 1 <= k) {
                long cnt = (long) (i - l) * (r - i);
                res += x * cnt; // 累加贡献
            } else {
                // @b站二叉堆 先算所有不超过k的数目，再减去不包含i的数目，前者是在长r-l+1里选不超过k，后者分别是在i-l和r-i里选不超过k，都是形如长为n的区间里选长度不超过k的子区间的方案数，用最简单的等差数列求和就能计算

                l = Math.max(l, i - k);
                r = Math.min(r, i + k);
                // 左端点 > r-k 的子数组个数
                long cnt = (long) (r - i) * (i - (r - k));
                // 左端点 <= r-k 的子数组个数
                long cnt2 = (l + r + k - i * 2L + 1) * (r - l - k) / 2;
                res += x * (cnt + cnt2); // 累加贡献
            }
        }
        return res;
    }
}
/*
3430. 最多 K 个元素的子数组的最值之和
https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/description/

第 433 场周赛 T4。

给你一个整数数组 nums 和一个 正 整数 k 。 返回 最多 有 k 个元素的所有子数组的 最大 和 最小 元素之和。
子数组 是数组中的一个连续、非空 的元素序列。
提示：
1 <= nums.length <= 80000
1 <= k <= nums.length
-10^6 <= nums[i] <= 10^6

贡献法 + 单调栈。
相似题目: 907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/
3428. 最多 K 个元素的子序列的最值之和
https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/description/
rating 2659 (clist.by)
 */