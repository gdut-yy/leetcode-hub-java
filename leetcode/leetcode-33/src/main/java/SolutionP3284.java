public class SolutionP3284 {
    private static final int MOD = (int) (1e9 + 7);

    public int getSum(int[] nums) {
        long ans = nums[0];
        int l = 0;
        long curr_seqs = nums[0];
        int curr_dir = 1;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            int last = nums[i - 1];
            if (last + curr_dir == v) {
                // seq continue
                curr_seqs = (curr_seqs + (i + 1L - l) * v) % MOD;
            } else if (last - curr_dir == v) {
                // seq change
                l = i - 1;
                curr_seqs = last + v * 2L;
                curr_dir = -curr_dir;
            } else {
                // seq end
                l = i;
                curr_seqs = v;
                curr_dir = 1;
            }
            ans = (ans + curr_seqs) % MOD;
        }
        return (int) ans;
    }
}
/*
$3284. 连续子数组的和
https://leetcode.cn/problems/sum-of-consecutive-subarrays/description/

如果一个长度为 n 的数组 arr 符合下面其中一个条件，可以称它 连续：
- 对于所有的 1 <= i < n，arr[i] - arr[i - 1] == 1。
- 对于所有的 1 <= i < n，arr[i] - arr[i - 1] == -1。
数组的 值 是其元素的和。
例如，[3, 4, 5] 是一个值为 12 的连续数组，并且 [9, 8] 是另一个值为 17 的连续数组。而 [3, 4, 3] 和 [8, 6] 都不连续。
给定一个整数数组 nums，返回所有 连续 子数组 的 值 之和。
由于答案可能很大，返回它对 10^9 + 7 取模 的值。
注意 长度为 1 的数组也被认为是连续的。
Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

以当前位置结束的连续子数组的和 = 上一位置结束的同方向的连续子数组的和 + 当前元素 * 当前最长连续长度。最后答案是所有位置的连续子数组和再求和。遇到新元素时有三种可能情况：
延续上一个元素的连续方向，连续子数组和按照上面方式递增
和上一个元素的方向相反，连续子数组和变成last + 2 * current
和上一个元素不连续，连续子数组和变成current
全部处理好就很容易算出结果了。
https://leetcode.cn/problems/sum-of-consecutive-subarrays/solutions/3704566/dp-by-ling-jian-2012-bys5/
相似题目: $3299. 连续子序列的和
https://leetcode.cn/problems/sum-of-consecutive-subsequences/description/
 */