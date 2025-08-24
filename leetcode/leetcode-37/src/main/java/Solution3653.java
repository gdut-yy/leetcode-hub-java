public class Solution3653 {
    private static final int MOD = (int) (1e9 + 7);

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                a[i] = (a[i] * v) % MOD;
            }
        }

        long ans = 0;
        for (long v : a) ans ^= v;
        return (int) ans;
    }
}
/*
3653. 区间乘法查询后的异或 I
https://leetcode.cn/problems/xor-after-range-multiplication-queries-i/description/

第 463 场周赛 T2。

给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。
对于每个查询，按以下步骤执行操作：
- 设定 idx = li。
- 当 idx <= ri 时：
  - 更新：nums[idx] = (nums[idx] * vi) % (10^9 + 7)
  - 将 idx += ki。
在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。
提示：
1 <= n == nums.length <= 10^3
1 <= nums[i] <= 10^9
1 <= q == queries.length <= 10^3
queries[i] = [li, ri, ki, vi]
0 <= li <= ri < n
1 <= ki <= n
1 <= vi <= 10^5

模拟。
时间复杂度 O(nq)。
 */