import java.util.Arrays;

public class Solution3892 {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if (k > n / 2) return -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[(i - 1 + n) % n] < nums[i] && nums[i] > nums[(i + 1) % n]) {
                cnt++;
            }
        }
        // 优化：已经有至少 k 个峰值了，无需操作
        if (cnt >= k) return 0;

        // 如果 nums[0] 是峰值，那么 nums[n-1] 不是峰值
        int[] a = new int[n + 1];
        a[0] = nums[n - 1];
        System.arraycopy(nums, 0, a, 1, n);
        int ans1 = solve(a, k);

        // 如果 nums[0] 不是峰值
        int[] b = new int[n + 1];
        System.arraycopy(nums, 0, b, 0, n);
        b[n] = nums[0];
        int ans2 = solve(b, k);

        return Math.min(ans1, ans2);
    }

    // 非环形版本
    public int solve(int[] a, int k) {
        int n = a.length;
        int[][] memo = new int[k + 1][n - 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(k, n - 2, a, memo);
    }

    // 返回使 [0,i+1] 包含 left 个峰值的最小操作次数
    private int dfs(int left, int i, int[] a, int[][] memo) {
        if (left == 0) {
            return 0;
        }
        if (left > (i + 1) / 2) { // [0,i+1] 至多有 (i+1)/2 个峰值
            return Integer.MAX_VALUE / 2; // 防止加法溢出
        }
        if (memo[left][i] != -1) return memo[left][i];
        // 选或不选
        int notChoose = dfs(left, i - 1, a, memo);
        int choose = dfs(left - 1, i - 2, a, memo) + Math.max(Math.max(a[i - 1], a[i + 1]) - a[i] + 1, 0);
        int res = Math.min(notChoose, choose);

        return memo[left][i] = res;
    }
}
/*
3892. 产生至少 K 个峰值的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-achieve-at-least-k-peaks/description/

第 496 场周赛 T4。

给你一个长度为 n 的循环整数数组 nums。
如果下标 i 对应的值 严格大于 其相邻元素，则该下标是一个 峰值 ：
- 如果 i > 0，下标 i 的 前一个 相邻元素是 nums[i - 1]，否则是 nums[n - 1]。
- 如果 i < n - 1，下标 i 的 后一个 相邻元素是 nums[i + 1]，否则是 nums[0]。
你可以执行以下操作 任意 次数：
- 选择任意下标 i 并将 nums[i] 增加 1。
返回使数组包含 至少 k 个峰值所需的 最小 操作数。如果不可能，返回 -1。
提示：
2 <= n == nums.length <= 5000
-10^5 <= nums[i] <= 10^5
0 <= k <= n

环形打家劫舍
https://leetcode.cn/problems/minimum-operations-to-achieve-at-least-k-peaks/solutions/3945005/zuo-fa-lei-si-huan-xing-da-jia-jie-she-p-yu7j/
时间复杂度 O(k(n−2k)) 或 O(kn)。
 */