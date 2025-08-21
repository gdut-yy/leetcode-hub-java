public class Solution3637 {
    public boolean isTrionic(int[] nums) {
        int n = nums.length - 1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i + 1] - nums[i] > 0) a[i] = 1;
            else if (nums[i + 1] - nums[i] < 0) a[i] = -1;
            else return false;
        }

        int i = 0;
        int st = i;
        for (; i < n && a[i] == 1; i++) {
        }
        if (i - st < 1) return false;

        st = i;
        for (; i < n && a[i] == -1; i++) {
        }
        if (i - st < 1) return false;

        st = i;
        for (; i < n && a[i] == 1; i++) {
        }
        if (i - st < 1) return false;

        return i == n;
    }
}
/*
3637. 三段式数组 I
https://leetcode.cn/problems/trionic-array-i/description/

第 461 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
nums[0...p] 严格 递增，
nums[p...q] 严格 递减，
nums[q...n − 1] 严格 递增。
如果 nums 是三段式数组，返回 true；否则，返回 false。
提示:
3 <= n <= 100
-1000 <= nums[i] <= 1000

分组循环。
时间复杂度 O(n)。
 */