import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1696 {
    private int[] nums;
    private int k;
    private int[] memo;

    // O(nk) TLE
    public int maxResult2(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums.length - 1);
    }

    private int dfs(int i) {
        if (i == 0) return nums[0];
        if (memo[i] != -1) return memo[i];
        int mx = Integer.MIN_VALUE;
        for (int j = Math.max(i - k, 0); j < i; j++) {
            mx = Math.max(mx, dfs(j));
        }
        return memo[i] = mx + nums[i];
    }

    // O(n) 单调队列优化
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        // f[i] 表示到达位置 i 的最大得分
        int[] f = new int[n];
        f[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0); // 哨兵
        for (int i = 1; i < n; i++) {
            while (dq.peekFirst() < i - k) dq.removeFirst();
            f[i] = f[dq.peekFirst()] + nums[i];
            while (!dq.isEmpty() && f[dq.peekLast()] <= f[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return f[n - 1];
    }
}
/*
1696. 跳跃游戏 VI
https://leetcode.cn/problems/jump-game-vi/description/

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
请你返回你能得到的 最大得分 。
提示：
 1 <= nums.length, k <= 10^5
-10^4 <= nums[i] <= 10^4

单调队列优化 DP。
时间复杂度 O(n)。
 */