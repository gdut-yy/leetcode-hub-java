import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3509 {
    private int[] nums;
    private int k, limit;
    private Set<String> memo;
    private int ans = -1;

    public int maxProduct(int[] nums, int k, int limit) {
        this.nums = nums;
        this.k = k;
        this.limit = limit;
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(k)) return -1;

        memo = new HashSet<>();
        dfs(0, 0, 1, false, true);
        return ans;
    }

    // s:加法单位元是 0
    // m:乘法单位元是 1
    private void dfs(int i, int s, int m, boolean odd, boolean empty) {
        if (ans == limit) return; // 已经达到最大值
        if (i == nums.length) {
            if (!empty && s == k && m <= limit) {
                ans = Math.max(ans, m);
            }
            return;
        }

        String key = i + ":" + s + ":" + m + ":" + odd + ":" + empty;
        if (!memo.add(key)) return;
        // 不选 x
        dfs(i + 1, s, m, odd, empty);
        // 选 x
        int x = nums[i];
        dfs(i + 1, s + (odd ? -x : x), Math.min(m * x, limit + 1), !odd, false);
    }
}
/*
3509. 最大化交错和为 K 的子序列乘积
https://leetcode.cn/problems/maximum-product-of-subsequences-with-an-alternating-sum-equal-to-k/description/

第 444 场周赛 T3。

给你一个整数数组 nums 和两个整数 k 与 limit，你的任务是找到一个非空的 子序列，满足以下条件：
- 它的 交错和 等于 k。
- 在乘积 不超过 limit 的前提下，最大化 其所有数字的乘积。
返回满足条件的子序列的 乘积 。如果不存在这样的子序列，则返回 -1。
子序列 是指可以通过删除原数组中的某些（或不删除）元素并保持剩余元素顺序得到的新数组。
交错和 是指一个 从下标 0 开始 的数组中，偶数下标 的元素之和减去 奇数下标 的元素之和。
提示：
1 <= nums.length <= 150
0 <= nums[i] <= 12
-10^5 <= k <= 10^5
1 <= limit <= 5000

暴力出奇迹：如何分析状态个数
https://leetcode.cn/problems/maximum-product-of-subsequences-with-an-alternating-sum-equal-to-k/solutions/3641716/bao-li-sou-suo-by-endlesscheng-j3bl/
150 个 [1,12] 中的数相乘，只有 M=394 个 ≤5000 的不同乘积。
rating 2677 (clist.by)
 */